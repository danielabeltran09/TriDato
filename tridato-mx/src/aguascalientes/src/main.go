package main

import (
	"Aguascalientes"
	"AreaID"
	"fmt"
	"log"
	"sync"
	"time"

	"gopkg.in/cheggaaa/pb.v1"

	"github.com/jinzhu/gorm"
	_ "github.com/jinzhu/gorm/dialects/mysql"
)

func main() {
	time.Sleep(time.Second * 30)
	db, err := gorm.Open("mysql", "username:password@tcp(database:3306)/dev?charset=utf8&parseTime=True&loc=Local")
	if err != nil {
		log.Println("ERROR CONNECTING DB ", err)
		log.Fatal("Shutting Down")
	}
	db.Table("Aguascalientes")
	defer db.Close()

	availableAreas := checkAvailableAreas()
	//var wg sync.WaitGroup
	//wg.Add(64)
	// AVAILABLE GROUP AREAS(JUZGADOS)
	const timeLayout string = "02/01/2006"

	var currentTime time.Time = time.Now()
	currentTime = currentTime.AddDate(0, 0, -1)
	currentTime = currentTime.AddDate(0, 0, -1)
	lowerDateLimit, _ := time.Parse(timeLayout, "01/01/2017")
	for ; currentTime.After(lowerDateLimit); currentTime = currentTime.AddDate(0, 0, -1) {

		if currentTime.Weekday() == 0 || currentTime.Weekday() == 6 {
			// Skip weekends
			continue
		}
		// prepare go routines
		var wg sync.WaitGroup
		wg.Add(len(availableAreas))

		pDate := currentTime.Format(timeLayout)
		for x := 0; x < len(availableAreas); x++ {
			func(x int, pDate string) {
				if len(availableAreas[x]) > 0 {
					// AVAILABLE CATEGORIES INSIDE THE GROUP AREA
					for q := 0; q < len(availableAreas[x]); q++ {
						arr, err := Aguascalientes.GetData(x, availableAreas[x][q], pDate)
						if err == nil {
							for q := 0; q < len(arr); q++ {
								var de Aguascalientes.DataEntry
								de = arr[q]
								isNew := db.NewRecord(de)
								if !isNew {
									log.Printf("This entry already exist, %+v", de)
								} else {
									db.Create(&de)
								}
							}
						} else {
							fmt.Printf("Error from Aguascalientes: %s \n ", err)
						}
					}
				}
				wg.Done()
			}(x, pDate)
		}
		wg.Wait()
	}
}

func checkAvailableAreas() [][]int {
	log.Println("Retrieving corresponding areas: \n ")
	bar := pb.StartNew(65)
	var listAreas = make([][]int, 65)
	for i := 1; i < len(listAreas); i++ {
		arr, err := AreaID.GetGrupoMateriasPorAreaID(i)
		if err != nil {
			// log.Printf("ERROR calling AreaID with %d, %s \n ", i, err)
			// fmt.Printf("[%v , []] ", i)
		} else {
			listAreas[i] = arr
			// fmt.Printf("[%v , %v] ", i, arr)
		}
		bar.Increment()
	}
	bar.FinishPrint("Finished Checking Available Areas")
	return listAreas
}

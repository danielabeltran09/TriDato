package main

import "AreaID"
import "fmt"
import "Aguascalientes"
import "strconv"
import "sync"

func main() {
	availableAreas := checkAvailableAreas()
	//var wg sync.WaitGroup
	for i := 2018; i >= 2016; i-- { // YEARS
		for j := 5; j <= 5; j++ { // MONTHS
			for z := 1; z <= 12; z++ { // DAYS
				//wg.Add(64)
				for x := 0; x < len(availableAreas); x++ { // AVAILABLE GROUP AREAS(JUZGADOS)
					pDate := strconv.Itoa(z) + "/" + strconv.Itoa(j) + "/" + strconv.Itoa(i)
					//			func(x int, pDate string) {
					if len(availableAreas[x]) > 0 {
						for q := 0; q < len(availableAreas[x]); q++ { // AVAILABLE CATEGORIES INSIDE THE GROUP AREA
							arr, err := Aguascalientes.GetData(x, availableAreas[x][q], pDate)
							if err == nil {
								for q := 0; q < len(arr); q++ {
									fmt.Println(arr[q])
								}
							} else {
								//fmt.Printf("Error from Aguascalientes: %s \n ", err)
							}
						}
					}
					//	wg.Done()
					//			}(x, pDate)
				}
			}
		}
		//wg.Wait()
		fmt.Println("Finished")
	}
}

func checkAvailableAreas() [][]int {
	var wg sync.WaitGroup
	var listAreas = make([][]int, 65)
	wg.Add(64)
	for i := 1; i < len(listAreas); i++ {
		go func(i int) {
			arr, err := AreaID.GetGrupoMateriasPorAreaID(i)
			if err != nil {
				//fmt.Printf("ERROR calling AreaID with %d, %s \n ", i, err)
			} else {
				listAreas[i] = arr
				fmt.Println("ready ", i, arr)
			}
			wg.Done()
		}(i)
	}
	wg.Wait()
	fmt.Println("Finished Checking Available areas", listAreas)
	return listAreas
}

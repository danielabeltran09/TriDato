package AreaID

import (
	"encoding/json"
	"errors"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"strconv"
	"strings"
)

type ResponseGetGrupoMateriasPorAreaID []struct {
	Selected bool   `json:"Selected"`
	Text     string `json:"Text"`
	Value    string `json:"Value"`
}

var Directory map[int]int

func GetGrupoMateriasPorAreaID(code int) ([]int, error) {

	url := "http://serviciosweb.poderjudicialags.gob.mx/Majat/Administrador/GetGrupoMateriasPorAreaID"

	payload := strings.NewReader(fmt.Sprintf("areaID=%d&filtrarMateriaUsuario=false", code))

	req, err := http.NewRequest("POST", url, payload)
	if err != nil {
		log.Println("Error building request", err)
		return []int{}, err
	}
	req.Header.Add("Origin", "http://serviciosweb.poderjudicialags.gob.mx")
	req.Header.Add("Accept-Encoding", "gzip, deflate")
	req.Header.Add("Accept-Language", "es-ES,es;q=0.9,en;q=0.8,fr;q=0.7,gl;q=0.6")
	req.Header.Add("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")
	req.Header.Add("Content-Type", "application/x-www-form-urlencoded")
	req.Header.Add("Accept", "application/json, text/javascript, */*; q=0.01")
	req.Header.Add("Referer", "http://serviciosweb.poderjudicialags.gob.mx/Majat/Acuerdos/ListaDeAcuerdos")
	req.Header.Add("X-Requested-With", "XMLHttpRequest")
	req.Header.Add("Connection", "keep-alive")

	res, err := http.DefaultClient.Do(req)
	if err != nil {
		log.Printf("Error making POST request in AreaID, code: %d, res: %s \n", code, res)
		return []int{}, err
	}
	defer res.Body.Close()
	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		log.Fatal("Error reading response body")
		return []int{}, err
	}
	var record ResponseGetGrupoMateriasPorAreaID
	err = json.Unmarshal([]byte(string(body)), &record)
	if err != nil || len(record) < 1 {
		//log.Printf("Error parsing JSON, wanted code for %d but received nothing %s", code, err)
		if err == nil {
			err = errors.New(fmt.Sprintf("The Area ID for %d does not exit", code))
		}
		return []int{}, err
	}

	finalRes := []int{}
	for i := 0; i < len(record); i++ {
		intValue, err := strconv.Atoi(record[i].Value)
		if err != nil {
			return []int{}, err
		} else {
			finalRes = append(finalRes, intValue)
		}
	}

	return finalRes, nil

}

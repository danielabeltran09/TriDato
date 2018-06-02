package Aguascalientes

import "fmt"

import "encoding/json"
import "io/ioutil"
import "log"
import "net/http"
import "strings"
import "time"

type Response struct {
	Success bool   `json:"Success"`
	Message string `json:"Message"`
	Data    struct {
		Publicaciones []struct {
			PublicacionID      int    `json:"PublicacionID"`
			FechaPublicacion   string `json:"FechaPublicacion"`
			UsuarioID          int    `json:"UsuarioID"`
			FechaDictado       string `json:"FechaDictado"`
			FirmaUsuarioID     int    `json:"FirmaUsuarioID"`
			GrupoAreaMateriaID int    `json:"GrupoAreaMateriaID"`
			ListaPDF           string `json:"ListaPDF"`
		} `json:"Publicaciones"`
		Acuerdos                 []DataEntry `json:"Acuerdos"`
		AcuerdosNumeroEquivocado []struct {
			AcuerdoID int    `json:"AcuerdoID"`
			Fecha     string `json:"Fecha"`
			AreaID    int    `json:"AreaID"`
			Firma     string `json:"Firma"`
		} `json:"AcuerdosNumeroEquivocado"`
	} `json:"Data"`
}

type DataEntry struct {
	Extracto                 string        `json:"Extracto"`
	AcuerdoID        int    `json:"AcuerdoID"`
	Numero           int    `json:"Numero"`
	AreaID           int    `json:"AreaID"`
	Documento        string `json:"Documento"`
	Naturaleza       string `json:"Naturaleza"`
	Partes           string `json:"Partes"`
	Extracto         string `json:"Extracto"`
	PermisoVerTexto  bool   `json:"PermisoVerTexto"`
	TipoAcuerdoID    int    `json:"TipoAcuerdoID"`
	FechaPublicacion string `json:"FechaPublicacion"`
	FecDictado       string `json:"FecDictado"`
	// Editar                   bool          `json:"Editar"`
	// DescripcionClasificacion string        `json:"DescripcionClasificacion"`
	// AcuerdosClasificacion    []interface{} `json:"AcuerdosClasificacion"`
	// Archivos                 []interface{} `json:"Archivos"`
	// Publicado                interface{}   `json:"Publicado"`
}

// FOR DEV PURPOSES ONLY
type APIResponse struct {
	Names       []string
	Document    string
	Description string
	Entries     []DataEntry
}

// GetData ... areaID (e.g -> JUZGADO PRIMERO MERCANTIL has a code (int) in the html,
// postDate is the date to query in string 03/05/2018 -> DD/MM/YYYY
// This function returns the data collected during a day in aguascalientes for a specific institution(areaID)
func GetData(areaID int, groupDataID int, postDate string) ([]DataEntry, error) {

	// Initialize empty array of data entries, this object will be returned ath the end of the
	// function
	arrRes := []DataEntry{}

	// Build the request
	url := "http://serviciosweb.poderjudicialags.gob.mx/Majat/Acuerdos/GetListaDeAcuerdos"
	formattedString := fmt.Sprintf("areaID=%d&grupoAreaMateriaID=%d&fechaPublicacion=%s&tipoListaID=1", areaID, groupDataID, postDate)
	payload := strings.NewReader(formattedString)

	req, err := http.NewRequest("POST", url, payload)
	if err != nil {
		log.Fatal("Error building POST request")
		return arrRes, err
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

	// Build the http client, set with timeout of max 20 seconds, a need for goroutines
	timeout := time.Duration(20 * time.Second)
	client := http.Client{
		Timeout: timeout,
	}

	// Run the request
	res, err := client.Do(req)
	if err != nil {
		log.Printf("Error executing POST request in Aguascalientes package, areaID %d , groupDataId %d , postDate %s  ", areaID, groupDataID, postDate)
		return arrRes, err
	}
	defer res.Body.Close()
	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		// The response does not have the expected format, empty register for this request
		//log.Printf("Error reading response body")
		return arrRes, err
	}

	// record object that will contain the response
	var record Response
	err = json.Unmarshal([]byte(string(body)), &record)
	if err != nil {
		log.Fatal("Error parsing JSON (Unmarshal)")
		return arrRes, err
	}

	for i := 0; i < len(record.Data.Acuerdos); i++ {
		// Filther those entries classified as "SECRETO" or similar where no
		// names are included
		if record.Data.Acuerdos[i].Partes != "" {
			arrRes = append(arrRes, record.Data.Acuerdos[i])
		}
	}
	return arrRes, nil
}

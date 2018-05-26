package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"net/http"
	"strings"

	"github.com/gin-gonic/gin"
)

type Response struct {
	Page         int    `json:"page"`
	CodigoError  string `json:"codigo_error"`
	MensajeError string `json:"mensaje_error"`
	Records      int    `json:"records"`
	Rows         []struct {
		CategoriaMatricula   string `json:"categoria_matricula"`
		ClaseIdentificacion  string `json:"clase_identificacion"`
		CodigoCamara         string `json:"codigo_camara"`
		CodigoEstado         string `json:"codigo_estado"`
		Identificacion       string `json:"identificacion"`
		Estado               string `json:"estado"`
		Matricula            string `json:"matricula"`
		NombreCamara         string `json:"nombre_camara"`
		OrganizacionJuridica string `json:"organizacion_juridica"`
		RazonSocial          string `json:"razon_social"`
		Tipo                 string `json:"tipo"`
		EnlaceVer            string `json:"enlaceVer"`
	} `json:"rows"`
}

func main() {
	router := gin.Default()
	router.GET("/rue/:id", func(c *gin.Context) {
		id := c.Param("id")
		c.JSON(http.StatusOK, GetData(id))
	})
	router.Run(":3334")
}

func GetData(id string) Response {

	url := "https://www.rues.org.co/RM/ConsultaNIT_json"

	payload := strings.NewReader(fmt.Sprintf("txtNIT=%s", id))

	req, _ := http.NewRequest("POST", url, payload)

	req.Header.Add("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
	req.Header.Add("origin", "https://www.rues.org.co")
	req.Header.Add("host", "www.rues.org.co")
	req.Header.Add("accept", "*/*")
	req.Header.Add("connection", "keep-alive")
	req.Header.Add("content-length", "15")
	req.Header.Add("accept-encoding", "br, gzip, deflate")
	req.Header.Add("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_4) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/11.1 Safari/605.1.15")
	req.Header.Add("referer", "https://www.rues.org.co/RUES_Web/Consultas/Consultasext")
	req.Header.Add("accept-language", "en-us")
	req.Header.Add("x-requested-with", "XMLHttpRequest")
	req.Header.Add("cache-control", "no-cache")
	req.Header.Add("postman-token", "4a202c9a-1e25-4798-7c94-11c874bb8332")

	res, _ := http.DefaultClient.Do(req)

	defer res.Body.Close()
	body, _ := ioutil.ReadAll(res.Body)

	//fmt.Println(res)
	fmt.Println(string(body))
	var record Response
	err := json.Unmarshal([]byte(string(body)), &record)
	if err != nil {
		log.Fatal("Error parsing JSON Unmarshal")
	}
	fmt.Printf("%s", record.Rows[0].RazonSocial)
	return record
}

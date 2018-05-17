package sipso

import (
	"github.com/PuerkitoBio/goquery"
	"log"
	"net/http"
	"strings"
)

type Citizen struct {
	Curp             string `json:"curp"`
	FirstName        string `json:"first_name"`
	LastName         string `json:"last_name"`
	Birthdate        string `json:"birthdate"`
	BirthInstitution string `json: "birthInstitution"`
}

func GetData(curpID string) Citizen {
	// Request the HTML page.
	res, err := http.Get("http://sipso.sedesol.gob.mx/consultarCurp/consultaCurpR.jsp?cveCurp=" + curpID)
	if err != nil {
		log.Fatal(err)
	}
	defer res.Body.Close()
	if res.StatusCode != 200 {
		log.Fatalf("status code error: %d %s", res.StatusCode, res.Status)
	}

	// Load the HTML document
	doc, err := goquery.NewDocumentFromReader(res.Body)
	if err != nil {
		log.Fatal(err)
	}

	// Find the html items
	var citizenData []string
	doc.Find("td").Each(func(i int, s *goquery.Selection) {
		// For each item found, get the band and title

		sel := s.Text()
		if i%2 == 0 {
			citizenData = append(citizenData, strings.Trim(sel, "  \n "))
		}
	})

	newCitizen := Citizen{citizenData[1], citizenData[4], citizenData[2] + " " + citizenData[3], citizenData[6], citizenData[7]}
	//	fmt.Printf("%+v\n", newCitizen )
	return newCitizen
}

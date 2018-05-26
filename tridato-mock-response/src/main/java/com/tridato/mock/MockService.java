package com.tridato.mock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

/**
 * Created by dbeltran on 5/16/18.
 */
@Controller
@RequestMapping("/mock")
public class MockService {

    @GetMapping("/health")
    @ResponseBody
    public String health() {

        return "Mock is alive ";
    }

    @CrossOrigin(origins = "http://trudata-live.s3-website.us-east-2.amazonaws.com")
    @GetMapping(value = "/query/{id}", produces = "application/json; charset=utf-8")
    @ResponseBody
    public ApiResponse query(@PathVariable("id") final String id) throws IOException {

        AguasCalientesResponse mockReponse;

        // String status, String message, String id, String idRequest, String statusPerson, String judicialBody, String typeSubject, String caseMaterial, String recordNumber, String dateSentence, String name, String text) {

        if (id.equals("CR1234568")) {
            mockReponse = new AguasCalientesResponse("0", "Successful",
                    "231", id, "true",
                    "Primer Tribunal Colegiado de Circuito del Centro Auxiliar de la Segunda Región",
                    "Amparo Directo, Amparo en Revisión, Revisión Fiscal, Recurso de Queja",
                    "Penal",
                    "293/2018",
                    "07/05/2018",
                    "Juliana Rodriguez",
                    "Se niega el Amparo. Delito de homicidio culposo y daño en propiedad ajena (hechos de tránsito); la Sala responsable al resolver la apelación confirmó el fallo de primer grado en el que se condenó al ahora quejoso. Quejoso al omitir hacer alto (marcado por señalamiento) al llegar a la intersección invadió el arroyo vehicular impactando un autobús de transporte público que circulaba con preferencia de paso, provocando conducción inestable que ocasiono que un pasajero saliera proyectado hacia la calle y se impactara contra un poste de madera, lo que le ocasionó la muerte. Conceptos de violación ineficaces, esencialmente reitera los agravios de apelación y este órgano colegiado no advierte motivo que amerite suplirlos en su deficiencia.");

        } else if (id.equals("CR0932355")) {
            mockReponse = new AguasCalientesResponse("0", "Successful",
                    "672", id, "true",
                    "Quinto Tribunal Colegiado del Décimo Quinto Circuito",
                    "Amparo Directo",
                    "Penal",
                    "783/2015",
                    "07/05/2018",
                    "Marcela Castañeda",
                    "MODIFICACIÓN EN SEGUNDA INSTANCIA DE LA REPARACIÓN DEL DAÑO DE LOS DELITOS DE HOMICIDIO POR CULPA Y DAÑO EN PROPIEDAD AJENA POR CULPA.");



        } else if (id.equals("CR87320782")) {

            mockReponse = new AguasCalientesResponse("0", "Successful",
                    "109", id, "false",
                    "Tribunal Colegiado del Vigésimo Tercer Circuito",
                    "Amparo Directo",
                    "Penal",
                    "783/2015",
                    "07/05/2018",
                    "Elizabeth Parra",
                    "TEMA: Homicidio calificado por haberse ejecutado con ventaja y el lugar concurrido por personas ajenas a los hechos que pudieron resultar lesionadas o muertas.");


        } else if (id.equals("CT62881282")) {
            mockReponse = new AguasCalientesResponse("0", "Successful",
                    "654", id, "false",
                    "Primer Tribunal Colegiado de Circuito del Centro Auxiliar de la Decimoprimera Región, con residencia en Coatzacoalcos, Veracruz",
                    "Amparo Directo, Amparo en Revisión, Revisión Fiscal, Recurso de Queja",
                    "Penal",
                    "783/2015",
                    "07/05/2018",
                    "Armando Zamara",
                    "Auto de vinculación a proceso por el delito de homicidio calificado. Medida cautelar de prisión preventiva oficiosa. La materia de estudio se limitó a esta última. Los conceptos de agravio expuestos por la parte ofendida, ahora recurrente, resultaron parcialmente fundados, pues aun cuando contrario a lo determinado por el Juez de Distrito, el Juez de Control no debía analizar la idoneidad y proporcionalidad de la medida, subsistió el punto de concesión relativo al análisis de la razonabilidad del plazo de duración de su imposición, en virtud que ello no fue controvertido por la recurrente. Confirma y ampara.");

        }
        else if (id.equals("ERROR")) {
            mockReponse = new AguasCalientesResponse("1", "An error has occurred consulting Aguas Calientes database",
                    "", id, "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "");
        }
        else {
            mockReponse = new AguasCalientesResponse("0", "Successful",
                    "", id, "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "");

        }
        return mockReponse;

    }
}

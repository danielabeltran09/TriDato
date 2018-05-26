package com.tridato.mock;

/**
 * Created by dbeltran on 5/16/18.
 */
public class AguasCalientesResponse extends ApiResponse {

    private String judicialBody;

    private String typeSubject;

    private String caseMaterial;

    private String recordNumber;

    private String dateSentence;

    private String name;

    private String text;


    public AguasCalientesResponse(String status, String message, String id, String idRequest, String statusPerson, String judicialBody, String typeSubject, String caseMaterial, String recordNumber, String dateSentence, String name, String text) {
        super(status, message, id, idRequest, statusPerson);
        this.judicialBody = judicialBody;
        this.typeSubject = typeSubject;
        this.caseMaterial = caseMaterial;
        this.recordNumber = recordNumber;
        this.dateSentence = dateSentence;
        this.name = name;
        this.text = text;
    }

    public String getJudicialBody() {
        return judicialBody;
    }

    public String getTypeSubject() {
        return typeSubject;
    }

    public String getCaseMaterial() {
        return caseMaterial;
    }

    public String getRecordNumber() {
        return recordNumber;
    }

    public String getDateSentence() {
        return dateSentence;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }
}

package com.tridato.mock;

/**
 * Created by dbeltran on 5/16/18.
 */
public class ApiResponse {

    /**
     * The status response, usually it's 0 or 1
     */
    protected String status;

    /**
     * The response message of the Api
     */
    protected String message;

    protected String id;

    protected String idRequest;

    protected String statusPerson;



    /**
     * At least the status and message should be added to this
     * @param status The status code
     * @param message The message of this response
     */
    public ApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }


    public ApiResponse(String status, String message, String id, String idRequest, String statusPerson) {
        this.status = status;
        this.message = message;
        this.id = id;
        this.idRequest = idRequest;
        this.statusPerson = statusPerson;
    }

    /**
     * Required method for Spring to parse the json response
     * @return The status contained in this class
     */
    public String getStatus() {
        return status;
    }

    /**
     * Required method for Spring to parse the json response
     * @return The message contained in this class
     */
    public String getMessage() {
        return message;
    }


    public String getId() {
        return id;
    }

    public String getIdRequest() {
        return idRequest;
    }

    public String getStatusPerson() {
        return statusPerson;
    }
}
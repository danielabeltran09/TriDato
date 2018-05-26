package com.tridato.service.api;

import com.trudato.commons.api.ApiResponse;

public class SipsoApiResponse extends ApiResponse {

    private String curp;
    private String lastName;
    private String secondLastName;
    private String name;
    private String gender;
    private String birthday;
    private String birthdayEntity;

    public String getCurp() {
        return curp;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getBirthdayEntity() {
        return birthdayEntity;
    }

    public SipsoApiResponse withCurp(String curp) {
        this.curp = curp;
        return this;
    }

    public SipsoApiResponse withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public SipsoApiResponse withSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
        return this;
    }

    public SipsoApiResponse withName(String name) {
        this.name = name;
        return this;
    }

    public SipsoApiResponse withGender(String gender) {
        this.gender = gender;
        return this;
    }

    public SipsoApiResponse withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public SipsoApiResponse withBirthdayEntity(String birthdayEntity) {
        this.birthdayEntity = birthdayEntity;
        return this;
    }
}

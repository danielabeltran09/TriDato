package com.tridato.service.model;

import javax.xml.bind.annotation.XmlElement;

public class Changes {

    @XmlElement(name = "update")
    private String update;

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }
}
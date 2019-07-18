package com.tw.apistackbase.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

public class Procurator {
    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "procuratorate_id")
    private Procuratorate procuratorate;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }
}

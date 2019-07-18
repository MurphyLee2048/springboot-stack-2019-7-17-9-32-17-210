package com.tw.apistackbase.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="procurator")
public class Procurator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int procuratorId;

    @NotNull
    private String procuratorName;

    public int getId() {
        return procuratorId;
    }

    public String getName() {
        return procuratorName;
    }


    public void setId(int id) {
        this.procuratorId = id;
    }

    public void setName(String name) {
        this.procuratorName = name;
    }

}

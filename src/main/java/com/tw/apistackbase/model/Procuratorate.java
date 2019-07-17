package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue
    private int procuratorateId;

    @NotNull
    @UniqueElements  // TODO: 唯一键？
    private String procuratorateName;

    public int getProcuratorateId() {
        return procuratorateId;
    }

    public String getProcuratorateName() {
        return procuratorateName;
    }

    public void setProcuratorateId(int procuratorateId) {
        this.procuratorateId = procuratorateId;
    }

    public void setProcuratorateName(String procuratorateName) {
        this.procuratorateName = procuratorateName;
    }
}

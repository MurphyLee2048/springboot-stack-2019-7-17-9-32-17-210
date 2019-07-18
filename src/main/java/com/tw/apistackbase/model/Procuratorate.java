package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Procuratorate {
    @Id
    @GeneratedValue
    private int procuratorateId;

    @NotNull
    @UniqueElements  // TODO
    @Length(max = 50)
    private String procuratorateName;

    @OneToMany
    private Procurator procurator;

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

    public Procurator getProcurator() {
        return procurator;
    }

    public void setProcurator(Procurator procurator) {
        this.procurator = procurator;
    }
}

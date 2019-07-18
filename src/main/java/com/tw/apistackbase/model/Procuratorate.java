package com.tw.apistackbase.model;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name="procuratorate")
public class Procuratorate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int procuratorateId;

    @NotNull
    @UniqueElements
    @Length(max = 50)
    private String procuratorateName;

    @OneToMany
    @JoinColumn(name = "procuratorate_id")
    private List<Procurator> procurator;

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

    public List<Procurator> getProcurator() {
        return procurator;
    }

    public void setProcurator(List<Procurator> procurator) {
        this.procurator = procurator;
    }
}

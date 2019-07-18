package com.tw.apistackbase.model;


//import javax.persistence.Entity;
//import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name="case")
public class Case {
    @Id
    @GeneratedValue
    @NotNull  // todo:
    private int caseId;
    @NotNull
    private String caseName;

    private long timeMillis;

    @OneToOne(cascade = CascadeType.ALL)
    private CriminalElement criminalElement;

    public int getCaseId() {
        return caseId;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    public CriminalElement getCriminalElement() {
        return criminalElement;
    }

    public void setCriminalElement(CriminalElement criminalElement) {
        this.criminalElement = criminalElement;
    }
}

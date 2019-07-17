package com.tw.apistackbase.model;


//import javax.persistence.Entity;
//import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="company")
public class Case {
    private int caseId;
    private String caseName;

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
}

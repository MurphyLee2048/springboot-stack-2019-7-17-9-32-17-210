package com.tw.apistackbase.model;


//import javax.persistence.Entity;
//import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

@Table(name="case")
public class Case {  // 案件发生时间
    @Id
    @GeneratedValue
    @NotNull
    private int caseId;
    @NotNull
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

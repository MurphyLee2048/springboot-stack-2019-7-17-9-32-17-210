package com.tw.apistackbase.model;

import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "case_element_record")
public class CaseElementRecord {
    @Id
    @GeneratedValue
    private int caseId;
    private int elementId;

    public int getCaseId() {
        return caseId;
    }

    public int getElementId() {
        return elementId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }
}

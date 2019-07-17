package com.tw.apistackbase.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="criminal_element")
public class CriminalElement {
    @Id
    @GeneratedValue
    private int elementId;

    @NotNull
    private String objectiveDescription;
    @NotNull
    private String subjectiveDescription;


    public int getElementId() {
        return elementId;
    }

    public String getObjectiveDescription() {
        return objectiveDescription;
    }

    public String getSubjectiveDescription() {
        return subjectiveDescription;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public void setObjectiveDescription(String objectiveDescription) {
        this.objectiveDescription = objectiveDescription;
    }

    public void setSubjectiveDescription(String subjectiveDescription) {
        this.subjectiveDescription = subjectiveDescription;
    }
}

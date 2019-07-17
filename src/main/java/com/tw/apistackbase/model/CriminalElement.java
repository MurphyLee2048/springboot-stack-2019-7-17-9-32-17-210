package com.tw.apistackbase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "criminal-element")
public class CriminalElement {
    @Id
    @GeneratedValue
    private int elementId;

    @NotNull
    private String objectiveDescription;
    @NotNull
    private String subjectiveDescription;

}

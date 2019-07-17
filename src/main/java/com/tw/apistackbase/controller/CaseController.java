package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.repository.CaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CaseController {
    @Autowired
    private CaseInterface caseInterface;

    @GetMapping("/cases/{caseId}")
    public Case findCaseById(@PathVariable int caseId) throws Exception{
        return caseInterface.findById(caseId).get();
    }

    @GetMapping("/cases")
    public List<Case> findAllCase() throws Exception {
        return caseInterface.findAll();
    }

}

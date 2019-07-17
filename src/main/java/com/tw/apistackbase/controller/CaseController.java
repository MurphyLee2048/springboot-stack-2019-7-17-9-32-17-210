package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.repository.CaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaseController {
    @Autowired
    private CaseInterface caseInterface;

    @GetMapping("/cases/{caseId}")
    public Case findById(@PathVariable int caseId) {
        return caseInterface.findById(caseId).get();
    }


}

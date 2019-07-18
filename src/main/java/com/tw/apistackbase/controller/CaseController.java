package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.model.CriminalElement;
import com.tw.apistackbase.repository.CaseRepository;
import com.tw.apistackbase.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseController {
    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private ElementRepository elementRepository;

    @GetMapping("/criminalCases/{caseId}")
    public CriminalCase findCaseById(@PathVariable int caseId) {
        return caseRepository.findById(caseId).get();
    }

    @GetMapping("/criminalCases")
    public List<CriminalCase> findAllCases() {
        return caseRepository.findAll();
    }

    @GetMapping("/sortedCases")
    public List<CriminalCase> findAllCasesAndSortedByTime() {
       
        return caseRepository.findAllByOrderByTimeMillisDesc();
    }

    // TODO AC4
//    @GetMapping("/cases/{caseName}")
//    public List<CriminalCase> findAllCasesByName(@PathVariable String caseName) {
//        return caseInterface.findOne();
//    }

    @DeleteMapping("/criminalCases/{caseId}")
    public void deleteCaseById(@PathVariable int caseId) {
        caseRepository.deleteById(caseId);
    }

    @GetMapping("/criminalElements/{elementId}")
    public CriminalElement findCriminalElementByElemetId(@PathVariable int elementId) {
        return elementRepository.findById(elementId).get();
    }

    @PostMapping("/criminalCases/{id}")
    public void addElementToCertainCase(@PathVariable int caseId, @RequestBody CriminalElement criminalElement) {
        CriminalCase criminalCase = caseRepository.findById(caseId).get();
        criminalCase.setCriminalElement(criminalElement);
    }

//    @GetMapping("/procuratorates/{procuratorateId}")
//    public Procuratorate findProcuratorates=

}

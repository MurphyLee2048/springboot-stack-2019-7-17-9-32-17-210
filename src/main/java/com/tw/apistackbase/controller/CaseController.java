package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.CriminalCase;
import com.tw.apistackbase.model.CriminalElement;
import com.tw.apistackbase.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseController {
    @Autowired
    private CaseRepository caseInterface;

    @GetMapping("/criminalCases/{caseId}")
    public CriminalCase findCaseById(@PathVariable int caseId) {
        return caseInterface.findById(caseId).get();
    }

    @GetMapping("/criminalCases")
    public List<CriminalCase> findAllCases() {
        return caseInterface.findAll();
    }

    @GetMapping("/sortedCases")
    public List<CriminalCase> findAllCasesAndSortedByTime() {
       
        return caseInterface.findAllByOrderByTimeMillisDesc();
    }

    // TODO AC4
//    @GetMapping("/cases/{caseName}")
//    public List<CriminalCase> findAllCasesByName(@PathVariable String caseName) {
//        return caseInterface.findOne();
//    }

    @DeleteMapping("/criminalCases/{caseId}")
    public void deleteCaseById(@PathVariable int caseId) {
        caseInterface.deleteById(caseId);
    }

    // 为什么只能根据caseId来查找返回case类
    @GetMapping("/criminalElements/{elementId}")
    public CriminalElement findCriminalElementByElemetId(@PathVariable int elementId) {
        return caseInterface.findById(elementId).get().getCriminalElement();
    }

    @PostMapping("/criminalCases")
    public void addElementToCertainCase(@PathVariable int caseId, @RequestBody CriminalElement criminalElement) {
        caseInterface.findById(caseId).get().setCriminalElement(criminalElement);
    }

//    @GetMapping("/procuratorates/{procuratorateId}")
//    public Procuratorate findProcuratorates=

}

package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Case;
import com.tw.apistackbase.model.CriminalElement;
import com.tw.apistackbase.repository.CaseInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CaseController {
    @Autowired
    private CaseInterface caseInterface;

    @GetMapping("/cases/{caseId}")
    public Case findCaseById(@PathVariable int caseId) {
        return caseInterface.findById(caseId).get();
    }

    @GetMapping("/cases")
    public List<Case> findAllCases() {
        return caseInterface.findAll();
    }

    // TODO AC3
//    @GetMapping("/cases")
//    public List<Case> findAllCasesAndSortedByTime() {
//        Sort sort = new Sort(Sort.Direction.DESC, "timeMillis");
//        return caseInterface.findAll(sort);
//    }

    // TODO AC4
//    @GetMapping("/cases/{caseName}")
//    public List<Case> findAllCasesByName(@PathVariable String caseName) {
//        return caseInterface.findOne();
//    }

    @DeleteMapping("/cases/{caseId}")
    public void deleteCaseById(@PathVariable int caseId) {
        caseInterface.deleteById(caseId);
    }

    // 为什么只能根据caseId来查找返回case类
    @GetMapping("/cases/{elementId}")
    public CriminalElement findCriminalElementByElemetId(@PathVariable int elementId) {
        return caseInterface.findById(elementId).get().getCriminalElement();
    }

    @PostMapping("/cases/{caseId}")
    public void addElementToCertainCase(@PathVariable int caseId, @RequestBody CriminalElement criminalElement) {
        caseInterface.findById(caseId).get().setCriminalElement(criminalElement);
    }


}

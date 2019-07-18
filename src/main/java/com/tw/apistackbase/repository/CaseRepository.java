package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseRepository extends JpaRepository<CriminalCase, Integer> {

    List<CriminalCase> findAllByOrderByTimeMillisDesc();

}

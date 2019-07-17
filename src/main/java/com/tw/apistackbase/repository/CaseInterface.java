package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaseInterface extends JpaRepository<Case, Integer> {

    List<Case> findAllByOrderByTimeMillisAsc();

}

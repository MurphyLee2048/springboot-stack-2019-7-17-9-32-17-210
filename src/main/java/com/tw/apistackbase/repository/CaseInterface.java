package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseInterface extends JpaRepository<Case, Integer> {
    
}

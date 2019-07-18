package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.CriminalElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<CriminalElement, Integer> {
}

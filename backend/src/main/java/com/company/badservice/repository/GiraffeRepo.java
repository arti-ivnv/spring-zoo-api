package com.company.badservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.badservice.model.Giraffe;

public interface GiraffeRepo extends JpaRepository<Giraffe, Long>{
    List<Giraffe> findByName(String name);
 }

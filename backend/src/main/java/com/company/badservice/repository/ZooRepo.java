package com.company.badservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.badservice.model.Zoo;


public interface ZooRepo extends JpaRepository<Zoo, Long> {
    List <Zoo> findByName(String name);
}

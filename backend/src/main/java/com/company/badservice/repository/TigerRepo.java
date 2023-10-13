package com.company.badservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.badservice.model.Tiger;

public interface TigerRepo extends JpaRepository<Tiger, Long> {}

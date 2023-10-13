package com.company.badservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;
// import org.springframework.stereotype.Repository;

import com.company.badservice.model.Elephant;
import java.util.List;


// @Repository we don't need this
public interface ElephantRepo extends JpaRepository<Elephant, Long> { 
    List<Elephant> findByName(String name);
}

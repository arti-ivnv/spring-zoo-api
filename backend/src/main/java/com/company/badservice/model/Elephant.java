package com.company.badservice.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.company.badservice.utils.interfaces.Animals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
// Adding table name
@Table (name = "t_elephants")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Elephant implements Animals {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "elephant_id", nullable = false, unique = true)
    private Long id;

    @Column(name = "elephant_firstname")
    @Getter private String elephantName;
    @Column(name = "elephant_lastname")
    @Getter private String elephantSurname;
    @Column(name = "elephant_name", nullable =  false)
    private String name;
    @Column(name = "elephant_age", nullable =  false)
    @Getter @Setter private double elephantAge;

    // To achieve abstraction via animal innterface

    @ManyToOne
    @Getter @Setter private Zoo zoo;

    public double getElephantAgeInHours() {
        return elephantAge * 8766;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        String[] words = name.split("\\s");
        elephantName = words[0];
        elephantSurname = words[1];
        return name;
    }

    @Override
    public void setName(String name) {
        String[] words = name.split("\\s");
        elephantName = words[0];
        elephantSurname = words[1];
        this.name = name;
    }



}

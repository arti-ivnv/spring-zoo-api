package com.company.badservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.company.badservice.utils.interfaces.Animals;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "t_tigers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Tiger implements Animals {

    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tiger_id", nullable = false, unique = true)
    private Long id;
    @Column(name = "tiger_name", nullable =  false)
    private String name;
    
    @ManyToOne
    @JoinColumn(name = "zoo_id")
    @Getter @Setter private Zoo zoo;


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
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


}

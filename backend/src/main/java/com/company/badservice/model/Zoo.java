package com.company.badservice.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "t_zoo")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zoo_id")
    @Getter @Setter
    private Long id;

    @Column(name = "zoo_name", nullable = false)
    @Getter @Setter
    private String name;

    @Column(name = "zoo_animals_number")
    @Getter @Setter
    private Long numberOfAnimals;

    @OneToMany(mappedBy = "zoo",  fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @Getter
    private List<Tiger> tigers;


    @OneToMany(mappedBy = "zoo",  fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @Getter
    private List<Elephant> elephants;

    
    @OneToMany(mappedBy = "zoo",  fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = false)
    @Getter
    private List<Giraffe> giraffes;

    public String getTigersStr(){
        List <String> tigerList = new ArrayList<String>();

        for (Tiger tiger : tigers){
            tigerList.add(tiger.getName());
        }

        return tigerList.toString();
    }

    public String getElephantsStr(){
        List <String> elephantList = new ArrayList<String>();

        for (Elephant elephant : elephants){
            elephantList.add(elephant.getName());
        }

        return elephantList.toString();
    }

    public String getGiraffesStr(){
        List <String> giraffeList = new ArrayList<String>();

        for (Giraffe giraffe : giraffes){
            giraffeList.add(giraffe.getName());
        }

        return giraffeList.toString();
    }

    public Tiger getLastTiger() {
        
        return tigers.get(tigers.size()-1);
    }

    public Elephant getLastElephant() {
        return elephants.get(tigers.size()-1);
    }

    public Giraffe getLastGiraffe() {
        return giraffes.get(tigers.size()-1);
    }


    public void setTigers(List<Tiger> tigers) {
        this.tigers.addAll(tigers);
    }

    public void setGiraffes(List<Giraffe> giraffes) {
        this.giraffes.addAll(giraffes);

    }

    public void setElephants(List<Elephant> elephants) {
        this.elephants.addAll(elephants);
    }

}

package com.company.badservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ZooResponse {
    private Long id;
    private String name;
    private Long numberOfAnimals;
    private String elephants;
    private String giraffes;
    private String tigers;
    
}

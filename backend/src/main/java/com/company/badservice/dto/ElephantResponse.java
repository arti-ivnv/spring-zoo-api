package com.company.badservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ElephantResponse {
    private Long id;
    private String elephantName;
    private String elephantSurname;
    private String name;
    private double elephantAge;
    private Long zoo_id;
}

package com.company.badservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GiraffeResponse {
    private Long id;
    private String name;
    private String secret;
    private Long zoo_id;
}

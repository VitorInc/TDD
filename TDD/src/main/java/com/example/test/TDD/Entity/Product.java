package com.example.test.TDD.Entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private Long id;
    private String name;
    private String description;
    private Integer amountAvailable;
    private Double price;
    private Double discount;

}

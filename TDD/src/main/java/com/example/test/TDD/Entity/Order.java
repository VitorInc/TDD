package com.example.test.TDD.Entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    private Long idOrder;
    private String product;
    private Integer amountRequested;
    private Double off;


}

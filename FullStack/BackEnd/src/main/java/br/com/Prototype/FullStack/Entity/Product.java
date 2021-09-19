package br.com.Prototype.FullStack.Entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Product {
    private Long id;
    private String name;
    private String description;
    private Integer amountAvailable;
    private Double price;
    private Double discount;
}

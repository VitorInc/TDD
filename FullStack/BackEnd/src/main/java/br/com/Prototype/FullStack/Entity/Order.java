package br.com.Prototype.FullStack.Entity;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Order {

    private Long idOrder;
    private String product;
    private Integer amountRequested;
    private Double off;

}

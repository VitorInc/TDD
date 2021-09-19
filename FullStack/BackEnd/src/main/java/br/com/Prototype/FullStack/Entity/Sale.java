package br.com.Prototype.FullStack.Entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Sale {
    private Double fullPrice;
    private List<Order> products = new ArrayList();

}

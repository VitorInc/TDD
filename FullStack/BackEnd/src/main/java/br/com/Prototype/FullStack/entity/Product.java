package br.com.Prototype.FullStack.entity;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
    private Long id;
    private String Name;
    private String description;
    private Integer amount;
    private Double price;
    private Double percentMaxDiscount;



    public Integer getAmountAvailable(final Integer howmany){
        if(howmany > amount){
            System.out.println("The ain't not enoght products as requested, we only have available" + amount);
            return amount;
        }
        else {
            return howmany;
        }
    }

    public Double getPriceOff(final Double off){
        if (off > percentMaxDiscount){
            return price * (1 - percentMaxDiscount);
        }else {
            return price * (1 - off);
        }
    }

}

package ie.atu.week3cicd3;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private int id;
    private String name;
    private String desc;
    private int price;

}
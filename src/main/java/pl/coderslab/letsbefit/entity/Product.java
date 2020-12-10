package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="VARCHAR(255) NULL COMMENT 'Product name'")
    private String name;

    @Column(columnDefinition="INT NULL COMMENT 'Amount of kcal in 100g/100ml of product'")
    private Integer calories;
}

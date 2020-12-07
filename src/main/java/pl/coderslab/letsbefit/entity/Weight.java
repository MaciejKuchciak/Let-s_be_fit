package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "weights")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="DATETIME NULL COMMENT 'Creation date of the record'")
    private String creationDate;

    @Column(columnDefinition="DECIMAL(4,1) NULL COMMENT 'Current user weight'")
    private Double currentWeight;

    @ManyToOne
    private UserDetails userDetails;

    public Weight(Long id, String creationDate, Double currentWeight, UserDetails userDetails) {
        this.id = id;
        this.creationDate = creationDate;
        this.currentWeight = currentWeight;
        this.userDetails = userDetails;
    }
}

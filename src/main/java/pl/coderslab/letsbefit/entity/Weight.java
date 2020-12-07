package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "weights")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="DATE NULL COMMENT 'Creation date of the record'")
    private LocalDate creationDate;

    @Column(columnDefinition="DECIMAL(4,1) NULL COMMENT 'Current user weight'")
    private Double currentWeight;

    @ManyToOne
    private UserDetails userDetails;

    public Weight(Long id, LocalDate creationDate, Double currentWeight, UserDetails userDetails) {
        this.id = id;
        this.creationDate = creationDate;
        this.currentWeight = currentWeight;
        this.userDetails = userDetails;
    }
}

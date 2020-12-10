package pl.coderslab.letsbefit.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "weights")
public class Weight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss")
    @Column(columnDefinition="DATETIME NULL COMMENT 'Creation date of the record'")
    private LocalDateTime creationDate = LocalDateTime.now();

    @Max(500)
    @Min(0)
    @Column(columnDefinition="DECIMAL(4,1) NULL COMMENT 'Current user weight'")
    private Double currentWeight;

    @ManyToOne
    private UserDetails userDetails;

    public Weight(Long id, LocalDateTime creationDate, Double currentWeight, UserDetails userDetails) {
        this.id = id;
        this.creationDate = creationDate;
        this.currentWeight = currentWeight;
        this.userDetails = userDetails;
    }
}

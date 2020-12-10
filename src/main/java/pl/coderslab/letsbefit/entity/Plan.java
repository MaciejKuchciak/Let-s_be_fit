package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition="DATE NULL COMMENT 'Start date of the plan'")
    private LocalDate startDate;

    @Max(200)
    @Min(0)
    @Column(columnDefinition="DECIMAL(4,1) NULL COMMENT 'Desired weight'")
    private Double targetWeight;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition="DATE NULL COMMENT 'Due date to lose weight'")
    private LocalDate targetDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}

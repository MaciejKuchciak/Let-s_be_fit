package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="DATETIME NOT NULL COMMENT 'Start date of the plan'")
    private String startDate;

    @Column(columnDefinition="DECIMAL(4,1) NULL COMMENT 'Desired weight'")
    private Double targetWeight;

    @Column(columnDefinition="DATETIME NULL COMMENT 'Due date to lose weight'")
    private String targetDate;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

}

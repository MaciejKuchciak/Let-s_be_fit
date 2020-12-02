package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "users_details")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="VARCHAR(6) NULL COMMENT 'User sex'")
    private String sex;

    @Column(columnDefinition="DATETIME NULL COMMENT 'User date of birth'")
    private String birthday;

    @Column(columnDefinition="DECIMAL(4,1) NULL COMMENT 'User weight'")
    private Double weight;

    @Column(columnDefinition="INT NULL COMMENT 'User height'")
    private Integer height;

    @Column(columnDefinition="DECIMAL(4,3) NULL COMMENT 'User activity level'")
    private Double activity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public UserDetails(Long id, String sex, String birthday, Double weight, Integer height, Double activity) {
        this.id = id;
        this.sex = sex;
        this.birthday = birthday;
        this.weight = weight;
        this.height = height;
        this.activity = activity;
    }
}

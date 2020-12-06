package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(columnDefinition="INT NULL COMMENT 'User height'")
    private Integer height;

    @Column(columnDefinition="DECIMAL(4,3) NULL COMMENT 'User activity level'")
    private Double activity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "user_details")
    private List<Weight> weights = new ArrayList<>();

    public UserDetails(Long id, String sex, String birthday, Integer height, Double activity) {
        this.id = id;
        this.sex = sex;
        this.birthday = birthday;
        this.height = height;
        this.activity = activity;
    }
}

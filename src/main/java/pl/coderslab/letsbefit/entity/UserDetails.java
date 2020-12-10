package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition="DATE NULL COMMENT 'User date of birth'")
    private LocalDate birthday;

    @Max(300)
    @Min(0)
    @Column(columnDefinition="INT NULL COMMENT 'User height'")
    private Integer height;

    @Column(columnDefinition="DECIMAL(4,3) NULL COMMENT 'User activity level'")
    private Double activity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "userDetails")
    private List<Weight> weights = new ArrayList<>();

    public UserDetails(Long id, String sex, LocalDate birthday, Integer height, Double activity) {
        this.id = id;
        this.sex = sex;
        this.birthday = birthday;
        this.height = height;
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", sex='" + sex + '\'' +
                ", birthday=" + birthday +
                ", height=" + height +
                ", activity=" + activity +
                ", user=" + user +
                '}';
    }
}

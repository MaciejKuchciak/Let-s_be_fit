package pl.coderslab.letsbefit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition="VARCHAR(255) NOT NULL COMMENT 'First name'")
    private String login;

    @Column(columnDefinition="VARCHAR(255) NOT NULL COMMENT 'First name'")
    private String firstName;

    @Column(columnDefinition="VARCHAR(255) NULL COMMENT 'Last name'")
    private String lastName;

    @Column(columnDefinition="VARCHAR(255) NULL COMMENT 'E-mail address'")
    private String email;

    @Column(columnDefinition="VARCHAR(255) NULL COMMENT 'Password'")
    private String password;

    @Column(columnDefinition="TINYINT(1) NULL COMMENT '0 regular user / 1 admin access'")
    private int superadmin = 0;

    @Column(columnDefinition="TINYINT(1) NULL COMMENT '0 account disabled / 1 account enabled'")
    private int enable = 1;

    @OneToOne(mappedBy = "user")
    private UserDetails userDetails;
}

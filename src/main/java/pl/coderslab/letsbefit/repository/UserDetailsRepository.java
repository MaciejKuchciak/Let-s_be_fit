package pl.coderslab.letsbefit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.letsbefit.entity.UserDetails;

import java.util.List;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    @Query("Select ud from UserDetails ud")
    List<UserDetails> findAll();

    @Query("SELECT ud FROM User u JOIN UserDetails ud on u.id = ud.id WHERE u.login = ?1")
    UserDetails getUserDetailsByUserLogin(String username);

    @Query(value = "SELECT COUNT(DISTINCT u.id) FROM users_details ud JOIN users u on ud.user_id = u.id WHERE u.login = ?1",nativeQuery = true)
    int userDetailsQuantity(String username);

}

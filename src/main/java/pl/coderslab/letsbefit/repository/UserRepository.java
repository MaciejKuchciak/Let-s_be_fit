package pl.coderslab.letsbefit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.letsbefit.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);

    User findFirstByLastName(String lastName);

    @Query("Select u from User u")
    List<User> getUsers();

    boolean existsByLogin(String login);

    User getByLogin(String login);
}

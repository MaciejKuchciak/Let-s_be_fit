package pl.coderslab.letsbefit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.letsbefit.entity.User;
import pl.coderslab.letsbefit.entity.Weight;

import java.util.List;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {

    @Query("Select w from Weight w order by w.creationDate")
    List<Weight> findAll();

    @Query("SELECT w FROM User u JOIN Weight w on u.id = w.id WHERE u.login = ?1 ORDER BY w.creationDate")
    List<User> getWeightByUserLogin(String username);

}

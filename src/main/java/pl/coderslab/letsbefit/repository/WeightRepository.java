package pl.coderslab.letsbefit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.letsbefit.entity.Weight;

import java.util.List;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {

    @Query("Select w from Weight w order by w.creationDate")
    List<Weight> findAll();

    @Query("SELECT w FROM User u JOIN Weight w on u.id = w.id WHERE u.login = ?1 ORDER BY w.creationDate DESC ")
    List<Weight> getAllWeightsByUserLogin(String username);

    @Query("SELECT w FROM User u JOIN Weight w on u.id = w.id WHERE u.login = ?1 ORDER BY w.creationDate")
    Weight getWeightByUserLogin(String username);

    @Query(value = "SELECT COUNT(DISTINCT ud.id) FROM weights w JOIN users_details ud on w.user_details_id = ud.id JOIN users u on u.id = ud.user_id WHERE u.login = ?1",nativeQuery = true)
    int weightsQuantity(String username);

    @Query(value = "SELECT w.id,w.creation_date,w.current_weight,w.user_details_id FROM weights w JOIN users_details ud on w.user_details_id = ud.id JOIN users u on u.id = ud.user_id WHERE u.login = ?1 ORDER BY w.creation_date DESC LIMIT 1",nativeQuery = true)
    Weight getLastWeightByUserLogin(String username);

    @Query(value = "SELECT w.id,w.creation_date,w.current_weight,w.user_details_id FROM weights w JOIN users_details ud on w.user_details_id = ud.id JOIN users u on u.id = ud.user_id WHERE u.login = ?1 ORDER BY w.creation_date ASC LIMIT 1",nativeQuery = true)
    Weight getFirstWeightByUserLogin(String username);

}

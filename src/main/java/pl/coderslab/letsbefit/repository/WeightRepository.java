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
}

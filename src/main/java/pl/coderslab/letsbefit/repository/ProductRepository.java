package pl.coderslab.letsbefit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.letsbefit.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findFirstById(Long id);

    Product findFirstByName(String name);

    Product findFirstByCalories(int calories);

    @Query("Select p from Product p")
    List<Product> findAll();

}

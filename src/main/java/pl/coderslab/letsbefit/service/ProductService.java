package pl.coderslab.letsbefit.service;

import pl.coderslab.letsbefit.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void add(Product product);

    Product get(Long id);

    void remove(Long id);

    void update(Product product);
}

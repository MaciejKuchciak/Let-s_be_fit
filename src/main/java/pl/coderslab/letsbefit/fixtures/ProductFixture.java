package pl.coderslab.letsbefit.fixtures;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.letsbefit.entity.Product;
import pl.coderslab.letsbefit.service.ProductService;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductFixture {

    private final ProductService productService;

    @Autowired
    public ProductFixture(ProductService productService) {
        this.productService = productService;
    }

    private final List<Product> productList = Arrays.asList(
            new Product(null, "Cornflakes", 370),
            new Product(null, "Rice cakes", 373),
            new Product(null, "Noodles (boiled)", 70),
            new Product(null, "Chicken", 200),
            new Product(null, "Sausage roll", 480),
            new Product(null, "Apple", 44),
            new Product(null, "Cherry", 50),
            new Product(null, "Tomato", 20),
            new Product(null, "Egg", 150),
            new Product(null, "Omlette with cheese", 266),
            new Product(null, "Milk semi-skimmed", 50),
            new Product(null, "Butter", 750),
            new Product(null, "Mars bar", 480),
            new Product(null, "Toffee", 400),
            new Product(null, "Jam", 250)

    );

    public void loadIntoDB() {

        for (Product products : productList) {
            productService.add(products);
        }
    }
}

package pl.coderslab.letsbefit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.letsbefit.entity.Product;
import pl.coderslab.letsbefit.service.ProductService;

import java.util.List;

@Controller
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public String products(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products",products);
        return "products";
    }

    @GetMapping("/add")
    public String addNewProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    @PostMapping("/add")
    public String add(Product product) {
        productService.add(product);
        return "redirect:/products";
    }
}

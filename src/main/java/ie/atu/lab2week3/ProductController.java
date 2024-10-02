package ie.atu.lab2week3;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private List<Product> productList = new ArrayList<>();
    public ProductController(){
    //initialize sample product
        productList.add(new Product("TV", "Electronics", 700, 700));
        productList.add(new Product("Microwave", "Electronics",200,798));

}
    @GetMapping
    public List<Product> getAllProducts(){
        return productList;
    }

    @PostMapping
    public Product addProduct(@RequestParam Product newProduct){
        productList.add(newProduct);
        return newProduct;
    }
}


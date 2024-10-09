package ie.atu.lab2week3;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private List<Product> productList = new ArrayList<>();

    public ProductController(){
        productList.add(new Product(1,"TV","Electronics",600.0));
        productList.add(new Product(2,"Phone","Electronics",500.0));
    }


    @GetMapping
    public List<Product> getAllProducts(){
        return productList;
    }



    @PostMapping
    public Product addProduct(@RequestBody Product newProduct){
        productList.add(newProduct);
        return newProduct;
    }


    @PutMapping("/{id}")
    public ResponseEntity putProduct(@PathVariable int id, @RequestBody Product product){
        int num = (int) id;
        for(int count = 0;count < productList.size(); count++){
            if(productList.get(count).getId() == num){
                productList.set(count,product );
            }
        }
        return ResponseEntity.ok(productList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable int id){
        int num = id;
        for(int count = 0;count < productList.size(); count++){
            if(productList.get(count).getId() == num){
                productList.remove(count);
            }
        }
        return ResponseEntity.ok(productList);
    }


}
package ie.atu.week3cicd3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product( 1, "TV","Made by Sony", 900));
        products.add(new Product(2,"TV", "Made by LG", 999));
    }

    @GetMapping("/getProduct")
    public List<Product> getProducts()
    {
        return products;
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List> addProduct(@RequestBody Product product)
    {
        products.add(product);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<List> deleteProduct(@PathVariable int id)
    {

        for(int i = 0; i < products.size(); i++)
        {
            if(products.get(i).getId() == id)
            {
                products.remove(i);
            }
        }
        return ResponseEntity.ok(products);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<List> updateProduct(@PathVariable int id, @RequestBody Product product)
    {
        for(int i= 0; i < products.size(); i++)
        {
            if(products.get(i).getId() == id)
            {
                products.set(i, product);
            }
        }
        return ResponseEntity.ok(products);
    }
}
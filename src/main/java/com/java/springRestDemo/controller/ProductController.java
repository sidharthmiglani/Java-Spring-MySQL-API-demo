package com.java.springRestDemo.controller;

import com.java.springRestDemo.entity.Product;
import com.java.springRestDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    @GetMapping("/productById/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    @GetMapping("/productByName/{name}")
    public Product getProductByName(@PathVariable String name){
        return service.getProductByName(name);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @PutMapping("/product/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("product/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        return service.deleteProductById(id);
    }
}

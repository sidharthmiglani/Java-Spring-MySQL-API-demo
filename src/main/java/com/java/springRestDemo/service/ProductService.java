package com.java.springRestDemo.service;

import com.java.springRestDemo.entity.Product;
import com.java.springRestDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    // save 1 product in db - POST
    public Product saveProduct(Product product){
        return repo.save(product);
    }

    // save multiple products in db - POST
    public List<Product> saveProducts(List<Product> products){
        return repo.saveAll(products);
    }

    // get all products from db - GET
    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    // get product by id - GET
    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
    }

    // get product by name - GET
    public Product getProductByName(String name){
        return repo.findByName(name);
    }

    // delete product - DELETE
    public String deleteProductById(int id){
        repo.deleteById(id);
        return "Product with id: " + id + " is deleted";
    }

    //update product - PUT
    public Product updateProduct(Product product){
        Product updatedProduct = repo.findById(product.getId()).orElse(null);
        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setQuantity(product.getQuantity());
        return repo.save(updatedProduct);
    }

}

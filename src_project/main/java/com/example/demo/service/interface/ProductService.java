package com.example.demo.service.interfaces;

import com.example.demo.model.products.Product;

import java.util.List;

public interface ProductService {

    List<Product> searchProductByName(String name);
    List<Product> getProductsFromCategory(String category);
    List<Product> listAllProducts(); // Project homework

    List<Product> searchProductByCategoryAndBrand(String category, String brand);

    Product addProductToCatalog(Product product);

    Product deleteProductFromCatalog(String productId);

    Product updateDiscount(String productId, Double discount);


}

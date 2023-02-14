package com.example.demo.service.implementation;

import com.example.demo.model.products.Product;
import com.example.demo.service.interfaces.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> searchProductByName(String name) {
        return null;
    }

    @Override
    public List<Product> getProductsFromCategory(String category) {
        return null;
    }

    @Override
    public List<Product> listAllProducts() {
        return null;
    }

    @Override
    public List<Product> searchProductByCategoryAndBrand(String category, String brand) {
        return null;
    }

    @Override
    public Product addProductToCatalog(Product product) {
        return null;
    }

    @Override
    public Product deleteProductFromCatalog(String productId) {
        return null;
    }

    @Override
    public Product updateDiscount(String productId, Double discount) {
        return null;
    }
}

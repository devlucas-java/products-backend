package products_backend.devlucas_java.com.github.BackendProducts.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import products_backend.devlucas_java.com.github.BackendProducts.Entity.ProductEntity;
import products_backend.devlucas_java.com.github.BackendProducts.Repository.ProductsRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ProductsService {

    ProductsRepository productsRepository;
    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    // save product
    public ProductEntity saveProduct(ProductEntity product) {
        return productsRepository.save(product);
    }
    // get product by id
    public ProductEntity getByIdProduct(UUID id) {
        return productsRepository.findById(id).orElse(null);
    }
    // delete product by id
    public void deleteByIdProduct(UUID id) {
        productsRepository.deleteById(id);
    }
    // delete all products
    public void deleteAllProducts() {
        productsRepository.deleteAll();
    }
    // update product
    public ProductEntity updateProduct(ProductEntity product) {
        return productsRepository.save(product);
    }
    // get product by name
    public List<ProductEntity> getByNameProduct(String name) {
        return productsRepository.findByName(name);  // Retorna uma lista de produtos
    }

    // get all products
    public ProductEntity[] getAllProducts() {
        return productsRepository.findAll().toArray(new ProductEntity[0]);
    }
}

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

    public ProductEntity saveProduct(ProductEntity product) {
        return productsRepository.save(product);
    }

    public ProductEntity getByIdProduct(UUID id) {
        return productsRepository.findById(id).orElse(null);
    }

    public void deleteByIdProduct(UUID id) {
        productsRepository.deleteById(id);
    }

    public void deleteAllProducts() {
        productsRepository.deleteAll();
    }

    public ProductEntity updateProduct(ProductEntity product) {
        return productsRepository.save(product);
    }

    public List<ProductEntity> getByNameProduct(String name) {
        return productsRepository.findByName(name);
    }

    public ProductEntity[] getAllProducts() {
        return productsRepository.findAll().toArray(new ProductEntity[0]);
    }
}

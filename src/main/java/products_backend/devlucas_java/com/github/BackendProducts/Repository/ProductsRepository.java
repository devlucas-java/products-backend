package products_backend.devlucas_java.com.github.BackendProducts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products_backend.devlucas_java.com.github.BackendProducts.Entity.ProductEntity;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<ProductEntity, UUID> {
    ProductEntity findByName(String name);
}

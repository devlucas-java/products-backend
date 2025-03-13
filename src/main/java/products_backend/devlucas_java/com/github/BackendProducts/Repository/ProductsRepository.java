package products_backend.devlucas_java.com.github.BackendProducts.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import products_backend.devlucas_java.com.github.BackendProducts.Endity.ProductEndity;

import java.util.UUID;

public interface ProductsRepository extends JpaRepository<ProductEndity, UUID> {
}

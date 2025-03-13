package products_backend.devlucas_java.com.github.BackendProducts.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity {


    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "stack")
    private Integer stack;

    @Column(name = "image_url")
    private String imageUrl;
}

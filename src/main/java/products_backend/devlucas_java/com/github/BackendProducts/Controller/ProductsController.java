package products_backend.devlucas_java.com.github.BackendProducts.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import products_backend.devlucas_java.com.github.BackendProducts.Entity.ProductEntity;
import products_backend.devlucas_java.com.github.BackendProducts.Controller.ProductsController;
import products_backend.devlucas_java.com.github.BackendProducts.Service.ProductsService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductsService productsService;
    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }



    @PostMapping("/save")
    public ProductEntity salvarProduto(@RequestBody ProductEntity product) {
        product.setId(UUID.randomUUID());
        return productsService.saveProduct(product);
    }

    @GetMapping("/id/{id}")
    public ProductEntity buscarPorId(@PathVariable(value = "id") UUID id) {
        return productsService.getByIdProduct(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deletarProduto(@PathVariable(value = "id") UUID id) {
        productsService.deleteByIdProduct(id);
    }

    @DeleteMapping("/delete/all")
    public void detetarTodos() {
        productsService.deleteAllProducts();
    }

    @PutMapping("/update")
    public ProductEntity atualizarProduto(@RequestBody ProductEntity product) {
        return productsService.updateProduct(product);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<ProductEntity>> buscarPorName(@PathVariable String name) {
        List<ProductEntity> products = productsService.getByNameProduct(name);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }


    @GetMapping("/all")
    public ProductEntity[] listarProdutos() {
        return productsService.getAllProducts();
    }

}

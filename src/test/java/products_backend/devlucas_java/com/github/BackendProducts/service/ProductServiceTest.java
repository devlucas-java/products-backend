package products_backend.devlucas_java.com.github.BackendProducts.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import products_backend.devlucas_java.com.github.BackendProducts.Entity.ProductEntity;
import products_backend.devlucas_java.com.github.BackendProducts.Repository.ProductsRepository;
import products_backend.devlucas_java.com.github.BackendProducts.Service.ProductsService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

    class ProductsServiceTest {

        @Mock
        private ProductsRepository productsRepository;

        @InjectMocks
        private ProductsService productsService;

        private ProductEntity product;
        private UUID id;

        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);

            id = UUID.randomUUID();
            product = new ProductEntity();
            product.setId(id);
            product.setName("Produto Teste");
        }

        @Test
        void shouldSaveProduct() {
            when(productsRepository.save(product)).thenReturn(product);

            ProductEntity result = productsService.saveProduct(product);

            assertNotNull(result);
            assertEquals(product.getName(), result.getName());
            verify(productsRepository, times(1)).save(product);
        }

        @Test
        void shouldGetProductById() {
            when(productsRepository.findById(id)).thenReturn(Optional.of(product));

            ProductEntity result = productsService.getByIdProduct(id);

            assertNotNull(result);
            assertEquals(id, result.getId());
        }

        @Test
        void shouldReturnNullWhenProductNotFound() {
            when(productsRepository.findById(id)).thenReturn(Optional.empty());

            ProductEntity result = productsService.getByIdProduct(id);

            assertNull(result);
        }

        @Test
        void shouldDeleteProductById() {
            doNothing().when(productsRepository).deleteById(id);

            productsService.deleteByIdProduct(id);

            verify(productsRepository, times(1)).deleteById(id);
        }

        @Test
        void shouldDeleteAllProducts() {
            doNothing().when(productsRepository).deleteAll();

            productsService.deleteAllProducts();

            verify(productsRepository, times(1)).deleteAll();
        }

        @Test
        void shouldUpdateProduct() {
            when(productsRepository.save(product)).thenReturn(product);

            ProductEntity result = productsService.updateProduct(product);

            assertNotNull(result);
            assertEquals(product.getId(), result.getId());
            verify(productsRepository).save(product);
        }

        @Test
        void shouldGetProductsByName() {
            List<ProductEntity> list = List.of(product);

            when(productsRepository.findByName("Produto Teste")).thenReturn(list);

            List<ProductEntity> result = productsService.getByNameProduct("Produto Teste");

            assertEquals(1, result.size());
            assertEquals("Produto Teste", result.get(0).getName());
        }

        @Test
        void shouldGetAllProducts() {
            List<ProductEntity> list = List.of(product);

            when(productsRepository.findAll()).thenReturn(list);

            ProductEntity[] result = productsService.getAllProducts();

            assertEquals(1, result.length);
            assertEquals(product.getId(), result[0].getId());
        }
    }

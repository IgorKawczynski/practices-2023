package com.practices.products;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** REST Controller created in the needs of Create, Read, Update, Delete
 * and more complex operations for Product Entity
 * @Endpoint: products
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    List<ProductDTO> getAllProducts() {
        return productService.readAllProducts();
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Long productId) {
        return productService.updateProduct(productDTO, productId);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCourseById(@PathVariable Long productId) {
        productService.deleteProduct(productId);
    }

}

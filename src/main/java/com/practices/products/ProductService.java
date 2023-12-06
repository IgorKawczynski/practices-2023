package com.practices.products;

import com.practices.buyers.BuyerRepository;
import com.practices.sellers.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final BuyerRepository buyerRepository;

    public ProductDTO createProduct(ProductDTO productDTO) {
        var sellerEntity = sellerRepository
                .findById(productDTO.sellerId())
                .orElseThrow(() -> new NoSuchElementException("Seller with id " + productDTO.sellerId() + " does not exist"));

        var buyerEntity = buyerRepository
                .findById(productDTO.buyerId())
                .orElseThrow(() -> new NoSuchElementException("Buyer with id " + productDTO.buyerId() + " does not exist"));

        var newProduct = new ProductEntity();
        newProduct.setName(productDTO.name());
        newProduct.setCreatedAt(LocalDateTime.now());
        newProduct.setPrice(productDTO.price());
        newProduct.setAmount(productDTO.amount());
        newProduct.setSellerEntity(sellerEntity);
        newProduct.setBuyerEntity(buyerEntity);

        productRepository.save(newProduct);
        return newProduct.toDTO();
    }

    public List<ProductDTO> readAllProducts() {
        return productRepository
                .findAll()
                .stream()
                .map(ProductEntity::toDTO)
                .toList();
    }

    public ProductDTO updateProduct(ProductDTO productDTO, Long productToUpdateId) {

        var productToUpdate = productRepository
                .findById(productToUpdateId)
                .orElseThrow(() -> new NoSuchElementException("Product with id " + productToUpdateId + " does not exist"));

        var sellerEntity = sellerRepository
                .findById(productDTO.sellerId())
                .orElseThrow(() -> new NoSuchElementException("Seller with id " + productDTO.sellerId() + " does not exist"));

        var buyerEntity = buyerRepository
                .findById(productDTO.buyerId())
                .orElseThrow(() -> new NoSuchElementException("Buyer with id " + productDTO.buyerId() + " does not exist"));

        productToUpdate.setName(productDTO.name());
        productToUpdate.setPrice(productDTO.price());
        productToUpdate.setAmount(productDTO.amount());
        productToUpdate.setSellerEntity(sellerEntity);
        productToUpdate.setBuyerEntity(buyerEntity);

        productRepository.save(productToUpdate);

        return productToUpdate.toDTO();
    }

    public void deleteProduct(Long productToDeleteId) {
        productRepository.deleteById(productToDeleteId);
    }

}

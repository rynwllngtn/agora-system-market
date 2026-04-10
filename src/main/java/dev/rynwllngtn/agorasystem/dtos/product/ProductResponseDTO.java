package dev.rynwllngtn.agorasystem.dtos.product;

import dev.rynwllngtn.agorasystem.entities.product.Product;

public record ProductResponseDTO(
        String name,
        String description
) {
    public ProductResponseDTO(Product product) {
        this(product.getName(),
             product.getDescription());
    }
}
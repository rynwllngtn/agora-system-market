package dev.rynwllngtn.agorasystem.dtos.product;

import dev.rynwllngtn.agorasystem.entities.product.Product;

import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        String description
) {
    public ProductResponseDTO(Product product) {
        this(product.getId(),
             product.getName(),
             product.getDescription());
    }
}
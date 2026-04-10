package dev.rynwllngtn.agorasystem.dtos.seller;

import dev.rynwllngtn.agorasystem.entities.seller.Seller;

public record SellerResponseDTO(
        String name
) {
    public SellerResponseDTO(Seller seller) {
        this(seller.getName());
    }
}
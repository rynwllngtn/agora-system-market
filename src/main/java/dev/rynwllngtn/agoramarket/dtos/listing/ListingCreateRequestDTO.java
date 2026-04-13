package dev.rynwllngtn.agoramarket.dtos.listing;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.UUID;

public record ListingCreateRequestDTO (
        @NotNull(message = "Seller não pode ser vazio ou null!")
        UUID sellerId,
        @NotNull(message = "Product não pode ser vazio ou null!")
        UUID productId,
        @Positive(message = "Stock não pode ser zero ou negativo!")
        int stock,
        @Positive(message = "Price não pode ser zero ou negativo!")
        BigDecimal price
) {}
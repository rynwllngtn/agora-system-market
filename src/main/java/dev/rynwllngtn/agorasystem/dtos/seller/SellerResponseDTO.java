package dev.rynwllngtn.agorasystem.dtos.seller;

import dev.rynwllngtn.agorasystem.enums.seller.SellerStatus;

import java.util.UUID;

public record SellerResponseDTO(
        UUID id,
        UUID ownerId,
        String name,
        SellerStatus status
) {}
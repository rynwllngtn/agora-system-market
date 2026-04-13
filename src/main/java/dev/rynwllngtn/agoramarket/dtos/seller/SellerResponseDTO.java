package dev.rynwllngtn.agoramarket.dtos.seller;

import dev.rynwllngtn.agoramarket.enums.seller.SellerStatus;

import java.util.UUID;

public record SellerResponseDTO(
        UUID id,
        UUID ownerId,
        String name,
        SellerStatus status
) {}
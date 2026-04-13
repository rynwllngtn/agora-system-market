package dev.rynwllngtn.agoramarket.dtos.listing;

import dev.rynwllngtn.agoramarket.enums.listing.ListingStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record ListingResponseDTO(
        UUID id,
        String seller,
        String product,
        int stock,
        BigDecimal price,
        ListingStatus status
) {}
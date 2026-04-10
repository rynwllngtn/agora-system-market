package dev.rynwllngtn.agorasystem.dtos.listing;

import dev.rynwllngtn.agorasystem.enums.listing.ListingStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record ListingCreateRequestDTO (
        UUID sellerId,
        UUID productId,
        int stock,
        BigDecimal price,
        ListingStatus status
) {}
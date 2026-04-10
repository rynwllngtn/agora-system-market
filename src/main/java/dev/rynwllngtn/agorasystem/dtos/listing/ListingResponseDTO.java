package dev.rynwllngtn.agorasystem.dtos.listing;

import dev.rynwllngtn.agorasystem.entities.listing.Listing;
import dev.rynwllngtn.agorasystem.enums.listing.ListingStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record ListingResponseDTO(
        String seller,
        String product,
        int stock,
        BigDecimal price,
        ListingStatus status
) {
    public ListingResponseDTO(Listing listing) {
        this(listing.getSeller().getName(),
             listing.getProduct().getName(),
             listing.getStock(),
             listing.getPrice(),
             listing.getStatus());
    }
}
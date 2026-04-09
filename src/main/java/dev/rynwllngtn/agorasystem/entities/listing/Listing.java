package dev.rynwllngtn.agorasystem.entities.listing;

import dev.rynwllngtn.agorasystem.enums.listing.ListingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "listings")
public class Listing {

    @Id
    private UUID id;
    private UUID sellerId;
    private UUID productId;
    private int stock;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ListingStatus status;

}
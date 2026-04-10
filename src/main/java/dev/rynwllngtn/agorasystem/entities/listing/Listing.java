package dev.rynwllngtn.agorasystem.entities.listing;

import dev.rynwllngtn.agorasystem.entities.product.Product;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import dev.rynwllngtn.agorasystem.enums.listing.ListingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "seller", updatable = false, nullable = false)
    private Seller seller;

    @ManyToOne
    @JoinColumn(name = "product", updatable = false, nullable = false)
    private Product product;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ListingStatus status;

    public Listing(Seller seller, Product product, int stock, BigDecimal price, ListingStatus status) {
        this.seller = seller;
        this.product = product;
        this.stock = stock;
        this.price = price;
        this.status = status;
    }

}
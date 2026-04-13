package dev.rynwllngtn.agoramarket.entities.listing;

import dev.rynwllngtn.agoramarket.entities.AuditableEntity;
import dev.rynwllngtn.agoramarket.entities.product.Product;
import dev.rynwllngtn.agoramarket.entities.seller.Seller;
import dev.rynwllngtn.agoramarket.enums.listing.ListingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "listings")
public class Listing extends AuditableEntity {

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

    public Listing(Seller seller, Product product, int stock, BigDecimal price) {
        this.seller = seller;
        this.product = product;
        this.stock = stock;
        this.price = price;
        status = ListingStatus.OPEN;
    }

    public void open() {
        status = ListingStatus.OPEN;
    }

    public void close() {
        status = ListingStatus.CLOSED;
    }

}
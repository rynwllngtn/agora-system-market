package dev.rynwllngtn.agoramarket.entities.seller;

import dev.rynwllngtn.agoramarket.entities.AuditableEntity;
import dev.rynwllngtn.agoramarket.enums.seller.SellerStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "owner_id",unique = true ,nullable = false)
    private UUID ownerId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SellerStatus status;

    public Seller(UUID ownerId, String name) {
        this.ownerId = ownerId;
        this.name = name;
        this.status = SellerStatus.ACTIVE;
    }

    public void deactivate() {
        status = SellerStatus.DEACTIVATED;
    }

    public void reactivate() {
        status = SellerStatus.ACTIVE;
    }

}
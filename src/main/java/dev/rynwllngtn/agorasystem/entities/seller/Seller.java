package dev.rynwllngtn.agorasystem.entities.seller;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "sellers")
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(name = "owner_id",unique = true ,nullable = false)
    private UUID ownerId;

    @Column(nullable = false)
    private String name;

    public Seller(UUID ownerId, String name) {
        this.ownerId = ownerId;
        this.name = name;
    }

}
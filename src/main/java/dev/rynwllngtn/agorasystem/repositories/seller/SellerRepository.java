package dev.rynwllngtn.agorasystem.repositories.seller;

import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SellerRepository extends JpaRepository<Seller, UUID> {
}
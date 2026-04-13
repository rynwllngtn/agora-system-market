package dev.rynwllngtn.agoramarket.repositories.seller;

import dev.rynwllngtn.agoramarket.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agoramarket.entities.seller.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface SellerRepository extends JpaRepository<Seller, UUID> {

    @Query(value = """
                   SELECT NEW dev.rynwllngtn.agoramarket.dtos.seller.SellerResponseDTO(s.id, s.ownerId, s.name, s.status)
                   FROM Seller AS s
                   WHERE s.id = :id
                   """)
    Optional<SellerResponseDTO> getResponseById(@Param("id") UUID id);

}
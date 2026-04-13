package dev.rynwllngtn.agoramarket.repositories.listing;

import dev.rynwllngtn.agoramarket.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agoramarket.entities.listing.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ListingRepository extends JpaRepository<Listing, UUID> {

    @Query(value = """
                   SELECT NEW dev.rynwllngtn.agoramarket.dtos.listing.ListingResponseDTO(l.id, l.seller.name, l.product.name, l.stock, l.price, l.status)
                   FROM Listing AS l
                   WHERE l.id = :id
                   """)
    Optional<ListingResponseDTO> getResponseById(@Param("id") UUID id);

}
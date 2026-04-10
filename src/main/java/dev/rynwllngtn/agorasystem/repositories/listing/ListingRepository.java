package dev.rynwllngtn.agorasystem.repositories.listing;

import dev.rynwllngtn.agorasystem.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agorasystem.entities.listing.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ListingRepository extends JpaRepository<Listing, UUID> {

    @Query(value = """
                   SELECT NEW dev.rynwllngtn.agorasystem.dtos.listing.ListingResponseDTO(l.id, l.seller.name, l.product.name, l.stock, l.price, l.status)
                   FROM Listing AS l
                   WHERE l.id = :id
                   """)
    Optional<ListingResponseDTO> getResponseById(@Param("id") UUID id);

}
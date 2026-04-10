package dev.rynwllngtn.agorasystem.services.listing;

import dev.rynwllngtn.agorasystem.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.listing.Listing;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ListingService {

    Listing findById(UUID id);

    Listing insert(ListingCreateRequestDTO createRequestDTO);

}
package dev.rynwllngtn.agoramarket.services.listing;

import dev.rynwllngtn.agoramarket.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agoramarket.entities.listing.Listing;

import java.util.UUID;

public interface ListingService {

    Listing findById(UUID id);
    ListingResponseDTO getResponseById(UUID id);

    ListingResponseDTO insert(ListingCreateRequestDTO createRequestDTO);

    ListingResponseDTO open(UUID id);
    ListingResponseDTO close(UUID id);

}
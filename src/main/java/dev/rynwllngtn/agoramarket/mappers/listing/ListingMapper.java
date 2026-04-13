package dev.rynwllngtn.agoramarket.mappers.listing;

import dev.rynwllngtn.agoramarket.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agoramarket.entities.listing.Listing;
import dev.rynwllngtn.agoramarket.entities.product.Product;
import dev.rynwllngtn.agoramarket.entities.seller.Seller;
import org.springframework.stereotype.Component;

@Component
public class ListingMapper {

    public ListingResponseDTO toResponseDTO(Listing listing) {
        return new ListingResponseDTO(listing.getId(),
                                      listing.getSeller().getName(),
                                      listing.getProduct().getName(),
                                      listing.getStock(),
                                      listing.getPrice(),
                                      listing.getStatus());
    }

    public Listing toEntity(ListingCreateRequestDTO createRequestDTO, Seller seller, Product product) {
        return new Listing(seller,
                           product,
                           createRequestDTO.stock(),
                           createRequestDTO.price());
    }

}
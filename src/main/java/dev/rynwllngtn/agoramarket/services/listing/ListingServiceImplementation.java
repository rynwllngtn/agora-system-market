package dev.rynwllngtn.agoramarket.services.listing;

import dev.rynwllngtn.agoramarket.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agoramarket.entities.listing.Listing;
import dev.rynwllngtn.agoramarket.entities.product.Product;
import dev.rynwllngtn.agoramarket.entities.seller.Seller;
import dev.rynwllngtn.agoramarket.exceptions.database.DatabaseException.ResourceNotFoundException;
import dev.rynwllngtn.agoramarket.mappers.listing.ListingMapper;
import dev.rynwllngtn.agoramarket.repositories.listing.ListingRepository;
import dev.rynwllngtn.agoramarket.services.product.ProductService;
import dev.rynwllngtn.agoramarket.services.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ListingServiceImplementation implements ListingService {

    private final ListingRepository listingRepository;
    private final SellerService sellerService;
    private final ProductService productService;
    private final ListingMapper listingMapper;

    @Override
    public Listing findById(UUID id) {
        Optional<Listing> listing = listingRepository.findById(id);
        return listing.orElseThrow(
                () -> new ResourceNotFoundException(Listing.class, id));
    }

    @Override
    public ListingResponseDTO getResponseById(UUID id) {
        Optional<ListingResponseDTO> responseDTO = listingRepository.getResponseById(id);
        return responseDTO.orElseThrow(
                () -> new ResourceNotFoundException(Listing.class, id));
    }

    @Override
    public ListingResponseDTO insert(ListingCreateRequestDTO createRequestDTO) {
        Seller seller = sellerService.findById(createRequestDTO.sellerId());
        Product product = productService.findById(createRequestDTO.productId());
        Listing listing = listingMapper.toEntity(createRequestDTO, seller, product);
        listing = listingRepository.save(listing);
        return listingMapper.toResponseDTO(listing);
    }

    @Override
    public ListingResponseDTO open(UUID id) {
        Listing listing = findById(id);
        listing.open();
        listing = listingRepository.save(listing);
        return listingMapper.toResponseDTO(listing);
    }

    @Override
    public ListingResponseDTO close(UUID id) {
        Listing listing = findById(id);
        listing.close();
        listing = listingRepository.save(listing);
        return listingMapper.toResponseDTO(listing);
    }

}
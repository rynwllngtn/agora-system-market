package dev.rynwllngtn.agorasystem.services.listing;

import dev.rynwllngtn.agorasystem.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.listing.ListingResponseDTO;
import dev.rynwllngtn.agorasystem.entities.listing.Listing;
import dev.rynwllngtn.agorasystem.entities.product.Product;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import dev.rynwllngtn.agorasystem.exceptions.database.DatabaseException.ResourceNotFoundException;
import dev.rynwllngtn.agorasystem.mappers.listing.ListingMapper;
import dev.rynwllngtn.agorasystem.repositories.listing.ListingRepository;
import dev.rynwllngtn.agorasystem.services.product.ProductService;
import dev.rynwllngtn.agorasystem.services.seller.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ListingServiceImplementation implements ListingService {

    final private ListingRepository listingRepository;
    final private SellerService sellerService;
    final private ProductService productService;
    final private ListingMapper listingMapper;

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
        Listing listing = listingRepository.getReferenceById(id);
        listing.open();
        listing = listingRepository.save(listing);
        return listingMapper.toResponseDTO(listing);
    }

    @Override
    public ListingResponseDTO close(UUID id) {
        Listing listing = listingRepository.getReferenceById(id);
        listing.close();
        listing = listingRepository.save(listing);
        return listingMapper.toResponseDTO(listing);
    }

}
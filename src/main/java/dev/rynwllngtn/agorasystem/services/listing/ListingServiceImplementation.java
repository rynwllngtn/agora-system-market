package dev.rynwllngtn.agorasystem.services.listing;

import dev.rynwllngtn.agorasystem.dtos.listing.ListingCreateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.listing.Listing;
import dev.rynwllngtn.agorasystem.entities.product.Product;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import dev.rynwllngtn.agorasystem.repositories.listing.ListingRepository;
import dev.rynwllngtn.agorasystem.repositories.seller.SellerRepository;
import dev.rynwllngtn.agorasystem.services.product.ProductService;
import dev.rynwllngtn.agorasystem.services.seller.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ListingServiceImplementation implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private SellerService sellerService;

    @Autowired
    private ProductService productService;

    @Override
    public Listing findById(UUID id) {
        Optional<Listing> listing = listingRepository.findById(id);
        return listing.get();
    }

    @Override
    public Listing insert(ListingCreateRequestDTO createRequestDTO) {
        Seller seller = sellerService.findById(createRequestDTO.sellerId());
        Product product = productService.findById(createRequestDTO.productId());
        Listing listing = new Listing(seller,
                                      product,
                                      createRequestDTO.stock(),
                                      createRequestDTO.price(),
                                      createRequestDTO.status());

        return listingRepository.save(listing);
    }

}
package dev.rynwllngtn.agorasystem.services.seller;

import dev.rynwllngtn.agorasystem.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import dev.rynwllngtn.agorasystem.repositories.seller.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class SellerServiceImplementation implements SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public Seller findById(UUID id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return seller.get();
    }

    @Override
    public Seller insert(SellerCreateRequestDTO createRequestDTO) {
        Seller seller = new Seller(createRequestDTO.owner(),
                                   createRequestDTO.name());

        return sellerRepository.save(seller);
    }

}
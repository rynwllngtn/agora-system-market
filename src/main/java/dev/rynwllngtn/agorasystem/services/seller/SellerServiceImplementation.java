package dev.rynwllngtn.agorasystem.services.seller;

import dev.rynwllngtn.agorasystem.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agorasystem.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agorasystem.entities.seller.Seller;
import dev.rynwllngtn.agorasystem.mappers.seller.SellerMapper;
import dev.rynwllngtn.agorasystem.repositories.seller.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class SellerServiceImplementation implements SellerService {

    private final SellerRepository sellerRepository;
    private final SellerMapper sellerMapper;

    @Override
    public Seller findById(UUID id) {
        Optional<Seller> seller = sellerRepository.findById(id);
        return seller.get();
    }

    @Override
    public SellerResponseDTO insert(SellerCreateRequestDTO createRequestDTO) {
        Seller seller = sellerMapper.toEntity(createRequestDTO);
        seller = sellerRepository.save(seller);
        return sellerMapper.toResponseDTO(seller);
    }

}
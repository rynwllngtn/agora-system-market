package dev.rynwllngtn.agoramarket.services.seller;

import dev.rynwllngtn.agoramarket.dtos.seller.SellerCreateRequestDTO;
import dev.rynwllngtn.agoramarket.dtos.seller.SellerResponseDTO;
import dev.rynwllngtn.agoramarket.entities.seller.Seller;
import dev.rynwllngtn.agoramarket.exceptions.database.DatabaseException.ResourceNotFoundException;
import dev.rynwllngtn.agoramarket.mappers.seller.SellerMapper;
import dev.rynwllngtn.agoramarket.repositories.seller.SellerRepository;
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
        return seller.orElseThrow(
                () -> new ResourceNotFoundException(Seller.class, id));
    }

    @Override
    public SellerResponseDTO getResponseById(UUID id) {
        Optional<SellerResponseDTO> responseDTO = sellerRepository.getResponseById(id);
        return responseDTO.orElseThrow(
                () -> new ResourceNotFoundException(Seller.class, id));
    }

    @Override
    public SellerResponseDTO insert(SellerCreateRequestDTO createRequestDTO) {
        Seller seller = sellerMapper.toEntity(createRequestDTO);
        seller = sellerRepository.save(seller);
        return sellerMapper.toResponseDTO(seller);
    }

    @Override
    public SellerResponseDTO deactivate(UUID id) {
        Seller seller = findById(id);
        seller.deactivate();
        seller = sellerRepository.save(seller);
        return sellerMapper.toResponseDTO(seller);
    }

    @Override
    public SellerResponseDTO reactivate(UUID id) {
        Seller seller = findById(id);
        seller.reactivate();
        seller = sellerRepository.save(seller);
        return sellerMapper.toResponseDTO(seller);
    }

}
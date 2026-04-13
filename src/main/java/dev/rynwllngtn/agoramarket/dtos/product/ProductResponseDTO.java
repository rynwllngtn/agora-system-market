package dev.rynwllngtn.agoramarket.dtos.product;

import java.util.UUID;

public record ProductResponseDTO(
        UUID id,
        String name,
        String description
) {}
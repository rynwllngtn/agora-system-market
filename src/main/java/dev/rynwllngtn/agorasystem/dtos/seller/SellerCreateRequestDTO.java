package dev.rynwllngtn.agorasystem.dtos.seller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SellerCreateRequestDTO(
        @NotNull(message = "Owner não pode ser vazio ou null!")
        UUID owner,
        @NotEmpty(message = "Nome não pode ser vazio ou null!")
        String name
) {}
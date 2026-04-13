package dev.rynwllngtn.agoramarket.dtos.product;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record ProductCreateRequestDTO(
        @NotEmpty(message = "Nome não pode ser vazio ou null!")
        String name,
        @NotNull(message = "Descrição não pode ser null!")
        String description
) {}
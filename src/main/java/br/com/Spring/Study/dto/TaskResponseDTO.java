package br.com.Spring.Study.dto;

import br.com.Spring.Study.entity.enums.TaskLevel;

public record TaskResponseDTO(
        Long id,
        String name,
        TaskLevel level
) {
}

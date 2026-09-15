package br.com.Spring.Study.dto;

import br.com.Spring.Study.entity.enums.TaskLevel;

public record TaskRequestDTO(
        String name,
        TaskLevel level) {

}

package br.com.Spring.Study.dto;

import br.com.Spring.Study.entity.enums.WorkerLevel;

import java.math.BigDecimal;
import java.time.LocalDate;


public record WorkerResponseDTO(

        Long id,
        String name,
        WorkerLevel level,
        BigDecimal salary,
        LocalDate dateStart,
        String taskName) {
}

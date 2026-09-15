package br.com.Spring.Study.dto;

import br.com.Spring.Study.entity.TaskEntity;
import br.com.Spring.Study.entity.enums.WorkerLevel;

import java.math.BigDecimal;
import java.time.LocalDate;

public record WorkerRequestDTO(

        String name,
        WorkerLevel level,
        BigDecimal salary,
        LocalDate dateStart,
        Long taskId) {
}

package br.com.Spring.Study.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_registration")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID",updatable = false,nullable = false)
    private UUID id;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Company",nullable = false)
    private String company;

    @Column(name = "Position",nullable = false)
    private String position;

    @Column(name = "Salary",nullable = false)
    private BigDecimal salary;

    @Column(name = "DateStart",nullable = false)
    private LocalDate dateStart;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    }

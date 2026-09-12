package br.com.Spring.Study.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
@ToString(exclude = "task")
@EqualsAndHashCode(exclude = "task")
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_registration")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false,nullable = false)
    private UUID id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column(nullable = false,length = 70)
    private String company;

    @Column(nullable = false,length = 50)
    private String position;

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(nullable = false)
    private LocalDate dateStart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    }

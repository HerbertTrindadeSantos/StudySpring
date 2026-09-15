package br.com.Spring.Study.entity;

import br.com.Spring.Study.entity.enums.WorkerLevel;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false,nullable = false)
    private Long id;

    @Column(nullable = false,length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 30)
    private WorkerLevel level;

    @Column(nullable = false)
    private BigDecimal salary;

    @Column(nullable = false)
    private LocalDate dateStart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id")
    private TaskEntity task;

    }

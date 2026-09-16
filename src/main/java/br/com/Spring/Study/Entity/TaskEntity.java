package br.com.Spring.Study.entity;

import br.com.Spring.Study.entity.enums.TaskLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "worker")
@EqualsAndHashCode(exclude = "worker")
@Entity
@Table(name = "tb_jobs")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private TaskLevel level;

    @OneToMany(mappedBy = "task")
    private List<WorkerEntity> workers = new ArrayList<>();


}

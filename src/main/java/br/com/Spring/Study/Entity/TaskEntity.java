package br.com.Spring.Study.Entity;

import br.com.Spring.Study.Entity.Enum.TaskLevel;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "worker")
@EqualsAndHashCode(exclude = "worker")
@Entity
@Table(name = "tb_jobs")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(updatable = false,nullable = false)
    private UUID id;

    @Column(nullable = false,length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "level",nullable = false,length = 20)
    private TaskLevel task;

    @OneToMany(mappedBy = "task")
    private List<WorkerEntity> workers = new ArrayList<>();


}

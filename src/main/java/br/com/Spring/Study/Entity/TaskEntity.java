package br.com.Spring.Study.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tab_jobs")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Level")
    private int level;

    @Column(name = "Worker")
    @OneToMany(mappedBy = "task")
    private List<WorkerEntity> workers;


}

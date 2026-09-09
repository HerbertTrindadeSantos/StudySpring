package br.com.Spring.Study.Entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "tab_jobs")
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

    protected TaskEntity() {
    }

    public TaskEntity(String name, int difficulty) {
        this.name = name;
        this.level = difficulty;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}

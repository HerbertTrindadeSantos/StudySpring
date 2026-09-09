package br.com.Spring.Study.Entity;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tb_registration")
public class WorkerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Company")
    private String company;
    @Column(name = "Position")
    private String position;
    @Column(name = "Salary")
    private BigDecimal salary;
    @Column(name = "DateStart")
    private LocalDate dateStart;

    public WorkerEntity(){

    }

    public WorkerEntity(String name, String company, String position, BigDecimal salary, LocalDate dateStart) {
        this.name = name;
        this.company = company;
        this.position = position;
        this.salary = salary;
        this.dateStart = dateStart;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }
}

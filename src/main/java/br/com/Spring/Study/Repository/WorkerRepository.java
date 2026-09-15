package br.com.Spring.Study.repository;

import br.com.Spring.Study.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
}

package br.com.Spring.Study.Service;

import br.com.Spring.Study.Entity.WorkerEntity;
import br.com.Spring.Study.Repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public WorkerEntity register(WorkerEntity worker) {
        return workerRepository.save(worker);
    }

    public WorkerEntity update(UUID id, WorkerEntity newWorker) {
        WorkerEntity worker = workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        worker.setName(newWorker.getName());
        worker.setSalary(newWorker.getSalary());
        worker.setPosition(newWorker.getPosition());
        worker.setCompany(newWorker.getCompany());
        worker.setDateStart(newWorker.getDateStart());
        worker.setTask(newWorker.getTask());

        return workerRepository.save(worker);
    }

    public void delete(UUID id) {
        workerRepository.deleteById(id);
    }

    public WorkerEntity findById(UUID id) {
        WorkerEntity worker = workerRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));

        return worker;
    }

    public List<WorkerEntity> findByAll(){
        return workerRepository.findAll();
    }
}

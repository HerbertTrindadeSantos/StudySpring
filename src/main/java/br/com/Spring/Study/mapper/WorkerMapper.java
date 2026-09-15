package br.com.Spring.Study.mapper;

import br.com.Spring.Study.dto.WorkerRequestDTO;
import br.com.Spring.Study.dto.WorkerResponseDTO;
import br.com.Spring.Study.entity.WorkerEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkerMapper {

    public WorkerEntity toEntity(WorkerRequestDTO woker){

        WorkerEntity workerEntity = new WorkerEntity();

        workerEntity.setName(woker.name());
        workerEntity.setLevel(woker.level());
        workerEntity.setSalary(woker.salary());
        workerEntity.setDateStart(woker.dateStart());
        workerEntity.setTask(woker.taskId());

        return workerEntity;
    }

    public WorkerResponseDTO toResponseDTO(WorkerEntity worker){

        return new WorkerResponseDTO(
                worker.getId(),
                worker.getName(),
                worker.getLevel(),
                worker.getSalary(),
                worker.getDateStart(),
                worker.getTask());
    }

    public WorkerEntity workerEntityUpdate(WorkerEntity worker,WorkerRequestDTO workerRequestDTO){

        worker.setName(workerRequestDTO.name());
        worker.setSalary(workerRequestDTO.salary());
        worker.setDateStart(workerRequestDTO.dateStart());
        worker.setTask(workerRequestDTO.taskId());

        return worker;
    }
}

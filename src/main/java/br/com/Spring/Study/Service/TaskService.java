package br.com.Spring.Study.Service;

import br.com.Spring.Study.Entity.TaskEntity;
import br.com.Spring.Study.Repository.TaskRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity register(TaskEntity task){
        return taskRepository.save(task);
    }

    public TaskEntity updade(UUID id,TaskEntity newTask){

        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        taskEntity.setName(newTask.getName());
        taskEntity.setTask(newTask.getTask());
        return taskRepository.save(taskEntity);
    }

    public void delete(UUID id){
        taskRepository.deleteById(id);
    }

    public TaskEntity findId(UUID id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario nao encontrado"));
        return task;
    }

    public List<TaskEntity> findByAll(){
        return taskRepository.findAll();
    }
}

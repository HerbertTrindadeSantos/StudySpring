package br.com.Spring.Study.service;

import br.com.Spring.Study.dto.TaskRequestDTO;
import br.com.Spring.Study.entity.TaskEntity;
import br.com.Spring.Study.exceptions.TaskNotFoundException;
import br.com.Spring.Study.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskRequestDTO register(TaskEntity task){
        return taskRepository.save(task);
    }

    public TaskRequestDTO updade(UUID id, TaskEntity newTask){

        TaskEntity taskEntity = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarefa nao encontrada"));
        taskEntity.setName(newTask.getName());
        taskEntity.setTask(newTask.getTask());
        return taskRepository.save(taskEntity);
    }

    public void delete(Long id){
        taskRepository.deleteById(id);
    }

    public TaskRequestDTO findId(Long id){
        TaskEntity task = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Tarefa nao encontrada"));
        return task;
    }

    public List<TaskEntity> findByAll(){
        return taskRepository.findAll();
    }
}

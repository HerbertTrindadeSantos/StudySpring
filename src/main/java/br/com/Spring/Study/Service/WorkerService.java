package br.com.Spring.Study.service;

import br.com.Spring.Study.dto.WorkerRequestDTO;
import br.com.Spring.Study.dto.WorkerResponseDTO;
import br.com.Spring.Study.entity.WorkerEntity;
import br.com.Spring.Study.exceptions.WorkerNotFoundException;
import br.com.Spring.Study.mapper.WorkerMapper;
import br.com.Spring.Study.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class WorkerService {

    private final WorkerMapper mapper;
    private final WorkerRepository workerRepository;

    public WorkerResponseDTO register(WorkerRequestDTO workerRequestDTO) {

        WorkerEntity worker = mapper.toEntity(workerRequestDTO);

        WorkerEntity savedWorker = workerRepository.save(worker);

        return mapper.toResponseDTO(savedWorker);
    }

    public WorkerResponseDTO update(Long id, WorkerRequestDTO workerRequestDTO) {

        WorkerEntity worker = workerRepository.findById(id)
                .orElseThrow(() -> new WorkerNotFoundException("Worker nao encontrado id: " + id));

        WorkerEntity updateWorker = workerRepository.save(mapper.workerEntityUpdate(worker, workerRequestDTO));

        return mapper.toResponseDTO(updateWorker);
    }

    public void deleteById(long id) {

        if (!workerRepository.existsById(id)) {
            throw new WorkerNotFoundException("Worker nao encontrado id: " + id);
        }
        workerRepository.deleteById(id);

    }

    public WorkerResponseDTO findId(Long id) {
        WorkerEntity worker = workerRepository.findById(id).
                orElseThrow(() -> new WorkerNotFoundException("Worker nao encontrado id: " + id));
        return mapper.toResponseDTO(worker);
    }

    public List<WorkerResponseDTO> findByAll() {

        return workerRepository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .toList();
    }
}

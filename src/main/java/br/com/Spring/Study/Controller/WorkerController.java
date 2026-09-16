package br.com.Spring.Study.controller;

import br.com.Spring.Study.dto.WorkerRequestDTO;
import br.com.Spring.Study.dto.WorkerResponseDTO;
import br.com.Spring.Study.service.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping()
    public ResponseEntity<WorkerResponseDTO> register(@RequestBody WorkerRequestDTO worker) {

        WorkerResponseDTO newWorker = workerService.register(worker);

        return ResponseEntity.status(HttpStatus.CREATED).body(newWorker);
    }

    @GetMapping()
    public ResponseEntity<List<WorkerResponseDTO>> findByAll(){

        List<WorkerResponseDTO> workers = workerService.findByAll();

        return  ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerResponseDTO> findId(@PathVariable Long id){

            WorkerResponseDTO worker = workerService.findId(id);
            return ResponseEntity.ok(worker);

    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerResponseDTO> update(@PathVariable Long id, @RequestBody WorkerRequestDTO worker) {

            WorkerResponseDTO newWorker = workerService.update(id,worker);

            return ResponseEntity.ok(newWorker);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

            workerService.deleteById(id);

            return ResponseEntity.noContent().build();
    }


}

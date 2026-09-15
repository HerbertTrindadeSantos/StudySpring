package br.com.Spring.Study.controller;

import br.com.Spring.Study.dto.WorkerRequestDTO;
import br.com.Spring.Study.dto.WorkerResponseDTO;
import br.com.Spring.Study.entity.WorkerEntity;
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
        try {
            WorkerResponseDTO newWorker = workerService.register(worker);
            return ResponseEntity.status(HttpStatus.CREATED).body(newWorker);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<WorkerResponseDTO>> findByAll(){
        List<WorkerResponseDTO> workers = workerService.findByAll();
        return  ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkerResponseDTO> findId(@PathVariable Long id){
        try {
            WorkerResponseDTO worker = workerService.findId(id);
            return ResponseEntity.ok(worker);
        } catch (RuntimeException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkerResponseDTO> update(@PathVariable Long id, @RequestBody WorkerRequestDTO worker) {
        try{
            WorkerResponseDTO newWorker = workerService.update(id,worker);
            return ResponseEntity.ok(newWorker);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkerResponseDTO> delete(@PathVariable Long id){
        try{
            workerService.deleteById(id);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}

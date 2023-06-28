package by.test.core.controllers;

import by.test.api.dto.worker.WorkerDto;
import by.test.api.dto.worker.WorkerListResponse;
import by.test.core.controllers.interfaces.WorkerController;
import by.test.core.mappers.WorkerMapper;
import by.test.core.services.interfaces.WorkerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v${test.api.version}/workers")
@RequiredArgsConstructor
public class WorkerControllerImpl implements WorkerController {
    private final WorkerService workerService;
    private final WorkerMapper workerMapper;

    @Override
    public WorkerListResponse findAllWorkers() {
        return WorkerListResponse.builder()
                .worker(workerService.findAll().stream()
                        .map(workerMapper::mapToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public WorkerDto findWorkerById(Long id) {
        return workerMapper.mapToDto(workerService.findById(id));
    }

    @Override
    public WorkerDto saveWorker(WorkerDto workerDto) {
        return workerMapper.mapToDto(workerService.save(workerMapper.mapFromDto(workerDto)));
    }

    @Override
    public void updateWorker(WorkerDto workerDto) {
        workerService.update(workerMapper.mapFromDto(workerDto));
    }

    @Override
    public void deleteWorker(Long id) {
        workerService.deleteById(id);
    }
}

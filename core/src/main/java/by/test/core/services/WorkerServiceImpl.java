package by.test.core.services;

import by.test.core.entities.Client;
import by.test.core.entities.Worker;
import by.test.core.repositories.WorkerRepository;
import by.test.core.services.interfaces.WorkerService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerRepository workerRepository;

    @Override
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker findById(Long id) {
        return workerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Worker id = " + id + " not found"));
    }

    @Override
    public Worker save(Worker worker) {
        return workerRepository.save(worker);
    }

    @Override
    public void update(Worker worker) {
        Optional<Worker> tmpWorker = workerRepository.findById(worker.getId());
        if (tmpWorker.isPresent()) {
            tmpWorker.get().setFirstName(worker.getFirstName());
            tmpWorker.get().setSurname(worker.getSurname());
            tmpWorker.get().setLastName(worker.getLastName());
            tmpWorker.get().setSpecialization(worker.getSpecialization());
            tmpWorker.get().setCostOfOneHour(worker.getCostOfOneHour());
            workerRepository.save(tmpWorker.get());
        }
    }

    @Override
    public void deleteById(Long id) {
        workerRepository.deleteById(id);
    }
}

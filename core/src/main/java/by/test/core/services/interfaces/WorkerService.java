package by.test.core.services.interfaces;

import by.test.core.entities.Worker;

import java.util.List;

public interface WorkerService {
    List<Worker> findAll();

    Worker findById(Long id);

    Worker save(Worker worker);

    void update(Worker worker);

    void deleteById(Long id);
}

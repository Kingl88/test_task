package by.test.core.services.interfaces;

import by.test.core.entities.Work;

import java.util.List;

public interface WorkService {
    List<Work> findAll();

    Work findById(Long id);

    Work save(Work autoPart);

    void update(Work autoPart);

    void deleteById(Long id);
}

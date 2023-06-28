package by.test.core.services;

import by.test.core.entities.Work;
import by.test.core.entities.Worker;
import by.test.core.repositories.WorkRepository;
import by.test.core.services.interfaces.WorkService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {
    private final WorkRepository workRepository;

    @Override
    public List<Work> findAll() {
        return workRepository.findAll();
    }

    @Override
    public Work findById(Long id) {
        return workRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Work id = " + id + " not found"));
    }

    @Override
    public Work save(Work work) {
        return workRepository.save(work);
    }

    @Override
    public void update(Work work) {
        Optional<Work> tmpWork = workRepository.findById(work.getId());
        if (tmpWork.isPresent()) {
            tmpWork.get().setDescription(work.getDescription());
            tmpWork.get().setName(work.getName());
            tmpWork.get().setTimeSpentOnWork(work.getTimeSpentOnWork());
            workRepository.save(tmpWork.get());
        }
    }

    @Override
    public void deleteById(Long id) {
        workRepository.deleteById(id);
    }
}

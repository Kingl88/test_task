package by.test.core.services;

import by.test.core.entities.AutoPart;
import by.test.core.entities.Client;
import by.test.core.repositories.AutoPartRepository;
import by.test.core.services.interfaces.AutoPartService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AutoPartServiceImpl implements AutoPartService {
    private final AutoPartRepository autoPartRepository;

    @Override
    public List<AutoPart> findAll() {
        return autoPartRepository.findAll();
    }

    @Override
    public AutoPart findById(Long id) {
        return autoPartRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AutoPart id = " + id + " not found"));
    }

    @Override
    public AutoPart save(AutoPart autoPart) {
        return autoPartRepository.save(autoPart);
    }

    @Override
    public void update(AutoPart autoPart) {
        Optional<AutoPart> tmpAutoPart = autoPartRepository.findById(autoPart.getId());
        if (tmpAutoPart.isPresent()) {
            tmpAutoPart.get().setCost(autoPart.getCost());
            tmpAutoPart.get().setNameOfPart(autoPart.getNameOfPart());
            tmpAutoPart.get().setDistributor(autoPart.getDistributor());
            autoPartRepository.save(tmpAutoPart.get());
        }
    }

    @Override
    public void deleteById(Long id) {
        autoPartRepository.deleteById(id);
    }
}

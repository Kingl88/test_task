package by.test.core.services.interfaces;

import by.test.core.entities.AutoPart;

import java.util.List;

public interface AutoPartService {
    List<AutoPart> findAll();

    AutoPart findById(Long id);

    AutoPart save(AutoPart autoPart);

    void update(AutoPart autoPart);

    void deleteById(Long id);
}

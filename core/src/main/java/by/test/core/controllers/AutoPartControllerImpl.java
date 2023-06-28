package by.test.core.controllers;

import by.test.api.dto.auto_part.AutoPartDto;
import by.test.api.dto.auto_part.AutoPartListResponse;
import by.test.core.controllers.interfaces.AutoPartController;
import by.test.core.mappers.AutoPartMapper;
import by.test.core.services.interfaces.AutoPartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v${test.api.version}/parts")
@RequiredArgsConstructor
public class AutoPartControllerImpl implements AutoPartController {
    private final AutoPartService autoPartService;
    private final AutoPartMapper autoPartMapper;

    @Override
    public AutoPartListResponse findAllAutoParts() {
        return AutoPartListResponse.builder()
                .autoParts(autoPartService.findAll().stream()
                        .map(autoPartMapper::mapToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public AutoPartDto findAutoPartById(Long id) {
        return autoPartMapper.mapToDto(autoPartService.findById(id));
    }

    @Override
    public AutoPartDto saveAutoPart(AutoPartDto autoPartDto) {
        return autoPartMapper.mapToDto(autoPartService.save(autoPartMapper.mapFromDto(autoPartDto)));
    }

    @Override
    public void updateAutoPart(AutoPartDto autoPartDto) {
        autoPartService.update(autoPartMapper.mapFromDto(autoPartDto));
    }

    @Override
    public void deleteAutoPart(Long id) {
        autoPartService.deleteById(id);
    }
}

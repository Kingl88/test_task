package by.test.core.controllers;

import by.test.api.dto.work.WorkDto;
import by.test.api.dto.work.WorkListResponse;
import by.test.core.controllers.interfaces.WorkController;
import by.test.core.mappers.WorkMapper;
import by.test.core.services.interfaces.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v${test.api.version}/works")
@RequiredArgsConstructor
public class WorkControllerImpl implements WorkController {
    private final WorkService workService;
    private final WorkMapper workMapper;

    @Override
    public WorkListResponse findAllWorks() {
        return WorkListResponse.builder()
                .works(workService.findAll().stream()
                        .map(workMapper::mapToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public WorkDto findWorkById(Long id) {
        return workMapper.mapToDto(workService.findById(id));
    }

    @Override
    public WorkDto saveWork(WorkDto workDto) {
        return workMapper.mapToDto(workService.save(workMapper.mapFromDto(workDto)));
    }

    @Override
    public void updateWork(WorkDto workDto) {
        workService.update(workMapper.mapFromDto(workDto));
    }

    @Override
    public void deleteWork(Long id) {
        workService.deleteById(id);
    }
}

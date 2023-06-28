package by.test.core.mappers;

import by.test.api.dto.worker.WorkerDto;
import by.test.core.entities.Worker;
import org.mapstruct.Mapper;

@Mapper
public interface WorkerMapper {
    WorkerDto mapToDto(Worker entity);

    Worker mapFromDto(WorkerDto dto);
}

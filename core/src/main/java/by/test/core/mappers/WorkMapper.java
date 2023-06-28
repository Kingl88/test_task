package by.test.core.mappers;

import by.test.api.dto.work.WorkDto;
import by.test.core.entities.Work;
import org.mapstruct.Mapper;

@Mapper(uses = {OrderMapper.class, WorkerMapper.class})
public interface WorkMapper {
    WorkDto mapToDto(Work entity);

    Work mapFromDto(WorkDto dto);
}

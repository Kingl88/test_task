package by.test.core.mappers;

import by.test.api.dto.auto_part.AutoPartDto;
import by.test.core.entities.AutoPart;
import org.mapstruct.Mapper;

@Mapper(uses = {OrderMapper.class})
public interface AutoPartMapper {
    AutoPartDto mapToDto(AutoPart entity);

    AutoPart mapFromDto(AutoPartDto dto);
}

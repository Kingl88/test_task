package by.test.core.mappers;

import by.test.api.dto.client.ClientDto;
import by.test.core.entities.Client;
import org.mapstruct.Mapper;

@Mapper
public interface ClientMapper {
    ClientDto mapToDto(Client entity);

    Client mapFromDto(ClientDto dto);
}

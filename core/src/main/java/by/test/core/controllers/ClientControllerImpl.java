package by.test.core.controllers;

import by.test.api.dto.client.ClientDto;
import by.test.api.dto.client.ClientListResponse;
import by.test.core.controllers.interfaces.ClientController;
import by.test.core.mappers.ClientMapper;
import by.test.core.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v${test.api.version}/clients")
@RequiredArgsConstructor
public class ClientControllerImpl implements ClientController {
    private final ClientService clientService;
    private final ClientMapper clientMapper;

    @Override
    public ClientListResponse findAllClients() {
        return ClientListResponse.builder()
                .clients(clientService.findAll().stream()
                        .map(clientMapper::mapToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    @Override
    public ClientDto findClientById(Long id) {
        return clientMapper.mapToDto(clientService.findById(id));
    }

    @Override
    public ClientDto saveClient(ClientDto clientDto) {
        return clientMapper.mapToDto(clientService.save(clientMapper.mapFromDto(clientDto)));
    }

    @Override
    public void updateClient(ClientDto clientDto) {
        clientService.update(clientMapper.mapFromDto(clientDto));
    }

    @Override
    public void deleteClient(Long id) {
        clientService.deleteById(id);
    }
}

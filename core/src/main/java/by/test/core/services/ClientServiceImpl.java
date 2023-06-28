package by.test.core.services;

import by.test.core.entities.Client;
import by.test.core.repositories.ClientRepository;
import by.test.core.services.interfaces.ClientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client id = " + id + " not found"));
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void update(Client client) {
        Optional<Client> tmpClient = clientRepository.findById(client.getId());
        if (tmpClient.isPresent()) {
            tmpClient.get().setCarDescription(client.getCarDescription());
            tmpClient.get().setFirstName(client.getFirstName());
            tmpClient.get().setSurname(client.getSurname());
            tmpClient.get().setLastName(client.getLastName());
            tmpClient.get().setPhoneNumber(client.getPhoneNumber());
            clientRepository.save(tmpClient.get());
        }
    }

    @Override
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }
}

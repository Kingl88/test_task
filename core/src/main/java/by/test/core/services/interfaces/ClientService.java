package by.test.core.services.interfaces;

import by.test.core.entities.Client;

import java.util.List;

public interface ClientService {
    List<Client> findAll();

    Client findById(Long id);

    Client save(Client client);

    void update(Client client);

    void deleteById(Long id);
}

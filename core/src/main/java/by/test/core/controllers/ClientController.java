package by.test.core.controllers;

import by.test.core.entities.Client;
import by.test.core.services.interfaces.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v${test.api.version}/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @GetMapping
    public List<Client> findAllClients() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findClientById(@PathVariable Long id) {
        return clientService.findById(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    @PutMapping
    public void updateClient(@RequestBody Client client) {
        clientService.update(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteById(id);
    }
}

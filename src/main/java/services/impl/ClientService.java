package services.impl;

import entities.Address;
import entities.Client;
import repositories.ClientRepository;
import repositories.IClientRepository;
import services.IClientService;

import java.sql.SQLException;

public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    public ClientService() {
        this.clientRepository = new ClientRepository();
    }

    public Client addClient(String nome, String cpf) {
        if (nome == null || cpf == null) {
            return null;
        }
        Client client = new Client(cpf, nome);
        try {
            this.clientRepository.insert(client);
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return client;
    }

    public Client updateClientAddress(String cpf, Address address) {
        return null;
    }

    public Client updateClientPhone(String cpf, String phone) {
        if (cpf == null || phone == null) {
            return null;
        }
        Client client = this.clientRepository.find(cpf);
        client.setPhone(phone);
        this.clientRepository.update(cpf, client);
        return client;
    }
}

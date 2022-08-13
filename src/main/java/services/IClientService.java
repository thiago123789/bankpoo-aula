package services;

import entities.Address;
import entities.Client;

public interface IClientService {

    Client addClient(String nome, String cpf);
    Client updateClientAddress(String cpf, Address address);
    Client updateClientPhone(String cpf, String phone);

}

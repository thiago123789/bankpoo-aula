package repositories;

/// Repositorio é padrao que vamos usar para acesso a dados/manipulação


import entities.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientRepository {
    Client insert(Client client) throws SQLException;

    List<Client> findAll();
    Client find(String cpf);
    Client update(String cpf, Client client);
    void delete(String cpf);
}


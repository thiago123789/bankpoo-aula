import entities.Account;
import entities.Client;
import repositories.ClientRepository;
import repositories.DbConnection;
import repositories.IClientRepository;
import services.IClientService;
import services.impl.ClientService;

import java.sql.SQLException;

public class Application {

    public static void main(String[] args) throws SQLException {

        IClientService clientService = new ClientService();

        Client saved = clientService.addClient("thiago", "9999999999");

        System.out.println(saved);
//
//        Client updated = clientService.updateClientPhone("9999999999", "81999887766");
//
//        System.out.println(updated);


        // Testando repositorio com banco de dados
//        Client c1 = new Client("12345678901", "Thomas");
//
//        System.out.println("ID C1 ANTES DE SALVAR: " + c1.getId());
//        IClientRepository clientRepository = new ClientRepository();
//
//        clientRepository.insert(c1);
//
//        System.out.println("ID C1 DEPOIS DE SALVAR: " + c1.getId());

    }
}

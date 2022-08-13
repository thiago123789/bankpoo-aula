package repositories;

import entities.Client;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClientRepository implements IClientRepository {

    private final DbConnection dbConnection;

    public ClientRepository() {
        this.dbConnection = DbConnection.getInstance();
    }

    public Client insert(Client client) throws SQLException {
        //INSERT INTO bank_poo.client(cpf, nome, phone)
        //    values('99999999901', 'Natalia', null);
        String sql = "INSERT INTO bank_poo.client(cpf, nome, phone) VALUES(?, ?, ?)";
        try{
            PreparedStatement smt = (PreparedStatement) dbConnection.retornoStatement(sql);
            smt.setString(1, client.getCpf());
            smt.setString(2, client.getNome());
            smt.setString(3, client.getPhone());

            //Executa o comando sql construido
            smt.execute();

            //Recupera o resultado do comando executado
            ResultSet rs = smt.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                client.setId(id);
                return client;
            }
        }catch(Exception e){
            throw e;
        }
        return null;
    }

    public List<Client> findAll() {
        return null;
    }

    public Client find(String cpf) {
        return null;
    }

    public Client update(String cpf, Client client) {
        return null;
    }

    public void delete(String cpf) {

    }
}

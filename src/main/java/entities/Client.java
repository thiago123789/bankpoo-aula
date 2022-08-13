package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private int id;
    private String cpf;
    private String nome;
    private String phone;

    public Client(String cpf, String nome) {
        this.cpf = cpf;
        this.setNome(nome);
    }

    public void setCpf(String cpf) {
        if (this.cpf != null) {
            this.cpf = cpf;
        }
    }
}

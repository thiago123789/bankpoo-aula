package entities;

import lombok.Data;

@Data
public class Account {
    private String accountNumber;

    private float balance;

    private Agency agency;

    private Client client;
}
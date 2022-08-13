package entities;

import lombok.Data;

@Data
public class Address {
    private String city;

    private String zipCode;

    private int addressNumber;

    private String street;

    private String complement;

    private String state;

    private String neighborhood;

    private String country;
}

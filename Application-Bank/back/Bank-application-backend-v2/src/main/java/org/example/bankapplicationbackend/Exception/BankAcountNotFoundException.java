package org.example.bankapplicationbackend.Exception;

public class BankAcountNotFoundException extends Exception {
    public BankAcountNotFoundException(String banckNotFoundException) {
        super(banckNotFoundException);
    }
}

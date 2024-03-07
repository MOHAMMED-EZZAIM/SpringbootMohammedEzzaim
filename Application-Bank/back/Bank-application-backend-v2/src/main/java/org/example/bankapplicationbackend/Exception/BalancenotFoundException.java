package org.example.bankapplicationbackend.Exception;

public class BalancenotFoundException extends Exception {
    public BalancenotFoundException(String soldNoFound) {
        super(soldNoFound);
    }
}

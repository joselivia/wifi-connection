package com.jose.Wifi_setup.request;

public class MpesaRequest {
    private String phoneNumber;
    private String amount;
    private String accountReference;
    private String transactionDesc;

    // Constructor, getters, and setters
    public MpesaRequest(String phoneNumber, String amount, String accountReference, String transactionDesc) {
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.accountReference = accountReference;
        this.transactionDesc = transactionDesc;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAmount() {
        return amount;
    }

    public String getAccountReference() {
        return accountReference;
    }

    public String getTransactionDesc() {
        return transactionDesc;
    }
}

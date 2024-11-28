package com.jose.Wifi_setup.services;

import com.jose.Wifi_setup.request.MpesaRequest;
import org.springframework.http.ResponseEntity;

public class MpesaServices {
    public ResponseEntity<String> stkPush(String phoneNumber, String amount, String accountReference, String transactionDesc) {


        return ResponseEntity.ok("wait for the code to run");
    }


    public boolean initiateStkPush(String phone) {
        // Implement your STK push logic here
        try {
            String amount = "100"; // Example amount
            String accountReference = "WiFi Payment";
            String transactionDesc = "Payment for WiFi access";

            MpesaRequest mpesaRequest = new MpesaRequest(phone, amount, accountReference, transactionDesc);
            ResponseEntity<String> response = stkPush(mpesaRequest.getPhoneNumber(), mpesaRequest.getAmount(),
                    mpesaRequest.getAccountReference(), mpesaRequest.getTransactionDesc());

            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

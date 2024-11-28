package com.jose.Wifi_setup.Controller;

import com.jose.Wifi_setup.request.MpesaRequest;
import com.jose.Wifi_setup.services.MpesaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


@ResponseBody

public class WifiController {
    @Autowired
    private MpesaServices mpesaServices;
    @PostMapping("/pay")
public ResponseEntity<String> initiatePayment(@RequestParam String phone) {
    // Call your existing STK push service here
        String stkPushUrl = "http://localhost:8080/mpesa/Stk";
        MpesaRequest mpesaRequest = new MpesaRequest(phone, "100", "WiFi Payment", "Payment for WiFi access");
        RestTemplate restTemplate = new RestTemplate();
        boolean paymentInitiated = mpesaServices.initiateStkPush(phone);
        try {
            ResponseEntity<String> response = restTemplate.postForEntity(stkPushUrl, mpesaRequest, String.class);
            if (response.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.ok("Payment initiated. Please complete the payment on your phone.");
            } else {
                return ResponseEntity.status(500).body("Failed to initiate payment. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error communicating with STK Push service.");
        }
    }


}
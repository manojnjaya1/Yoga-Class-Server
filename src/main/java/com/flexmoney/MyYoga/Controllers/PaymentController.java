package com.flexmoney.MyYoga.Controllers;

// PaymentController.java

import com.flexmoney.MyYoga.Models.UserEnrollment;
import com.flexmoney.MyYoga.Service.PaymentService;
import com.flexmoney.MyYoga.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<PaymentResponse> processPayment(@PathVariable Long userId) {
        // Call the service to process the payment
        PaymentResponse paymentResult = paymentService.processPayment(userId);

        return ResponseEntity.ok(paymentResult);
    }

}


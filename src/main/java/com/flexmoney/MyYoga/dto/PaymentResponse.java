package com.flexmoney.MyYoga.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentResponse {

    private boolean isPaymentSuccessful;
    private long  amountPaid;
    private String successMessage;
    private String errorOccurred;

}

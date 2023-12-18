package com.flexmoney.MyYoga.Service;

// PaymentService.java

import com.flexmoney.MyYoga.Models.PaymentStatus;
import com.flexmoney.MyYoga.Models.UserEnrollment;
import com.flexmoney.MyYoga.Repository.UserEnrollmentRepository;
import com.flexmoney.MyYoga.dto.PaymentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PaymentService {

    private final UserEnrollmentRepository userRepository;


    @Autowired
    public PaymentService(UserEnrollmentRepository userRepository) {
        this.userRepository = userRepository;

    }

    public PaymentResponse processPayment(Long userId) {
        // Retrieve the user by ID
        PaymentResponse paymentResponse=new PaymentResponse();

        Optional<UserEnrollment> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            UserEnrollment user = optionalUser.get();

            // Check if the user has already paid for the current month
            if (!hasPaidForCurrentMonth(user)) {
                // Call the mock CompletePayment() function
                boolean paymentSuccess = completePayment(user);

                // Update user payment status and date
                if (paymentSuccess) {
                    user.setPaymentStatus(PaymentStatus.PAID);
                    user.setPaymentDate(new Date());
                    userRepository.save(user);
                    paymentResponse.setPaymentSuccessful(true);
                    paymentResponse.setAmountPaid(500);
                    paymentResponse.setSuccessMessage("Payment successful!");
                    return paymentResponse;
                } else {
                    paymentResponse.setPaymentSuccessful(false);
                    paymentResponse.setAmountPaid(0);
                    paymentResponse.setErrorOccurred( "Payment failed!");
                    return paymentResponse;
                }
            } else {
                paymentResponse.setPaymentSuccessful(false);
                paymentResponse.setAmountPaid(0);
                paymentResponse.setErrorOccurred( "User has already paid for the current month.");
                return paymentResponse;

            }
        } else {
            paymentResponse.setPaymentSuccessful(false);
            paymentResponse.setAmountPaid(0);
            paymentResponse.setErrorOccurred( "User not found.");
            return paymentResponse;
        }
    }

    private boolean hasPaidForCurrentMonth(UserEnrollment user) {

        return user.getPaymentStatus() == PaymentStatus.PAID;
        // Implement logic to check if the user has already paid for the current month
        // You can compare the current date with the enrollment date and payment date
        // to determine if payment for the current month has been made.
        // Return true if already paid, false otherwise.
// Placeholder logic
    }

    // Assume this is the mock function
    private boolean completePayment(UserEnrollment user) {

        return true;
    }
}


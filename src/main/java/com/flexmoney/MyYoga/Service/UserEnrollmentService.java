package com.flexmoney.MyYoga.Service;

import com.flexmoney.MyYoga.Models.UserEnrollment;
import com.flexmoney.MyYoga.Repository.UserEnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// UserEnrollmentService.java
@Service
public class UserEnrollmentService {

    @Autowired
    private UserEnrollmentRepository userEnrollmentRepository;

    public UserEnrollment enrollUser(UserEnrollment userEnrollment) {
        // Perform basic validations
        validateUser(userEnrollment);
        userEnrollment.setEnrollmentDate(new Date());
        userEnrollment.setMonthlyFee(500);
        // Store user data in the database
        return userEnrollmentRepository.save(userEnrollment);
    }

    private void validateUser(UserEnrollment userEnrollment) {
        // Implement basic validations (e.g., age limit)
        if (userEnrollment.getAge() < 18 || userEnrollment.getAge() > 65) {
            throw new IllegalArgumentException("Age must be between 18 and 65.");
        }
        // Add other validations as needed
        List<String> allowedBatches = Arrays.asList("6-7AM", "7-8AM", "8-9AM", "5-6PM");
        if (!allowedBatches.contains(userEnrollment.getSelectedBatch())) {
            throw new IllegalArgumentException("Invalid batch selected.");
        }
    }

//    Method to get a user using Id
    public UserEnrollment getUserById(Long userId) {
        return userEnrollmentRepository.findById(userId).orElse(null);
    }
}


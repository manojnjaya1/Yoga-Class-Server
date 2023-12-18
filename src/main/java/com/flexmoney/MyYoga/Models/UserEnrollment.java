package com.flexmoney.MyYoga.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Calendar;
import java.util.Date;

// UserEnrollment.java
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEnrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 65, message = "Age must be at most 65")
    private int age;

    @NotBlank
    @Column(name = "selected_batch")
    private String selectedBatch;

    Date enrollmentDate ;
    Date enrollmentValidUpto;

    int monthlyFee;
    PaymentStatus paymentStatus;
   Date paymentDate;
    @PrePersist
    private void setEnrollmentValidUpto() {
        if (enrollmentDate != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(enrollmentDate);
            calendar.add(Calendar.DAY_OF_MONTH, 30);
            enrollmentValidUpto = calendar.getTime();
        }
    }

    // Getters and setters
}


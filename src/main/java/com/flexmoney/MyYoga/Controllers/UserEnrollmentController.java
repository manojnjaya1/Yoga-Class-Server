package com.flexmoney.MyYoga.Controllers;

import com.flexmoney.MyYoga.Models.UserEnrollment;
import com.flexmoney.MyYoga.Service.UserEnrollmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// UserEnrollmentController.java
@RestController
@RequestMapping("/enroll")
//@CrossOrigin(origins = "*")
public class UserEnrollmentController {

    @Autowired
    private UserEnrollmentService userEnrollmentService;

    @PostMapping
    public ResponseEntity<UserEnrollment> enrollUser(@RequestBody UserEnrollment userEnrollment) {
        UserEnrollment enrolledUser = userEnrollmentService.enrollUser(userEnrollment);
        return new ResponseEntity<>(enrolledUser, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserEnrollment> getUserById(@PathVariable Long userId) {
        UserEnrollment user = userEnrollmentService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

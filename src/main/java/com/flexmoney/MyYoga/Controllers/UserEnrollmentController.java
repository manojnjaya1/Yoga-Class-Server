package com.flexmoney.MyYoga.Controllers;

import com.flexmoney.MyYoga.Models.UserEnrollment;
import com.flexmoney.MyYoga.Service.UserEnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/enroll")
@CrossOrigin(origins = "https://yogaclass-client.vercel.app/")
public class UserEnrollmentController {


    private final UserEnrollmentService userEnrollmentService;

    public UserEnrollmentController(UserEnrollmentService userEnrollmentService) {
        this.userEnrollmentService = userEnrollmentService;
    }

//   Method to handle userenrollment
    @PostMapping
    public ResponseEntity<UserEnrollment> enrollUser(@RequestBody UserEnrollment userEnrollment) {
        UserEnrollment enrolledUser = userEnrollmentService.enrollUser(userEnrollment);
        return new ResponseEntity<>(enrolledUser, HttpStatus.CREATED);
    }
//    Getting a user by his userId
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

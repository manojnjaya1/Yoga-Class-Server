   ## Flex Money Yoga Class Registration App

## Implementation details:

**Api Endpoints:**

1) To register a user montly :
   /enroll (post)
   
   Takes the data entered by the user and registers the user
   Returns the user details along with the auto generated  unique userId .

2) To make a payment :
   /payments/:userId 

   Takes the userid and makes the payment for that particular month .
   if the user have already made the payment then throws an error.

3) To get a user by UserId:
   /enroll/:userId

   Takes userId and returns the userdetails of that particular user.

## Entity

![ER Diagram]([https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png](https://github.com/manojnjaya1/Yoga-Class-Server/blob/master/ER%20diagram.png))



Used Mysql database 

A table wit name user_enrollment stores all the user details 

 private Long id;
 
 String name;
 
 int age;
 
 String selectedBatch;
 
 Date enrollmentDate ;
 
 Date enrollmentValidUpto;
 
 int monthlyFee;
 
 PaymentStatus paymentStatus;
 
 Date paymentDate;

## Dockerised the server using the javajdk17 image

## Deployed on RENDER

  [Link to server] (https://flex-money-yogaclass.onrender.com)








 

package com.example.test.controllers;

import com.example.test.models.User;
import com.example.test.repositories.UserRepository;
import com.example.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    ResponseEntity<Object> getUsers(){
        try{

            List<User> users = userRepository.findAll();

            return new ResponseEntity<>(
                    users,
                    HttpStatus.OK
            );

        } catch (Exception e) {
            return new ResponseEntity<>(
                    "{\"msg\": \"Fail to get users\"}",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserById (@PathVariable long userId){
        try {

            Optional<User> users = userRepository.findById(userId);
            System.out.println(users);

            return new ResponseEntity<>(
                    users,
                    HttpStatus.OK
            );

        } catch (Exception e) {

            // Log the error for debugging purposes
            System.err.println("Error while create review: " + e.getMessage());

            // Return a failure response with JSON and HTTP status message 500
            return new ResponseEntity<>(
                    "{\"msg\": \"Fail to get review\"}",
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }


    @PostMapping("/")
    public ResponseEntity<Object> HttpcreateUser(@RequestBody User user){
        try{

        } catch (Exception e) {

            // Return a failure response with JSON and HTTP status message 500
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"msg\": \"Fail to create user\"}");
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> HttpcreateUser(@RequestBody User user, @PathVariable Long userId){
        try{

        } catch (Exception e) {

            // Return a failure response with JSON and HTTP status message 500
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .contentType(MediaType.APPLICATION_JSON)
                    .body("{\"msg\": \"Fail to update user\"}");
        }
    }



    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long userId){
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

}

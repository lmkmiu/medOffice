package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

 @Entity
 @Table(name="user")
public class User {
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Id
     @Column(name="user_id")
    private int userId;

     @NotBlank(message = "Field may not be empty")
     @Column(nullable = false, name="first_name")
     @Size(max = 20, message = "First Name must be less than 20 characters.")
    private String firstName;

     @NotBlank(message = "Field may not be empty")
     @Column(nullable = false, name="last_name")
     @Size(max = 20, message = "Last Name must be less than 20 characters.")
    private String lastName;

     @Column
     @Size(max = 20, message = "Phone must be less than 20 digit.")
    private String phone;

     @Column
     @Email
    private String email;

     @NotBlank(message = "Field may not be empty")
     @Column(nullable = false)
     private String passwords;

//     @Column(name = "notifications", nullable = false)
//    private boolean  notification;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public boolean isNotification(int i) {
//        return notification;
//    }
//
//    public void setNotification(boolean notification) {
//        this.notification = notification;
//    }

     public String getPasswords() {
         return passwords;
     }

     public void setPasswords(String passwords) {
         this.passwords = passwords;
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (!(o instanceof User)) return false;
         User user = (User) o;
         return userId == user.userId && firstName.equals(user.firstName) && lastName.equals(user.lastName) && phone.equals(user.phone) && email.equals(user.email) && passwords.equals(user.passwords);
     }

     @Override
     public int hashCode() {
         return Objects.hash(userId, firstName, lastName, phone, email, passwords);
     }
 }

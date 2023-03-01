package com.example.demo.entities;

// import javax.persistence.*;
// import javax.validation.constraints.*;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name="physician")
public class Physician {
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Id
     @Column(name="physician_id")
    private int physicianId;

     @NotBlank(message = "Field may not be empty")
     @Column(nullable = false, name="first_name")
     @Size(max = 20, message = "First Name must be less than 20 characters.")
     private String firstName;

     @NotBlank(message = "Field may not be empty")
     @Column(nullable = false, name="last_name")
     @Size(max = 20, message = "Last Name must be less than 20 characters.")
    private String lastName;

     @NotBlank(message = "Field may not be empty")
     @Column(nullable = false)
     @Size(max = 20, message = "Phone must be less than 20 digit.")
    private String phone;

     @NotBlank(message = "Field may not be empty")
     @Column(nullable = false)
     @Email
     private String email;

    @NotBlank(message = "Field may not be empty")
    @Column(nullable = false)
    private String passwords;

    public int getPhysicianId() {
        return physicianId;
    }

    public void setPhysicianId(int physicianId) {
        this.physicianId = physicianId;
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

    public String getPasswords() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Physician)) return false;
        Physician physician = (Physician) o;
        return physicianId == physician.physicianId && firstName.equals(physician.firstName) && lastName.equals(physician.lastName) && phone.equals(physician.phone) && email.equals(physician.email) && passwords.equals(physician.passwords);
    }

    @Override
    public int hashCode() {
        return Objects.hash(physicianId, firstName, lastName, phone, email, passwords);
    }
}
    




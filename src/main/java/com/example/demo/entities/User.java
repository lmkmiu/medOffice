package src.main.java.com.example.demo.entities;

import java.time.LocalDate;
import java.util.Objects;
// import javax.persistence.*;
// import javax.validation.constraints.*;

// @Entity
public class User {
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Id
    private int userId;

    // @NotBlank(message = "Field may not be empty")
    // @Column(nullable = false)
    // @Size(max = 20, message = "First Name must be less than 20 characters.")
    private String firstName;

    // @NotBlank(message = "Field may not be empty")
    // @Column(nullable = false)
    // @Size(max = 20, message = "Last Name must be less than 20 characters.")
    private String lastName;

    // @NotBlank(message = "Field may not be empty")
    // @Column(nullable = false)
    // @Size(max = 20, message = "Phone must be less than 20 digit.")
    private int phone;

    // @NotBlank(message = "Field may not be empty")
    // @Column(nullable = false)
    // @Email
    private int email;

    // @Column(name = "notifications", nullable = false)
    private boolean  notification;

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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getEmail() {
        return email;
    }

    public void setEmail(int email) {
        this.email = email;
    }

    public boolean isNotification() {
        return notification;
    }

    public void setNotification(boolean notification) {
        this.notification = notification;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + userId;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + phone;
        result = prime * result + email;
        result = prime * result + (notification ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (userId != other.userId)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (phone != other.phone)
            return false;
        if (email != other.email)
            return false;
        if (notification != other.notification)
            return false;
        return true;
    }

    
}

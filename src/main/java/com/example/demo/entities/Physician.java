package src.main.java.com.example.demo.entities;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Physician {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int physicianId;

    @NotBlank(message = "Field may not be empty")
    @Column(nullable = false)
    @Size(max = 20, message = "First Name must be less than 20 characters.")
    private String firstName;

    @NotBlank(message = "Field may not be empty")
    @Column(nullable = false)
    @Size(max = 20, message = "Last Name must be less than 20 characters.")
    private String lastName;

    @NotBlank(message = "Field may not be empty")
    @Column(nullable = false)
    @Size(max = 20, message = "Phone must be less than 20 digit.")
    private int phone;

    @NotBlank(message = "Field may not be empty")
    @Column(nullable = false)
    @Email
    private int email;

}
    




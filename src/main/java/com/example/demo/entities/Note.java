package src.main.java.com.example.demo.entities;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Note {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int noteId;

    @Column(nullable = false)
    private String note;

    @ManyToOne
    @JoinColumn(name = "physicianId", nullable = false)
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}

package src.main.java.com.example.demo.entities;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.*;
import javax.validation.constraints.*;

public class appointment {
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Id
    private int appId;

    @ManyToOne
    @JoinColumn(name = "physicianId", nullable = false)
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDate startTime;

    @Column(nullable = false)
    private LocalDate endTime;
}
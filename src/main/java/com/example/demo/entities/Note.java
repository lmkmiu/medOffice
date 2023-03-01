package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Objects;
// import javax.persistence.*;
// import javax.validation.constraints.*;

@Entity
@Table(name="note")
public class Note {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int noteId;

    @Column(nullable = false)
    private String note;

    @ManyToOne
    @JoinColumn(name = "physician_id", nullable = false)
    private Physician physician;

    @ManyToOne
    @JoinColumn(name = "app_id", nullable = false)
    private Appointment appointment;

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Physician getPhysician() {
        return physician;
    }

    public void setPhysician(Physician physician) {
        this.physician = physician;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note1 = (Note) o;
        return noteId == note1.noteId && note.equals(note1.note) && physician.equals(note1.physician) && appointment.equals(note1.appointment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noteId, note, physician, appointment);
    }
}

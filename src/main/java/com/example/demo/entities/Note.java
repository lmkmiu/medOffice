package src.main.java.com.example.demo.entities;

// import javax.persistence.*;
// import javax.validation.constraints.*;

// @Entity
public class Note {
    // @GeneratedValue(strategy= GenerationType.IDENTITY)
    // @Id
    private int noteId;

    // @Column(nullable = false)
    private String note;

    // @ManyToOne
    // @JoinColumn(name = "physicianId", nullable = false)
    private Physician physician;

    // @ManyToOne
    // @JoinColumn(name = "userId", nullable = false)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + noteId;
        result = prime * result + ((note == null) ? 0 : note.hashCode());
        result = prime * result + ((physician == null) ? 0 : physician.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
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
        Note other = (Note) obj;
        if (noteId != other.noteId)
            return false;
        if (note == null) {
            if (other.note != null)
                return false;
        } else if (!note.equals(other.note))
            return false;
        if (physician == null) {
            if (other.physician != null)
                return false;
        } else if (!physician.equals(other.physician))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    
}

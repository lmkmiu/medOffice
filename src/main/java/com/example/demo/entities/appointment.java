package src.main.java.com.example.demo.entities;

import java.time.LocalDate;
// import javax.persistence.*;
// import javax.validation.constraints.*;

// @Entity
public class appointment {
    // @GeneratedValue(strategy= GenerationType.IDENTITY)
    // @Id
    private int appId;

    // @ManyToOne
    // @JoinColumn(name = "physicianId", nullable = false)
    private Physician physician;

    // @ManyToOne
    // @JoinColumn(name = "userId", nullable = false)
    private User user;

    // @Column(nullable = false)
    private LocalDate startTime;

    // @Column(nullable = false)
    private LocalDate endTime;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
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

    public LocalDate getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + appId;
        result = prime * result + ((physician == null) ? 0 : physician.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
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
        appointment other = (appointment) obj;
        if (appId != other.appId)
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
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        return true;
    }

    
}
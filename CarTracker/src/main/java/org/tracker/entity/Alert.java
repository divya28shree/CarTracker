package org.tracker.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

@Entity
public class Alert {

    @Id
    private String id;
    private String vin;
    private String priority;
    private String reason;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Alert(){
        this.id= UUID.randomUUID().toString();
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "id='" + id + '\'' +
                ", vin='" + vin + '\'' +
                ", priority='" + priority + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }
}

package de.jonashackt.springbootvuejs.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date due;
    private String status;
    @ManyToOne
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(Date due) {
        this.due = due;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", name='" + name + '\'' + ", due=" + due + ", status='" + status + '\'' + ", userId=" + userId + '}';
    }
}

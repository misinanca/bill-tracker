package de.jonashackt.springbootvuejs.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "bill")
public class Bill {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Date due;
    private boolean status;
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", name='" + name + '\'' + ", due=" + due + ", status='" + status + '\'' + ", userId=" + user + '}';
    }
}

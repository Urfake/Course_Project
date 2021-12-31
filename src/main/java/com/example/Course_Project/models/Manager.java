package com.example.Course_Project.models;


import javax.persistence.*;

@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id")
    private User user;

    private String name,time_of_work, weekend;

    private int salary;

    public Manager() {
    }
    public Manager(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Manager(String name, String time_of_work, String weekend, int salary) {
        this.name = name;
        this.time_of_work = time_of_work;
        this.weekend = weekend;
        this.salary = salary;
    }

    public Manager(String name, String time_of_work, String weekend, int salary, User user) {
        this.user = user;
        this.name = name;
        this.time_of_work = time_of_work;
        this.weekend = weekend;
        this.salary = salary;
    }

    public Manager(User user, String name, int salary) {
        this.user = user;
        this.name = name;
        this.salary = salary;
    }

    public Manager(User user, String name, String time_of_work, String weekend) {
        this.user = user;
        this.name = name;
        this.time_of_work = time_of_work;
        this.weekend = weekend;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime_of_work() {
        return time_of_work;
    }

    public void setTime_of_work(String time_of_work) {
        this.time_of_work = time_of_work;
    }

    public String getWeekend() {
        return weekend;
    }

    public void setWeekend(String weekend) {
        this.weekend = weekend;
    }
}

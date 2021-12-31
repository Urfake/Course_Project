package com.example.Course_Project.models;


import javax.persistence.*;

@Entity
@Table(name="worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name,time_of_work, weekend;

    @OneToOne
    @JoinColumn(name = "user_id",
            referencedColumnName = "id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private int salary,prize;

    public Worker(){
    }
    public Worker(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public Worker(String name, String time_of_work, String weekend, int salary, User user) {
        this.name = name;
        this.time_of_work = time_of_work;
        this.weekend = weekend;
        this.user = user;
        this.salary = salary;
    }

    public Worker(String name, String time_of_work, String weekend, int salary) {
        this.name = name;
        this.time_of_work = time_of_work;
        this.weekend = weekend;
        this.salary = salary;
    }

    public Worker(String name, String time_of_work, String weekend, int salary, int prize) {
        this.name = name;
        this.time_of_work = time_of_work;
        this.weekend = weekend;
        this.salary = salary;
        this.prize = prize;
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

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

}

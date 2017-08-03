package com.ssm.beans;

import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * Created by qiaoz on 2017/7/19.
 */
@Component
public class Employee implements Serializable{
    private Integer id;
    private String lastName;
    private String email;
    private String gender;
    private Department department;

    public Employee() {
    }

    public Employee(String lastName, String email, String gender, Department department) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", department=" + department +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

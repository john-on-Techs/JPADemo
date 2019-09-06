package com.jotech.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    private long salary;
    //employee_vacationbookings
    @ElementCollection(targetClass = VacationEntry.class)
    @CollectionTable(
            name = "vacation",
            joinColumns = @JoinColumn(name = "emp_id"))
    @AttributeOverride(name = "daysTaken",column = @Column(name = "days_abs"))
    private Collection vacationBookings;

    //employee_nicknames
    @ElementCollection
    @Column(name = "nickname")
    private Set<String> nickNames;

    //The types of phone numbers have to be unique only within a given Map or
    //Employee instance, so the PHONE_TYPE column won’t be the primary key, either.
    @ElementCollection
    @CollectionTable(name = "emp_phone")
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "phone_type")
    @Column(name ="phone_num")
    private Map<PhoneType,String> phoneNumbers;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Collection getVacationBookings() {
        return vacationBookings;
    }

    public void setVacationBookings(Collection vacationBookings) {
        this.vacationBookings = vacationBookings;
    }

    public Set<String> getNickNames() {
        return nickNames;
    }

    public void setNickNames(Set<String> nickNames) {
        this.nickNames = nickNames;
    }

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

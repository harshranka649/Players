package HospitalmanagementSystemImplementation;

import java.sql.*;

public class Doctor {
    private String name;
    private String specialization;
    private String phone;
    private String address;

    public Doctor(String name, String specialization, String phone, String address) {
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Dr. " + name + " - " + specialization;
    }
}


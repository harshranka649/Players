package HospitalmanagementSystemImplementation;

import java.sql.*;

public class Patient {
    private String name;
    private String phone;
    private String address;
    private String patientId;

    public Patient(String name, String phone, String address, String patientId) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getPatientId() {
        return patientId;
    }

    @Override
    public String toString() {
        return name + " (ID: " + patientId + ")";
    }
}

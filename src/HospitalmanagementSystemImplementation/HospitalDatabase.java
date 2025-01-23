package HospitalmanagementSystemImplementation;

import java.sql.*;

public class HospitalDatabase {
    private static final String URL = "jdbc:mysql://localhost:3306/hospital_management";
    private static final String USER = "root"; // Change to your MySQL username
    private static final String PASSWORD = "Aspire@123"; // Change to your MySQL password
    private Connection connection;

    public HospitalDatabase() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");
        } catch (SQLException e) {
            System.err.println("Unable to connect to database: " + e.getMessage());
        }
    }

    // Method to add a doctor to the database
    public void addDoctor(Doctor doctor) {
        String query = "INSERT INTO doctors (name, specialization, phone, address) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getSpecialization());
            stmt.setString(3, doctor.getPhone());
            stmt.setString(4, doctor.getAddress());
            stmt.executeUpdate();
            System.out.println("Doctor added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding doctor: " + e.getMessage());
        }
    }

    // Method to add a patient to the database
    public void addPatient(Patient patient) {
        String query = "INSERT INTO patients (name, phone, address, patient_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, patient.getName());
            stmt.setString(2, patient.getPhone());
            stmt.setString(3, patient.getAddress());
            stmt.setString(4, patient.getPatientId());
            stmt.executeUpdate();
            System.out.println("Patient added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding patient: " + e.getMessage());
        }
    }

    // Method to add an appointment to the database
    public void addAppointment(Appointment appointment) {
        String query = "INSERT INTO appointments (doctor_id, patient_id, appointment_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, getDoctorId(appointment.getDoctor()));
            stmt.setInt(2, getPatientId(appointment.getPatient()));
            stmt.setDate(3, new java.sql.Date(appointment.getAppointmentDate().getTime()));
            stmt.executeUpdate();
            System.out.println("Appointment Scheduled Successfully");
        } catch (SQLException e) {
            System.err.println("Error adding appointment: " + e.getMessage());
        }
    }

    private int getDoctorId(Doctor doctor) {
        String query = "SELECT id FROM doctors WHERE name = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, doctor.getName());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                System.err.println("Doctor not found.");
                return -1;
            }
        } catch (SQLException e) {
            System.err.println("Error fetching doctor ID: " + e.getMessage());
            return -1;
        }
    }

    private int getPatientId(Patient patient) {
        String query = "SELECT id FROM patients WHERE patient_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, patient.getPatientId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            } else {
                System.err.println("Patient not found.");
                return -1;
            }
        } catch (SQLException e) {
            System.err.println("Error fetching patient ID: " + e.getMessage());
            return -1;
        }
    }

    public void close() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("Error closing the database connection: " + e.getMessage());
        }
    }
}

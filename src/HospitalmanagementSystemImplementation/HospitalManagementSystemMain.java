package HospitalmanagementSystemImplementation;

import java.sql.*;
import java.util.Scanner;
import java.util.Date;

public class HospitalManagementSystemMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Doctor doctor;
        HospitalDatabase db = null;

        try {
            db = new HospitalDatabase();
            boolean exit = false;

            while (!exit) {
                System.out.println("\n--- Hospital Management System ---");
                System.out.println("1. Add Doctor");
                System.out.println("2. Add Patient");
                System.out.println("3. Schedule Appointment");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1: {
                        System.out.print("Enter doctor's name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter specialization: ");
                        String specialization = scanner.nextLine();
                        System.out.print("Enter phone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();
                        doctor = new Doctor(name, specialization, phone, address);
                        db.addDoctor(doctor);
                        break;
                    }
                    case 2: {
                        System.out.print("Enter patient's name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter phone: ");
                        String phone = scanner.nextLine();
                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter patient ID: ");
                        String patientId = scanner.nextLine();
                        Patient patient = new Patient(name, phone, address, patientId);
                        db.addPatient(patient);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter appointment date (YYYY-MM-DD): ");
                        String date = scanner.nextLine();
                        Date appointmentDate = java.sql.Date.valueOf(date);

                        // For simplicity, assuming doctor and patient are already added
                        System.out.print("Enter doctor's name: ");
                        String doctorName = scanner.nextLine();
                        doctor = new Doctor(doctorName, "", "", "");

                        System.out.print("Enter patient's ID: ");
                        String patientId = scanner.nextLine();
                        Patient patient = new Patient("", "", "", patientId);

                        Appointment appointment = new Appointment(patient, doctor, appointmentDate);
                        db.addAppointment(appointment);
                        break;
                    }
                    case 4:
                        exit = true;
                        System.out.println("Exiting system...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }

        } finally {
            if (db != null) {
                db.close();
            }
            scanner.close();
        }
    }
}

/* 
 * David Charette
 * CS-320
 *2/6/25
 * 
 * This class will be used to makes appointments 
 */




package Service;

import java.util.ArrayList;
import java.util.Date;

import Model.Appointment;


public class AppointmentService {

    // Create list to hold appointments
    public ArrayList<Appointment> appointmentList = new ArrayList<>();

    // Display the full list of appointments for error checking
    public void displayAppointmentList() {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            System.out.println("\t Appointment ID: " + appointmentList.get(counter).getAppointmentID());
            System.out.println("\t Appointment Date: " + appointmentList.get(counter).getAppointmentDate());
            System.out.println("\t Appointment Description: " + appointmentList.get(counter).getAppointmentDesc());
        }
    }

    // adds new appointment with constructor
    public void addAppointment(Date appointmentDate, String appointmentDesc) {
        Appointment appointment = new Appointment(appointmentDate, appointmentDesc);
        appointmentList.add(appointment);
    }

    // Using appointmentID and returns Appointment 
    // If a matching appointment ID is not found, return null
    public Appointment getAppointment(String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                return appointmentList.get(counter);
            }
        }
        return null; 
    }

    // Delete appointment by using the ID
    public void deleteAppointment(String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.remove(counter);
                break; // Stop searching once the appointment is deleted
            }
        }
    }

    // Update appointment date using ID
    public void updateAppointmentDate(Date updatedDate, String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.get(counter).setAppointmentDate(updatedDate);
                break; // Stop searching once the appointment is updated
            }
        }
    }

    // Update appointment description using ID
    public void updateAppointmentDesc(String updatedString, String appointmentID) {
        for (int counter = 0; counter < appointmentList.size(); counter++) {
            if (appointmentList.get(counter).getAppointmentID().equals(appointmentID)) {
                appointmentList.get(counter).setAppointmentDesc(updatedString);
                break; // Stop searching once the appointment is updated
            }
        }
    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


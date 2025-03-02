/*
 * David Charette
 * CS-320
 * 2/12/2024
 */
package Tests;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import Model.Appointment;
import Service.AppointmentService;

class AppointmentServiceTest {

	private AppointmentService service;

    // Runs before each test to ensure a fresh service instance
    @BeforeEach
    void setUp() {
        service = new AppointmentService();
    }

    // Helper method to create a date object
    private Date createFutureDate(int yearsAhead) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, yearsAhead); // Move years into the future
        return calendar.getTime();
    }

    @Test
    @DisplayName("Test updating an appointment's date")
    @Order(1)
    void testUpdateAppointmentDate() {
        service.addAppointment(new Date(), "Initial Description");
        String appointmentID = service.appointmentList.get(0).getAppointmentID();
        Date newDate = createFutureDate(5); // Move 5 years ahead
        service.updateAppointmentDate(newDate, appointmentID);
        assertEquals(newDate, service.getAppointment(appointmentID).getAppointmentDate(),"Appointment date was not updated correctly.");
    
    }
    
    @Test
    @DisplayName("Test updating an appointment's description")
    @Order(2)
    void testUpdateAppointmentDesc() {
        service.addAppointment(new Date(), "Initial Description");
        String appointmentID = service.appointmentList.get(0).getAppointmentID();
        String updatedDesc = "Updated Description";
        service.updateAppointmentDesc(updatedDesc, appointmentID);
        assertEquals(updatedDesc, service.getAppointment(appointmentID).getAppointmentDesc(),
                     "Appointment description was not updated correctly.");
        
    }
    @Test
    @DisplayName("Test deleting an appointment")
    @Order(3)
    void testDeleteAppointment() {
        service.addAppointment(new Date(), "Test Description");
        String appointmentID = service.appointmentList.get(0).getAppointmentID();
        service.deleteAppointment(appointmentID);
        assertNull(service.getAppointment(appointmentID), "Appointment was not deleted correctly.");
   
    }
    
    @Test
    @DisplayName("Test adding an appointment")
    @Order(4)
    void testAddAppointment() {
        Date validFutureDate = createFutureDate(1); 
        service.addAppointment(validFutureDate, "Test Description");
        List<Appointment> appointments = service.appointmentList;
        assertFalse(appointments.isEmpty(), "Appointment was not added correctly.");
        assertEquals(validFutureDate, appointments.get(0).getAppointmentDate(), "Appointment date is incorrect.");
    }
    

}
/*
 * David Charette
 * CS-320
 * 2/12/2025
 */


package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.Calendar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Model.Appointment;

class AppointmentTest {

    // Helper method to create a date
    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, 0, 0, 0);
        return calendar.getTime();
    }

    @Test
    @DisplayName("Appointment ID should not exceed 10 characters")
    void testAppointmentIDLength() {
        Appointment appointment = new Appointment(new Date(), "Valid Description");
        assertTrue(appointment.getAppointmentID().length() <= 10, "Appointment ID is longer than 10 characters.");
    }

    @Test
    @DisplayName("Appointment Description should not exceed 50 characters")
    void testAppointmentDescLength() {
        String longDesc = "This description is definitely longer than fifty characters long.";
        Appointment appointment = new Appointment(new Date(), longDesc);
        assertEquals(50, appointment.getAppointmentDesc().length(), "Appointment Description exceeded 50 characters.");
    }

    @Test
    @DisplayName("Appointment Date should not be before the current date")
    void testAppointmentDateNotBeforeCurrent() {
        Date pastDate = createDate(1900, Calendar.JANUARY, 1); // A past date
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(pastDate, "Valid Description");
        });
        assertEquals("Cannot make an appointment before the current date.", exception.getMessage());
    }

    @Test
    @DisplayName("Appointment Date should not be null")
    void testAppointmentDateNotNull() {
        Appointment appointment = new Appointment(null, "Valid Description");
        assertNotNull(appointment.getAppointmentDate(), "Appointment Date should not be null.");
    }

    @Test
    @DisplayName("Appointment Description should not be null")
    void testAppointmentDescNotNull() {
        Appointment appointment = new Appointment(new Date(), null);
        assertNotNull(appointment.getAppointmentDesc(), "Appointment Description should not be null.");
        assertEquals("NULL", appointment.getAppointmentDesc(), "Default description should be 'NULL'.");
    }
}
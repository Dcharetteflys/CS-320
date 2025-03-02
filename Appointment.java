/*
 * David Charette 
 * CS-320 
 *2/13/25
 *
 */





package Model;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Date;
public class Appointment {

	    private final String appointmentID;
	    private Date appointmentDate;
	    private String appointmentDesc;
	    private static AtomicLong idGenerator = new AtomicLong();

	    // CONSTRUCTORS
	    public Appointment(Date appointmentDate, String appointmentDesc) {
	        // will generate a new id that is unique
	        this.appointmentID = String.valueOf(idGenerator.getAndIncrement());

	        // make sure appointment date is not in the past
	     // to make sure we use the current date as a starting point for new appointments
	        if (appointmentDate == null) {
	            this.appointmentDate = new Date();  
	        } else if (appointmentDate.before(new Date())) {
	            throw new IllegalArgumentException("Cannot make an appointment before the current date.");
	        } else {
	            this.appointmentDate = appointmentDate;
	        }

	        // make sure description is with in 50 characters
	        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
	            this.appointmentDesc = "NULL";
	        } else if (appointmentDesc.length() > 50) {
	            this.appointmentDesc = appointmentDesc.substring(0, 50);
	        } else {
	            this.appointmentDesc = appointmentDesc;
	        }
	    }

	    // GETTERS
	    public String getAppointmentID() {
	        return appointmentID;
	    }

	    public Date getAppointmentDate() {
	        return appointmentDate;
	    }

	    public String getAppointmentDesc() {
	        return appointmentDesc;
	    }

	    // SETTERS
	    public void setAppointmentDate(Date appointmentDate) {
	        if (appointmentDate == null) {
	            this.appointmentDate = new Date();  // Current Date
	        } else if (appointmentDate.before(new Date())) {
	            throw new IllegalArgumentException("Cannot make an appointment before the current date.");
	        } else {
	            this.appointmentDate = appointmentDate;
	        }
	    }

	    public void setAppointmentDesc(String appointmentDesc) {
	        if (appointmentDesc == null || appointmentDesc.isEmpty()) {
	            this.appointmentDesc = "NULL";
	        } else if (appointmentDesc.length() > 50) {
	            this.appointmentDesc = appointmentDesc.substring(0, 50);
	        } else {
	            this.appointmentDesc = appointmentDesc;
	        }
	    }
	}


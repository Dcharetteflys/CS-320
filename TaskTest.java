/* 
 * David Charette 
 * cs_320
 * 1/30/25
 * 
 * Test the task class for proper functions
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Model.Task;




public class TaskTest {

	// this is the tests that are going for the task class
	
	@Test
	@DisplayName("Task ID cannot have more than 10 characters")
	void testTaskIDForLong() {
		Task task = new Task("Name", "Description");
		if (task.getTaskID().length() > 10) {
			fail("Task ID has more than 10 characters.");
		}
	}
	
	@Test
	@DisplayName("Task name cannot have more than 20 characters")
	void testTaskNameForLong() {
		Task task = new Task("IWonderIfThisIsGoingToBeToLong","Description");
		if (task.getTaskName().length() > 20) {
			fail("Task Name has more than 20 characters.");
		}
	}
	
	@Test
	@DisplayName("Task Description cannot have more than 50 characters")
	void testTaskDescForLong() {
	    Task task = new Task("Name", "how many do in need again???"
	                            + "it seems to be an ok amount of characters"
	                            + "it seems to be an ok amount of characters"
	                            + "it seems to be an ok amount of characters");
	    if (task.getTaskDesc().length() > 50) {
			fail("Task Description has more than 50 characters.");
		}
	}
		
	
	@Test
	@DisplayName("Task Name shall not be null")
	void testTaskNameNotNull() {
		Task task = new Task(null, "Description");
		assertNotNull(task.getTaskName(), "Task Name was null.");
	}
	
	@Test
	@DisplayName("Task Description shall not be null")
	void testTaskDescNotNull() {
		Task task = new Task("Name", null);
		assertNotNull(task.getTaskDesc(), "Task Description was null.");
	}
	

	
	
	
}

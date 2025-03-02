/*
 * David Charette 
 * CS-320
 * 2/12/2025
 * 
 * Task class is to create and store task information 
 */


package Model;

import java.util.concurrent.atomic.AtomicLong;

public class Task {
	
	//Variables needed 
	private final String taskID; // is going to store unique id 
	private String taskName;
	private String taskDesc;
	
	//will generate a unique id 
	private static final AtomicLong idGenerator = new AtomicLong(1);
	
	
	public Task(String taskName, String taskDesc) {
		
		//generate unique id for task 
		long id = idGenerator.getAndIncrement();
		
		this.taskID = String.valueOf(id);
		
		// going to set task name 
		if (taskName == null || taskName.isEmpty()) {
			this.taskName = "NULL";
		}else if (taskName.length() > 20) {
			this.taskName = taskName.substring(0, 20); 
		} else {
			this.taskName = taskName;
		}
		
		// going to set task description
		if (taskDesc == null || taskDesc.isEmpty()) {
			this.taskDesc = "NULL";
		}else if (taskDesc.length() > 50) {
			this.taskDesc = taskDesc.substring(0, 50);
		}else {
			this.taskDesc = taskDesc;
		}
	}
	
	
	
	// getters 
	public String getTaskID() { //Not able to be changed after set
		return taskID;
	}
	
	public String getTaskName() {
		return taskName;
	}
	
	
	public String getTaskDesc() {
		return taskDesc;
	}
	
	
	// Setters
	
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
}









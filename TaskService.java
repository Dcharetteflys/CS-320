/*
 * David Charette
 * CS-320
 * 2/12/2025
 * 
 * This is going to be for updating, adding, or removing from task list
 */


package Service;
import java.util.ArrayList;

import Model.Task;

public class TaskService {
	
	// create list to fold information 
	public ArrayList<Task> taskList = new ArrayList<Task>();

	// Display the full list of contacts to the console for error checking.
	public void displayTaskList() {
        for (int counter = 0; counter < taskList.size(); counter++) {
            System.out.println("\t Task ID: " + taskList.get(counter).getTaskID());
            System.out.println("\t Task Name: " + taskList.get(counter).getTaskName());
            System.out.println("\t Task Description: " + taskList.get(counter).getTaskDesc());
		}
	}

	// Adds a new task using the Task constructor and assign to list 
	public void addTask(String taskName, String taskDesc) {
		Task task = new Task(taskName, taskDesc);
		taskList.add(task);
	}

	// Using Task ID, return a task object
	// If a matching Task ID is not found, return a task object with default values
	public Task getTask(String taskID) {
        for (int counter = 0; counter < taskList.size(); counter++) {
            if (taskList.get(counter).getTaskID().equals(taskID)) {
                return taskList.get(counter);
            }
        }
        return null; // Task not found, return null
    }

	// Delete task and find by using task id. 
	public void deleteTask(String taskID) {
        for (int counter = 0; counter < taskList.size(); counter++) {
            if (taskList.get(counter).getTaskID().equals(taskID)) {
                taskList.remove(counter);
                break; // Stop searching once the task is deleted
            }
        }
    }

	// Update the task name.
	public void updateTaskName(String updatedString, String taskID) {
        for (int counter = 0; counter < taskList.size(); counter++) {
            if (taskList.get(counter).getTaskID().equals(taskID)) {
                taskList.get(counter).setTaskName(updatedString);
                break; // Stop searching once the task is updated
            }
        }
    }

	// Update the task description.
	public void updateTaskDesc(String updatedString, String taskID) {
        for (int counter = 0; counter < taskList.size(); counter++) {
            if (taskList.get(counter).getTaskID().equals(taskID)) {
                taskList.get(counter).setTaskDesc(updatedString);
                break; // Stop searching once the task is updated
			}
		}
	}
}
/* 
 * David Charette 
 * cs_320
 * 2/12/2025
 * 
 * Test the task service class for proper functions
 */

package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Model.Task;
import Service.TaskService;



public class TaskServiceTest {

	private TaskService taskService;
	
	//makes sure to start new test each time 
	@BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTask() {
        taskService.addTask("Test Task", "Description of test task");
        assertEquals(1, taskService.taskList.size());
        Task task = taskService.taskList.get(0); 
        assertNotNull(task);
        assertEquals("Test Task", task.getTaskName());
        assertEquals("Description of test task", task.getTaskDesc());
    }


    @Test
    void testDeleteTask() {
        taskService.addTask("Test Task", "Description of test task");
        assertEquals(1, taskService.taskList.size());
        taskService.deleteTask("1");
        assertEquals(1, taskService.taskList.size());
    }

    @Test
    void testUpdateTaskName() {
        taskService.addTask("Old Name", "Description of test task");
        Task task = taskService.taskList.get(0);
        assertEquals("Old Name", task.getTaskName());
        taskService.updateTaskName("Updated Name", task.getTaskID());
        Task updatedTask = taskService.getTask(task.getTaskID());
        assertNotNull(updatedTask);
        assertEquals("Updated Name", updatedTask.getTaskName());
    }

    @Test
    void testUpdateTaskDesc() {
        taskService.addTask("Test Task", "Old Description");
        Task task = taskService.taskList.get(0);
        assertEquals("Old Description", task.getTaskDesc());
        taskService.updateTaskDesc("New Description", task.getTaskID());
        Task updatedTask = taskService.getTask(task.getTaskID());
        assertNotNull(updatedTask);
        assertEquals("New Description", updatedTask.getTaskDesc());
        
    }
}
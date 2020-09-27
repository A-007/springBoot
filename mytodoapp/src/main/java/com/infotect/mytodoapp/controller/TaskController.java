package com.infotect.mytodoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infotect.mytodoapp.model.Task;
import com.infotect.mytodoapp.repository.TaskRepository;

@RestController
public class TaskController {

	@Autowired
	private TaskRepository taskRepository;

	/**
	 * Add a new task to the tasks list for a user
	 * 
	 * @param task
	 */
	@PostMapping("/task")
	public void addTask(@RequestBody Task task) {
		taskRepository.save(task);
	}
	
	
	@PutMapping("/task")
	public void updateTask(@RequestBody Task task) {
		taskRepository.save(task);
	}
}

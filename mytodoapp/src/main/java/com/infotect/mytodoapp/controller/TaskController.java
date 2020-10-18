package com.infotect.mytodoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	@PostMapping("/addTask")
	public ResponseEntity<?> addTask(@RequestBody Task task) {
		Task savedTask = taskRepository.save(task);
		if (savedTask != null) {
			return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Task not saved due to technical glitch", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTask")
	public ResponseEntity<?> getTask() {

		List<Task> tasks = taskRepository.findAll();
		if (tasks != null && !tasks.isEmpty()) {
			return new ResponseEntity<>(tasks, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Task not found", HttpStatus.OK);
		}

	}

	@PutMapping("/task")
	public void updateTask(@RequestBody Task task) {
		taskRepository.save(task);
	}
}

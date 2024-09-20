package com.Spring.JPA;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("app/task")
public class TaskController {  

	@Autowired
	private TaskService ts;
	
	@GetMapping
	public List<Tasks> getAllTasks() {
		return ts.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tasks> getTaskByID(@PathVariable Long id) {
		 Tasks t =  ts.getTaskById(id);
		 return ResponseEntity.ok(t);//200 ok
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable Long id){
		ts.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping// create
	public Tasks createTasks(@RequestBody Tasks t) {
		return ts.createTask(t);
		
	}
	
	@PutMapping("/{id}") //update
	public ResponseEntity<Void> updateTask(@RequestBody Tasks t, @PathVariable Long id) {
		ts.update(t, id);
		return ResponseEntity.noContent().build();
	}
}

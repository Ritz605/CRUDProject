package com.Spring.JPA;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	
	@Autowired
	private TaskRepository tr;
	
	public List<Tasks> getAll() {
		return tr.findAll();
	}
	
	//getbyID
	public Tasks getTaskById(Long id) {
		return  tr.findById(id).orElseThrow(() -> new ExceptionClass("Resouce not found for id = " + id));//to handle 400 errors//if it is not giving
	}
	
	//put: update
	public void update(Tasks t, Long id) {
		 Tasks t1 = getTaskById(id);
		 
		 t1.setAsby(t.getAsby());
		 t1.setAsto(t.getAsto());
		 t1.setTc(t.getTc());
		 t1.setTd(t.getTd());
		 
		 tr.save(t1);
		 
	}
	
	//create: post: task is given and we have to save
	public Tasks createTask(Tasks t) {
		  tr.save(t);
		 return t;
	}
	
	//delete: first get the id which we have to delete after that give that object to .delete it will delete a particular task
	public void delete(Long id) {
		Tasks t = getTaskById(id);
		tr.delete(t);
	}
}

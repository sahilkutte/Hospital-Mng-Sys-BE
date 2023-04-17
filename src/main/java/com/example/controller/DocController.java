package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Doctor;
import com.example.modal.DocModal;
import com.example.service.DocService;

@RestController
@RequestMapping("/doctor")
public class DocController {

	@Autowired
	private DocService service;
	
	@PostMapping
	public DocModal addd(@RequestBody DocModal modal)
	{
		return service.savedoc(modal);
	}
	
	@GetMapping
	public List<DocModal> getAll()
	{
	  return service.getall();
	}

	@GetMapping("{id}")
	public Optional<Doctor> getById(@PathVariable Long id)
	{
		return service.getById(id);
	}
	
	@DeleteMapping("{id}")
	public boolean delete(@PathVariable Long id)
	{
		return service.deleteById(id);
	}
	@PutMapping("{id}")
	public Doctor update(@RequestBody DocModal modal,@PathVariable Long id)
	{
		return service.update(id, modal);
	}
}

package com.dsc.socialnetwork.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dsc.socialnetwork.dtos.DisciplineDTO;
import com.dsc.socialnetwork.exceptions.DisciplineNotExistsException;
import com.dsc.socialnetwork.models.Discipline;
import com.dsc.socialnetwork.services.DisciplineService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/v1/api/disciplinas")
public class DisciplineController {

    private final DisciplineService disciplineService;
    
    @Autowired
    public DisciplineController(DisciplineService disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Discipline> getDisciplineById(@PathVariable("id") int id) {
    	try {
    		return new ResponseEntity<Discipline>(disciplineService
    				.getDisciplineById(id), HttpStatus.OK);
    		
    	} catch (DisciplineNotExistsException e) {
			return new ResponseEntity<Discipline>(HttpStatus.NOT_FOUND);
		}
    	
    }
    
    @GetMapping
    public ResponseEntity<List<Discipline>> getDisciplines() {
    	return new ResponseEntity<List<Discipline>>(disciplineService
    			.getDisciplines(), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<Discipline> addDiscipline(@Valid @RequestBody DisciplineDTO disciplineDTO) {
        return new ResponseEntity<>(disciplineService
        		.addDiscipline(disciplineDTO), HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}/name") 
    public ResponseEntity<Discipline> updateDisciplineName(@PathVariable("id") int id, @Valid @RequestBody ObjectNode json) {
    	try {
    		String newName = json.get("name").asText(); 
			return new ResponseEntity<Discipline>(disciplineService
					.updateDisciplineNameById(id, newName), HttpStatus.OK);
			
		} catch (DisciplineNotExistsException e) {
			return new ResponseEntity<Discipline>(HttpStatus.BAD_REQUEST);
		}
    }

    @PutMapping("/{id}/note") 
    public ResponseEntity<Discipline> updateDisciplineNote(@PathVariable("id") int id, @Valid @RequestBody ObjectNode json) {
    	try {
    		double newNote = json.get("note").asDouble(); 
			return new ResponseEntity<Discipline>(disciplineService
					.updateDisciplineNameById(id, newNote), HttpStatus.OK);
			
		} catch (DisciplineNotExistsException e) {
			return new ResponseEntity<Discipline>(HttpStatus.BAD_REQUEST);
		}
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Discipline> deleteDisciplineById(@PathVariable("id") int id) {
    	try {
			return new ResponseEntity<Discipline>(disciplineService
					.deleteDisciplineById(id), HttpStatus.OK);
			
		} catch (DisciplineNotExistsException e) {
			return new ResponseEntity<Discipline>(HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/ranking")
    public ResponseEntity<List<Discipline>> getRanking() {
    	return new ResponseEntity<List<Discipline>>(disciplineService.getRanking(), HttpStatus.OK);
    }
    
}
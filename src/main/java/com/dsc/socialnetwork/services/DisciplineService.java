package com.dsc.socialnetwork.services;

import com.dsc.socialnetwork.dtos.DisciplineDTO;
import com.dsc.socialnetwork.exceptions.DisciplineNotExistsException;
import com.dsc.socialnetwork.models.Discipline;
import com.dsc.socialnetwork.repositories.DisciplineRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {

	private DisciplineRepository disciplineRepository;

	@Autowired
	public DisciplineService() {
		this.disciplineRepository = new DisciplineRepository();
	}

	
	public Discipline addDiscipline(DisciplineDTO disciplineDTO) {
		return disciplineRepository.addDiscipline(disciplineDTO); 
	}
	
	public List<Discipline> getDisciplines() {
		return disciplineRepository.getDisciplines();
	}
	
	public Discipline getDisciplineById(int id) throws DisciplineNotExistsException {
		Optional<Discipline> discipline = disciplineRepository.findDisciplineById(id);
		
		return discipline.orElseThrow(() 
				-> new DisciplineNotExistsException("A disciplina com o ID " + id + "não existe!"));
	}
	
	public Discipline updateDisciplineNameById(int id, String name) throws DisciplineNotExistsException {
		Optional<Discipline> discipline = disciplineRepository.findDisciplineById(id);
		
		if (!discipline.isPresent()) {
			throw new DisciplineNotExistsException("A disciplina com o ID " + id + "não existe!");
		}
		
		return disciplineRepository.updateDisciplineName(id, name);
	}
	
	public Discipline updateDisciplineNameById(int id, double note) throws DisciplineNotExistsException {
		Optional<Discipline> discipline = disciplineRepository.findDisciplineById(id);
		
		if (!discipline.isPresent()) {
			throw new DisciplineNotExistsException("A disciplina com o ID " + id + "não existe!");
		}
		
		return disciplineRepository.updateDisciplineNote(id, note);
	}
	
	public Discipline deleteDisciplineById(int id) throws DisciplineNotExistsException {
		Optional<Discipline> discipline = disciplineRepository.findDisciplineById(id);
		
		if (!discipline.isPresent()) {
			throw new DisciplineNotExistsException("A disciplina com o ID " + id + "não existe!");
		}
		
		return disciplineRepository.deleteDisciplineById(id);
	}
	
	public List<Discipline> getRanking() {
		List<Discipline> disciplines = new ArrayList<>(disciplineRepository.getDisciplines());
		Collections.sort(disciplines, Comparator.comparing(Discipline::getNote));
		Collections.reverse(disciplines);
		
		return disciplines; 
	}
}
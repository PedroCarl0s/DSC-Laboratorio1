package com.dsc.socialnetwork.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dsc.socialnetwork.dtos.DisciplineDTO;
import com.dsc.socialnetwork.models.Discipline;

public class DisciplineRepository {

	private static final int FIRST_VALID_ID = 1;
	
    private List<Discipline> disciplines;
    private static int disciplineId = 1;

    public DisciplineRepository() {
        this.disciplines = new ArrayList<>();
    }

    public Discipline addDiscipline(DisciplineDTO disciplineDTO) {
        Discipline discipline = new Discipline(disciplineId++, disciplineDTO.getName(), disciplineDTO.getNote());
        this.disciplines.add(discipline);
        
        return discipline;
    }

    public List<Discipline> getDisciplines() {
        return this.disciplines;
    }

    public Optional<Discipline> findDisciplineById(int id) {
        return this.disciplines.stream()
            .filter(d -> id == d.getId())
            .findFirst();
    }
    
    public Discipline updateDisciplineName (int id, String name) {
    	disciplines.get(id-FIRST_VALID_ID).setName(name);
    	return disciplines.get(id-FIRST_VALID_ID);
    }
    
    public Discipline updateDisciplineNote (int id, double note) {
    	disciplines.get(id-FIRST_VALID_ID).setNote(note);
    	return disciplines.get(id-FIRST_VALID_ID);
    }
    
    public Discipline deleteDisciplineById(int id) {
    	return disciplines.remove(id-FIRST_VALID_ID);
    }
}
package com.example.jsfdemo.web;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;




@ApplicationScoped
public class AnimalManager {
	private List<Animal> db = new ArrayList<Animal>();
	private static int size;
	public List<Animal> getAllAnimals() {
		
		return db;
	}
	public void addAnimal(Animal animal) {
		Animal p = get(animal.getId());
		if (p==null) {
			Animal newAnimal = new Animal();
			AnimalManager.size++;
			setAnimal(newAnimal,animal);
			newAnimal.setId(AnimalManager.size);
			db.add(newAnimal);
		} else {
			//setAnimal(p,Animal);
		}
		
		
	}
	private void setAnimal(Animal p, Animal animal) {
		p.setName(animal.getName());
		p.setSpecies(animal.getSpecies());
		p.setId(AnimalManager.size);
		
	}
	private Animal get(int id) {
		for (Animal p: db) {
			if(p.getId()==id) {
				return p;
			}
		}
		return null;
	}

}

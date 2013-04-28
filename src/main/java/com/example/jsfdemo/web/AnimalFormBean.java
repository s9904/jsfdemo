package com.example.jsfdemo.web;

import java.io.Serializable;


import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;


@SessionScoped
@Named("animalBean")
public class AnimalFormBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Animal animal = new Animal();
	private ListDataModel<Animal> animals 
	 = new ListDataModel<Animal>();
	
	@Inject 
	private AnimalManager am;

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}
	
	public ListDataModel<Animal> getAllAnimals() {
		animals.setWrappedData(am.getAllAnimals());
		return animals;
	}
	// Actions
		public String addAnimal() {
			am.addAnimal(animal);
			animal = new Animal();
			return "showAnimals";
			
		}
}

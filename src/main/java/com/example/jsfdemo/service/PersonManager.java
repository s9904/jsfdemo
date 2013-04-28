package com.example.jsfdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Person;

@ApplicationScoped
public class PersonManager {
	private List<Person> db = new ArrayList<Person>();
    private static int size;
	public void addPerson(Person person) {
		Person p = get(person.getId());
		if (p==null) {
			Person newPerson = new Person();
			PersonManager.size++;
			setPerson(newPerson,person);
			newPerson.setId(PersonManager.size);
			db.add(newPerson);
		} else {
			//setPerson(p,person);
		}
		
		
		
		
	}
	
	private void setPerson(Person p, Person person) {
		p.setFirstName(person.getFirstName());
		p.setZipCode(person.getZipCode());
		p.setPin(person.getPin());
		p.setDateOfBirth(person.getDateOfBirth());
		p.setMarried(person.isMarried());
		p.setWeight(person.getWeight());
		p.setNumOfChildren(person.getNumOfChildren());
		p.setId(PersonManager.size);
	}
	public Person get(int id) {
		for (Person p: db) {
			if(p.getId()==id) {
				return p;
			}
		}
		return null;
	}
	// Removes the person with given PIN
	public void deletePerson(Person person) {
		Person personToRemove = null;
		for (Person p : db) {
			if (person.getPin().equals(p.getPin())) {
				personToRemove = p;
				break;
			}
		}
		if (personToRemove != null)
			db.remove(personToRemove);
	}

	public List<Person> getAllPersons() {
		return db;
	}
}

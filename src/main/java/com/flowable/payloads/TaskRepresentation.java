package com.flowable.payloads;

import com.flowable.model.Participant;
import com.flowable.model.Person;

public class TaskRepresentation {

	private String id;
	private String name;

	public Participant getPerson() {
		return person;
	}

	public void setPerson(Participant person) {
		this.person = person;
	}

	private Participant person;


	public TaskRepresentation(String id, String name,Participant person) {
		this.id = id;
		this.name = name;
		this.person = person;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
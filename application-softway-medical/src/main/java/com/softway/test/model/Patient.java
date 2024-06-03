package com.softway.test.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//This class represents a Patient entity, which is mapped to a database table.
@Entity
//The table name is specified as "patient".
@Table(name = "patient")
public class Patient {

	// The primary key of the entity. It's auto-generated using GenerationType.AUTO.
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	// The patient's first name.
	@Column(name = "firstName")
	private String nom;
	// The patient's last name.
	@Column(name = "lastName")
	private String prenom;
	// The patient's health index.
	@Column(name = "healthIndex")
	private int healthIndex;

	// Default constructor.
	public Patient() {
	}

	// Constructor with all fields.
	public Patient(Long id, String nom, String prenom, int healthIndex) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.healthIndex = healthIndex;
	}

	// getters and setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getHealthIndex() {
		return healthIndex;
	}

	public void setHealthIndex(int healthIndex) {
		this.healthIndex = healthIndex;
	}

}

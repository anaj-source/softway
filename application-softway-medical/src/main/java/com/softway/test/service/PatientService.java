package com.softway.test.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softway.test.exceptionController.PatientException;
import com.softway.test.model.Patient;
import com.softway.test.repository.PatientRepository;

//This class provides business logic related to Patient entities.
@Service
public class PatientService {

	// The PatientRepository is injected, providing access to data persistence.
	private final PatientRepository patientRepository;

	// Constructor to initialize the PatientRepository.
	public PatientService(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	// This method saves a new Patient to the database and throws an exception if
	// the save fails.
	public Patient savePatient(final Patient patient) {
		// Saves the patient using the repository and throws an exception if saving
		// fails
		return Stream.of(patientRepository.save(patient)).findFirst()
				.orElseThrow(() -> new PatientException("ERREUR D'INSERTION PATIENT INPUT INVALID"));
	}

	// This method diagnoses a patient based on their health index.
	public List<String> diagnose(final int healthIndex) {
		List<String> units = new ArrayList<>();
		// Checks if the health index is divisible by 3, indicating a need for
		// cardiology.
		if (healthIndex % 3 == 0) {
			units.add("Cardiology");
		}
		// Checks if the health index is divisible by 5, indicating a need for
		// traumatology.
		if (healthIndex % 5 == 0) {
			units.add("Traumatology");
		}
		// Returns the list of recommended units.
		return units;
	}

	// This method retrieves all patients from the database.
	public List<Patient> getAll() {
		return patientRepository.findAll();
	}

	// This method retrieves a patient by their ID.
	public Optional<Patient> getPatientById(Long id) {
		return patientRepository.findById(id);
	}

}

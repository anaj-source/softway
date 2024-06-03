package com.softway.test.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.softway.test.service.PatientService;
import com.softway.test.exceptionController.PatientException;
import com.softway.test.model.Patient;

//This class is a REST Controller for handling patient-related requests.
@RestController
//This annotation defines the base URL path for the controller's endpoints.
@RequestMapping("/api/patients")
public class PatientController {

	// The PatientService is injected into the controller, allowing it to access
	private final PatientService patientService;

	public PatientController(final PatientService patientService) {
		this.patientService = patientService;
	}

	// This endpoint retrieves all patients from the database.
	// @GetMapping: Maps a GET request to the root path of the controller.
	// @ResponseStatus(HttpStatus.OK): Specifies the HTTP status code for success.
	@GetMapping()
	@ResponseStatus(HttpStatus.OK)
	public List<Patient> getAll() {
		return patientService.getAll();
	}

	// This endpoint saves a new patient to the database.
	// @PostMapping: Maps a POST request to the root path of the controller.
	// @ResponseStatus(HttpStatus.CREATED): Specifies the HTTP status code for
	// creation.
	// @RequestBody: Reads the Patient object from the request body.
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Patient savePatient(@RequestBody final Patient patient) {
		return patientService.savePatient(patient);
	}

	// This endpoint diagnoses a patient based on their health index.
	// @PostMapping("{id}"): Maps a POST request to a path with an ID variable.
	// @ResponseStatus(HttpStatus.OK): Specifies the HTTP status code for success.
	// @PathVariable: Extracts the ID from the URL path.
	@PostMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<String> diagnoses(@PathVariable final Long id) {
		Patient patient = patientService.getPatientById(id)
				.orElseThrow(() -> new PatientException("Patient inexistant avec ce ID: " + id));
		return patientService.diagnose(patient.getHealthIndex());
	}

}

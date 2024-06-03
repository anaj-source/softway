package com.softway.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.softway.test.model.Patient;

//This interface defines the repository for Patient entities.
//It extends JpaRepository, providing CRUD operations for Patient objects.
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

}

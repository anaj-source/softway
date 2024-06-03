package com.softway.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.softway.test.service.PatientService;

//This class contains unit tests for the PatientService class.
//It uses Spring Boot's test framework to run the tests in the application context.
@SpringBootTest
class ApplicationSoftwayMedicalApplicationTests {
	
	  // The PatientService is injected into the test class, allowing us to call its methods.
	@Autowired
    private PatientService patientService;

	  // This test case checks if the diagnose method correctly identifies the units for a health index of 15.
	 @Test
	    void diagnose() {
	        int healthIndex = 15;
	        List<String> units = patientService.diagnose(healthIndex);
	        assertEquals(2, units.size());
	        assertTrue(units.contains("Cardiology"));
	        assertTrue(units.contains("Traumatology"));
	    }
	  // This test case checks if the diagnose method correctly identifies only Cardiology for a health index of 6.
	    @Test
	    void diagnose_cardiologyOnly() {
	        int healthIndex = 6;
	        List<String> units = patientService.diagnose(healthIndex);
	        assertEquals(1, units.size());
	        assertTrue(units.contains("Cardiology"));
	    }
	    // This test case checks if the diagnose method correctly identifies only Traumatology for a health index of 10.
	    @Test
	    void diagnose_traumatologyOnly() {
	        int healthIndex = 10;
	        List<String> units = patientService.diagnose(healthIndex);
	        assertEquals(1, units.size());
	        assertTrue(units.contains("Traumatology"));
	    }
	    // This test case checks if the diagnose method correctly returns an empty list for a health index of 7.
	    @Test
	    void diagnose_noUnits() {
	        int healthIndex = 7;
	        List<String> units = patientService.diagnose(healthIndex);
	        assertEquals(0, units.size());
	    }

}

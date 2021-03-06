package com.inti.service.interfaces;

import java.util.Date;
import java.util.List;

import com.inti.entities.Consultation;

public interface IConsultationService {
	List<Consultation> findAll();
	Consultation findOne(Long idConsultation);
	Consultation save(Consultation consultation);
	void delete(Long idConsultation);
	Consultation findByIdPatientAndDate(Long idPatient, Date date);
}

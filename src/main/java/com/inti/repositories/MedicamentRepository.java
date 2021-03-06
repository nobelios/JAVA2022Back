package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Medicament;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long>{
	Medicament findByNomMedicament(String nomMedicament);
}

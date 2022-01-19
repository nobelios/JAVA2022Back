package com.inti.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Consultation {
	
	/** Variables **/
	// "idConsultation" est la clef primaire autogénérée de la table "Consultation"
	@Id // Clef primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id est autogénéré
	private long idConsultation;
	private long idPatient;
	private long idMedecin;
	private Date date;
	private long idOrdonnance;
	
	/** Associations **/
	// Association avec l'entité ordonnance
	@OneToOne(mappedBy="consultation") 
	private Ordonnance ordonnance;
	
	// Association avec utilisateur
	@ManyToMany(fetch = FetchType.EAGER) 
	@JoinTable(name = "rendezVous", joinColumns = @JoinColumn(name = "idConsultation", referencedColumnName = "idConsultation"), 
	inverseJoinColumns = @JoinColumn(name = "idUtilisateur", referencedColumnName = "idUtilisateur"))
	private Set<Consultation> consultations = new HashSet<>();	
	
	/** Constructeurs **/
	public Consultation() {
	
	}

	public Consultation(long idPatient, long idMedecin, Date date, long idOrdonnance) {
		this.idPatient = idPatient;
		this.idMedecin = idMedecin;
		this.date = date;
		this.idOrdonnance = idOrdonnance;
	}
	
	/** Getters & Setters **/
	public long getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(long idConsultation) {
		this.idConsultation = idConsultation;
	}
	public long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(long idPatient) {
		this.idPatient = idPatient;
	}
	public long getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(long idMedecin) {
		this.idMedecin = idMedecin;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getIdOrdonnance() {
		return idOrdonnance;
	}
	public void setIdOrdonnance(long idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}
	
	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	public Set<Consultation> getConsultations() {
		return consultations;
	}

	public void setConsultations(Set<Consultation> consultations) {
		this.consultations = consultations;
	}

	/** Methodes **/
	@Override
	public String toString() {
		return "Consultation [idConsultation=" + idConsultation + ", idPatient=" + idPatient + ", idMedecin="
				+ idMedecin + ", date=" + date + ", idOrdonnance=" + idOrdonnance + "]";
	}
}

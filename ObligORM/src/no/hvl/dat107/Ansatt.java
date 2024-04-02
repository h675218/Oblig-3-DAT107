package no.hvl.dat107;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Oblig3")

public class Ansatt {
	
	@Id
	private Integer ansatt_id;
    private String fornavn; 
    private String etternavn; 
    private String brukernavn; 
    private Date dato_ansatt; 
    private String stilling; 
    private BigDecimal lonn_mnd; 
    private Integer avdeling_id; 

	public Ansatt() {}
	
	public Ansatt(Integer ansatt_id, String fornavn, String etternavn, String brukernavn, Date dato_ansatt, String stilling, BigDecimal lonn_mnd, Integer avdeling_id) {
        this.ansatt_id = ansatt_id;
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.brukernavn = brukernavn;
        this.dato_ansatt = dato_ansatt;
        this.stilling = stilling;
        this.lonn_mnd = lonn_mnd;
        this.avdeling_id = avdeling_id;
    }
	
	public Integer getAnsatt_Id() {
		return ansatt_id;
	}
	public void setId(Integer id) {
		this.ansatt_id = id;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	
	public String getEtternavn() {
		return etternavn;
	}
	
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	
	public String getBrukernavn() {
		return brukernavn;
	}
	
	public Date getDatoAnsatt() {
		return dato_ansatt;
	}
	
	public String getStilling() {
		return stilling;
	}
	
	public BigDecimal getLonnMnd() {
		return lonn_mnd;
	}
	
	public Integer getAvdelingId() {
		return avdeling_id;
	}
	
	
	@Override
	public String toString() {
		return String.format("\tAnsatt: ansatt_id=%d, fornavn=%s, etternavn=%s, brukernavn=%s, dato_ansatt=%s, stilling=%s, lonn_mnd=%s, avdeling_id=%d", 
                ansatt_id, fornavn, etternavn, brukernavn, dato_ansatt, stilling, lonn_mnd, avdeling_id);
	}

}

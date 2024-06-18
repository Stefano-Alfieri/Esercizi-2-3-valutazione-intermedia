package org.generation.italy.model;

import java.time.LocalDate;

public class Recensione {
	private LocalDate data;
	private String nomeUtente;
	private int numeroStelle;
	private String testo;

	public Recensione(String nomeUtente, int numeroStelle, String testo) throws Exception {
		data = data.now();
		if (!nomeUtente.isBlank()) {
			this.nomeUtente = nomeUtente;
		} else {
			throw new Exception("il nome utente non è valido");
		}
		if(numeroStelle>0&&numeroStelle<=5) {
			this.numeroStelle = numeroStelle;
		}else {
			throw new Exception("numero stelle inserito non valido");
			}
		if(!testo.isBlank()) {
		this.testo = testo;
		}else {
			throw new Exception("il testo inserito non è valido");
		}
	}

	public LocalDate getData() {
		return data;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public int getNumeroStelle() {
		return numeroStelle;
	}

	public String getTesto() {
		return testo;
	}

	@Override
	public String toString() {
		return "Recensione [data=" + data + ", nomeUtente=" + nomeUtente + ", numeroStelle=" + numeroStelle + ", testo="
				+ testo + "]";
	}

}

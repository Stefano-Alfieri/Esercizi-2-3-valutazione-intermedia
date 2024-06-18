package org.generation.italy.model;

import java.util.ArrayList;

public class MobileApp {
	String nome, sistemaOperativo;
	float prezzo, ricavoTotale, media;
	int numeroValutazioni;
	ArrayList<Recensione> elencoRecensioni = new ArrayList<Recensione>();

	public MobileApp(String nome, String sistemaOperativo, float prezzo) throws Exception {
		if (!nome.isBlank()) {
			this.nome = nome;
		} else {
			throw new Exception("nome non valido");
		}
		if (!sistemaOperativo.isBlank()) {
			this.sistemaOperativo = sistemaOperativo;
		} else {
			throw new Exception("sistema operativo non valido");
		}
		if (prezzo >= 0) {
			this.prezzo = prezzo;
		} else {
			throw new Exception("il prezzo non può essere negativo");
		}
		numeroValutazioni = 0;
		ricavoTotale = 0;
		elencoRecensioni.clear();
	}

	@Override
	public String toString() {
		return "MobileApp [nome=" + nome + ", ricavoTotale=" + ricavoTotale + " Valutazione Media= "+ valutazioneMedia()+ "]";
	}

	public void download() {
		ricavoTotale = ricavoTotale + prezzo;
	}

	public void download(int numeroDownload) throws Exception {
		if (numeroDownload > 0) {
			ricavoTotale = ricavoTotale + (prezzo * numeroDownload);
		} else {
			throw new Exception("Il numero dei download non può essere negativo");
		}
	}

	public void riceviRecensione(Recensione recensione) {
		elencoRecensioni.add(recensione);
		numeroValutazioni++;
	}

	public float valutazioneMedia() {
		int totaleStelle = 0;
		if (elencoRecensioni.size() == 0) {
			System.out.println("non sono presenti valutazioni");
		} else {
			for (Recensione r : elencoRecensioni) {
				totaleStelle = totaleStelle + r.getNumeroStelle();
			}
			media = totaleStelle / elencoRecensioni.size();
		}
		return media;
	}

	public ArrayList<Recensione> getElencoRecensioni() {
		return elencoRecensioni;
	}

}

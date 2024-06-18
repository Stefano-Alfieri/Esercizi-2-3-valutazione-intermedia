package org.generation.italy;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import org.generation.italy.model.MobileApp;
import org.generation.italy.model.Recensione;

public class Main {
	static private LocalDate data;
	private static String nomeUtente, nome, sistemaOperativo;
	private static float prezzo, ricavoTotale;
	private static int numeroStelle, numeroValutazioni;
	private static String testo;
	static boolean uscita = false;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				// inizio creazione app
				System.out.println("Benvenuto in 'crea la tua app'");
				System.out.println("inserisci il nome dell'app:");
				nome = sc.nextLine();
				System.out.println("inserisci il sistema operativo per il quale sarà disponible:");
				sistemaOperativo = sc.nextLine();
				System.out.println("inserisci il prezzo della tua App:");
				prezzo = sc.nextFloat();
				sc.nextLine();
				// creazione oggetto
				MobileApp app = new MobileApp(nome, sistemaOperativo, prezzo);
				// inizio menu
				System.out.println("Cosa vuoi fare?");
				do {
				System.out.println(
						"(1)Download singolo, (2)Download Multiplo, (3)Inserisci recensione, (4)Visualizza Recensioni, (5)Esci:");
				// inizio risposta menu
				String risp = sc.nextLine();
				switch (risp) {
				// download singolo
				case "1":
					System.out.println("Downloading...");
					try {
						app.download();
						System.out.println("Download completato...");
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					System.out.println(app.toString());
					break;
				// download multipli
				case "2":
					System.out.println("Quanti donwload vuoi effettuare?");
					int rispDown = sc.nextInt();
					sc.nextLine();
					System.out.println("Downloading app " + rispDown + " volte");
					try {
						app.download(rispDown);
						System.out.println("Download multipli completati con successo!");

					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					System.out.println(app.toString());
					break;
				// inserisci recensione
				case "3":
					System.out.println("Inserisci il nome utente:");
					nomeUtente = sc.nextLine();
					System.out.println("Inserisci il numero di stelle da assegnare:");
					numeroStelle = sc.nextInt();
					sc.nextLine();
					System.out.println("Inserisci il testo della recensione:");
					testo = sc.nextLine();
					try {
						Recensione recensione = new Recensione(nomeUtente, numeroStelle, testo);
						System.out.println("Recensione creata con successo");
						app.riceviRecensione(recensione);
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
					System.out.println(app.toString());
					break;
				// visualizza recensioni
				case "4":
					if (app.getElencoRecensioni().size() > 0) {
						System.out.println("Recensioni:");
						System.out.println(app.getElencoRecensioni()+"\n");	
					} else {
						throw new Exception("Nessuna recensione presente");
					}
					System.out.println(app.toString());
					break;
				// uscita
				case "5":
					System.out.println("Uscita in corso...");
					System.out.println("Arrivederci.");
					uscita = true;
					break;
				}// fine scelta menu

			} while (uscita == false);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

	}// fine main

}

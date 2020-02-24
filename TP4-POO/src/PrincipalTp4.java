/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : PrincipalTp4.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, H�tel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe PrincipalTp4 permet de faire la gestion des chambres d'un h�tel.
 */

public class PrincipalTp4 {

	/**
	 * Le constructeur de la classe PrincipalTp4 permet de faire la gestion
	 * des chambres d'un h�tel avec l'aide d'un menu.
	 */

	public PrincipalTp4() {
		
		// Constante pour le texte du menu principal.
		
		final String MENU_PRINCIPAL = 
			"\nMenu principal pour la gestion des chambres de l'h�tel Montmotel\n\n" +
			"1. Arriv�e d'un client\n" +
			"2. D�part d'un client\n" +
			"3. Afficher les tarifs de base\n" +
			"4. Afficher la disponibilit� d'une chambre quelconque\n" +
			"5. Afficher la disponibilit� de toutes les chambres\n" +
			"6. Afficher la disponibilit� de toutes les chambres standards\n" +
			"7. Afficher la disponibilit� de toutes les chambres qui ont un acc�s Internet\n" +
			"8. Afficher la disponibilit� de toutes les chambres de luxe (acc�s Internet et repas en chambre)\n" +
			"9. Quitter le programme";

		// Constantes pour les choix du menu.
		
		final char ARRIVEE         = '1';
		final char DEPART          = '2';
		final char TARIFS          = '3';
		final char UNE_CHAMBRE     = '4';
		final char TOUTES_CHAMBRES = '5';
		final char STANDARD        = '6';
		final char INTERNET        = '7';
		final char LUXE            = '8';
		final char QUITTER         = '9';

		final String MESS_BIENVENUE = "\nBienvenue au programme de gestion des chambres de l'h�tel Montmotel.";

		final String MESS_FIN = "\nFin du programme.\n";

		char choix; // Choix du menu principal.

		System.out.println( MESS_BIENVENUE );
		
		Hotel hotel = new Hotel();

		/*
		 * TODO (� COMPL�TER).
		 * 
		 * Cr�er un objet de la classe Hotel. Voir en haut de la page 5 de l'�nonc� du TP4.
		 */


		
		do {
			choix = OutilsAffichage.afficherChoisirMenu( MENU_PRINCIPAL, ARRIVEE, QUITTER );

			switch ( choix ) {

			case ARRIVEE:
				
				
				new Arrivee(hotel);
				
				/*
				 * TODO (� COMPL�TER). Cr�er une instance de la classe Arrivee
				 * (Vous devez envoyer le bon param�tre au constructeur).
				 */

				
				break;

			case DEPART:
				
				new Depart(hotel);
				/*
				 * TODO (� COMPL�TER). Cr�er une instance de la classe Depart
				 * (Vous devez envoyer le bon param�tre au constructeur).
				 */


				break;

			case TARIFS:
				
				Hotel.afficherTarifsBase();
				
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode statique de la classe
				 * Hotel qui permet d'afficher les tarifs de base.
				 */


				break;

			case UNE_CHAMBRE:
				
				afficherUneChambre( hotel );
				
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode priv�e de cette classe, afficherUneChambre().
				 * Vous devez envoyer le bon param�tre � la m�thode.
				 */


				break;

			case TOUTES_CHAMBRES:
				
				hotel.afficherDisponibilite();
				
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet hotel qui permet
				 * d'afficher la disponibilit� de toutes les chambres de l'h�tel.
				 */


				break;

			case STANDARD:
				
				hotel.afficherDisponibilite( Hotel.STANDARD );
				
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet hotel qui permet
				 * d'afficher la disponibilit� des chambres de type Hotel.STANDARD.
				 */


				break;

			case INTERNET:
				
				hotel.afficherDisponibilite( Hotel.INTERNET );
				
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet hotel qui permet
				 * d'afficher la disponibilit� des chambres de type Hotel.INTERNET.
				 */


				break;

			case LUXE:
				
				hotel.afficherDisponibilite( Hotel.LUXE );
				
				/*
				 * TODO (� COMPL�TER). Ex�cuter la m�thode appropri�e de l'objet hotel qui permet
				 * d'afficher la disponibilit� des chambres de type Hotel.LUXE.
				 */


				break;

			case QUITTER:
				System.out.println( MESS_FIN );
				break;
			}
		} while ( choix != QUITTER );
	}

	/**
	 * La m�thode priv�e afficherUneChambre() permet d'afficher la disponibilit� d'une seule chambre quelconque.
	 * 
	 * @param hotel
	 *            Objet qui g�re l'h�tel.
	 */

	private void afficherUneChambre( Hotel hotel ) {
		
		// Constantes.

		final char OUI = 'O';

		final String TITRE_DISPO = "\nDisponibilit� d'une chambre quelconque.";
		final String QUEST_AUTRE_DISPO = "\nVoulez-vous consulter la disponibilit� d'une autre chambre (O ou N) ? ";
		
		int type, noChambre;
		char recommencer;

		do {
			System.out.println( TITRE_DISPO );
			
			type = Hotel.lireTypeChambre();
			
			noChambre = Hotel.lireNoChambre();
			
			hotel.afficherDisponibilite( type, noChambre );

			/*
			 * TODO (� COMPL�TER). Voir page 13 de l'�nonc� du TP4.
			 */


			
			recommencer = OutilsLecture.lireOuiNon( QUEST_AUTRE_DISPO );
		} while ( recommencer == OUI );
	}
}
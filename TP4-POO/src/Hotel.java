/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : Hotel.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, H�tel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe Hotel contient les informations et les m�thodes pour un h�tel de trois �tages.
 * Sur le premier �tage, il y a 5 chambres standards. Sur le deuxi�me �tage, il y a 5 chambres avec un acc�s � Internet
 * et sur le troisi�me �tage, il y a 5 chambres de luxe (acc�s � Internet et � des repas en chambre).
 */

public class Hotel {

	// Constantes de la classe Hotel.

	// Il y a 3 types de chambres et 5 chambres par type.
	
	public static final int MAX_TYPES    = 3;
	public static final int MAX_CHAMBRES = 5;

	// Indices pour les types de chambres.
	
	public static final int STANDARD = 0;
	public static final int INTERNET = 1;
	public static final int LUXE     = 2;

	// Tableau des noms des 3 types de chambres.
	
	public static final String[] TAB_TYPES = { "standard", "Internet", "de luxe" };

	// Champs d'instance priv�s de la classe Hotel.

	// L'h�tel est compos� d'un tableau � deux dimensions de ChambreStandard.
	// La premi�re dimension (les lignes) repr�sente les 3 types de chambres et
	// la deuxi�me dimension (les colonnes) repr�sente les 5 chambres de chaque type.

	private ChambreStandard[][] tabChambres = new ChambreStandard[Hotel.MAX_TYPES][Hotel.MAX_CHAMBRES];

	// Tableau qui contient le nombre de chambres occup�es pour chaque type de chambre.
	
	private int[] tabOccupees = new int[Hotel.MAX_TYPES];

	/**
	 * Le constructeur de la classe Hotel permet de construire toutes les chambres de l'h�tel. Le premier �tage
	 * contient les chambres standards, le deuxi�me �tage contient les chambres � acc�s Internet et le troisi�me �tage
	 * contient les chambres de luxe. Au d�but, toutes les chambres sont disponibles.
	 */

	public Hotel() {
		
		// Cr�er le bon type de chambre pour chaque chambre.
		
		for(int nbChambre = 0; nbChambre < Hotel.MAX_CHAMBRES; nbChambre++) {
			
			this.tabChambres[Hotel.STANDARD][nbChambre] = new ChambreStandard();
			
			this.tabChambres[Hotel.INTERNET][nbChambre] = new ChambreInternet();
			
			this.tabChambres[Hotel.LUXE][nbChambre] = new ChambreLuxe();
		}
		
		// Initialiser le nombre de chambres occup�es pour chaque type.
		
		for( int type = 0; type < Hotel.MAX_TYPES; type++) {
			this.tabOccupees[type] = 0;
		}

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4. Mettre �galement les commentaires.
		 */


	}

	/**
	 * La m�thode chambreDisponible() permet d'indiquer si un num�ro de chambre d'un certain type est disponible.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 * @return true si la chambre est disponible et false dans le cas contraire.
	 */

	public boolean chambreDisponible( int type, int noChambre ) {
		
		boolean chambreDisponible = false;
		
		if(tabChambres[type][noChambre].isDisponible()) {
			chambreDisponible = true;
		}
		
		return chambreDisponible;

		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode reserverChambre() permet de r�server un num�ro de chambre d'un certain type.
	 * Il s'agit de modifier le champ disponible de la chambre en question pour la valeur false et
	 * de mettre � jour le nombre de chambres occup�es.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 */

	public void reserverChambre( int type, int noChambre ) {
		
		if( chambreDisponible( type, noChambre ) ) {
			tabChambres[type][noChambre].setDisponible( false );
			
			tabOccupees[type]++;
			
		}
		
		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode libererChambre() permet de lib�rer un num�ro de chambre d'un certain type.
	 * Il s'agit de r�gler la chambre en question et de mettre � jour le nombre de chambres occup�es.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 */

	public void libererChambre( int type, int noChambre ) {
		
		if(!chambreDisponible( type, noChambre )) {
			tabChambres[type][noChambre].reglerChambre();
			
			tabOccupees[type]--;
		}
		
		/*
		 * TODO (� COMPL�TER). Voir page 10 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode typePlein permet d'indiquer si toutes les chambres d'un certain type sont occup�es.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont occup�es et false dans le cas contraire.
	 */

	public boolean typePlein( int type ) {
		
		boolean typePlein = false;
		
		if(tabOccupees[type] == Hotel.MAX_CHAMBRES) {
			typePlein = true;
		}
		return typePlein;
		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */
	}

	/**
	 *La m�thode typeVide() permet d'indiquer si toutes les chambres d'un certain type sont vides.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @return true si toutes les chambres du type sont vides et false dans le cas contraire.
	 */

	public boolean typeVide( int type ) {
		
		boolean typeVide = false;
		
		if(tabOccupees[type]  == 0) {
			typeVide = true;
		}
		return typeVide;
		
		
		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode estPlein() permet d'indiquer si toutes les chambres de l'h�tel sont occup�es.
	 * 
	 * @return true si toutes les chambres de l'h�tel sont occup�es et false dans le cas contraire.
	 */

	public boolean estPlein() {
		
		boolean toutPlein = false;
		
		if(typePlein( Hotel.STANDARD ) && typePlein( Hotel.INTERNET ) && typePlein( Hotel.LUXE )) {
			toutPlein = true;
		}
		
		return toutPlein;
		
		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode estVide() permet d'indiquer si toutes les chambres de l'h�tel sont vides.
	 * 
	 * @return true si toutes les chambres de l'h�tel sont vides et false dans le cas contraire.
	 */

	public boolean estVide() {
		
	boolean toutVide = false;
		
		if(typeVide( Hotel.STANDARD ) && typeVide( Hotel.INTERNET ) && typeVide( Hotel.LUXE )) {
			toutVide = true;
		}
		
		return toutVide;

		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode afficherDisponibilite() permet d'afficher la disponibilit� d'une chambre en particulier.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 * @param noChambre
	 *            Le num�ro de la chambre.
	 */

	public void afficherDisponibilite( int type, int noChambre ) {
		
		if(tabChambres[type][noChambre].isDisponible()) {
			System.out.println( "\nLa chambre num�ro "+ noChambre + " de type " + type + " est disponible." );
		}else {
			System.out.println( "\nLa chambre num�ro "+ noChambre + " de type " + type + " est occup�e." );
		}
		

		/*
		 * TODO (� COMPL�TER). Voir page 11 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode afficherDisponibilite() permet d'afficher la disponibilit� de toutes les chambres d'un certain type.
	 * 
	 * @param type
	 *            Le type de la chambre.
	 */

	public void afficherDisponibilite( int type ) {
		
		System.out.println( "\nDisponibilit� des chambres de type "+ Hotel.TAB_TYPES[type] + " : \n" );
		
		for(int noChambre = 0; noChambre < Hotel.MAX_CHAMBRES; noChambre++) {
			
			if(tabChambres[type][noChambre].isDisponible() ) {
			
				System.out.print( (noChambre + 1) + " : Disponible  " );
			} else {
				System.out.print( (noChambre + 1) + " : Occup�e " );
	
			}
		}
		
		System.out.print( "\n" );

		/*
		 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP4.
		 */

		
	}

	/**
	 * La m�thode afficherDisponibilite() permet d'afficher la disponibilit� de toutes les chambres de l'h�tel.
	 */

	public void afficherDisponibilite() {
		
		System.out.println( "Disponibilit� de toutes les chambres de l'h�tel Montmotel." );
		
		for(int type = 0; type < Hotel.MAX_TYPES; type++) {
			
			afficherDisponibilite(type);
			
		}

		/*
		 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP4.
		 */
		

	}

	/**
	 * La m�thode statique afficherTarifsBase() permet d'afficher les tarifs de base de chaque type de chambre.
	 */

	public static void afficherTarifsBase() {
		
		ChambreStandard.afficherTarifsBase();
		
		ChambreInternet.afficherTarifsBase();
		
		ChambreLuxe.afficherTarifsBase();

		/*
		 * TODO (� COMPL�TER). Voir page 12 de l'�nonc� du TP4.
		 */
		

	}

	/**
	 * La m�thode statique lireTypeChambre() permet de lire un type de chambre et de le retourner.
	 * 
	 * @return Une valeur entre 0 et MAX_TYPES - 1 pour faciliter l'acc�s au tableau.
	 */

	public static int lireTypeChambre() {
		
		// Constantes de la m�thode.
		
		final String QUEST_TYPE_CHAMBRE = "\nEntrez le type de la chambre ([S]tandard, [I]nternet ou [L]uxe) : ";

		final String TYPES_POSSIBLES = "SIL";

		int type;
		char carType;

		carType = OutilsLecture.lireCaractereDisparate( QUEST_TYPE_CHAMBRE,	TYPES_POSSIBLES );

		// Type contiendra 0 si S, 1 si I ou 2 si L.
		
		type = TYPES_POSSIBLES.indexOf( carType );

		return type;
	}

	/**
	 * La m�thode statique lireNoChambre() permet de lire un num�ro de chambre et de le retourner.
	 * 
	 * @return Une valeur entre 0 et MAX_CHAMBRES - 1 pour faciliter l'acc�s au tableau.
	 */

	public static int lireNoChambre() {

		// Constante de la m�thode.

		final String QUEST_NO_CHAMBRE = "\nEntrez le num�ro de la chambre (entre 1 et " + Hotel.MAX_CHAMBRES + ") : ";

		int noChambre;

		noChambre = OutilsLecture.lireEntierValide( QUEST_NO_CHAMBRE, 1, Hotel.MAX_CHAMBRES );

		return noChambre - 1;
	}
}
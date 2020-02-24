/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : ChambreLuxe.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, H�tel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe ChambreLuxe h�rite de la classe ChambreInternet.
 * 
 * La classe ChambreLuxe contient les informations et les m�thodes suppl�mentaires pour une chambre de l'h�tel qui a un
 * acc�s � Internet et � des repas en chambre.
 */

public class ChambreLuxe extends ChambreInternet {

	// Constantes de la classe ChambreLuxe.

	// Peut prendre entre 0 et 62 repas servis directement dans la chambre.
	
	public static final int MIN_REPAS = 0;
	public static final int MAX_REPAS = 62;

	// Un repas en chambre co�te 29.99 $.

	public static final double PRIX_REPAS = 29.99;

	// Champ d'instance priv� de la classe ChambreLuxe.

	private int nbRepas; // Nombre de repas servis directement dans la chambre.

	/**
	 * Le constructeur de la classe ChambreLuxe permet de construire une chambre de luxe de base.
	 * Au d�but, aucun repas.
	 */

	public ChambreLuxe() {
		
		initialiserChambre();
		
		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */


	}

	/**
	 * Red�finition de la m�thode qui permet d'initialiser une chambre.
	 */

	@Override
	public void initialiserChambre() {
		
		super.initialiserChambre();
		
		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode accesseur getNbRepas() permet de retourner le nombre de repas servis en chambre.
	 * 
	 * @return Le nombre de repas servis en chambre.
	 */

	public int getNbRepas() {
		
		return this.nbRepas;
	}

	/**
	 * La m�thode mutateur setNbRepas() permet de modifier le nombre de repas avec celui re�u en param�tre.
	 * 
	 * @param nbRepas
	 *            Le nombre de repas servis en chambre.
	 */

	public void setNbRepas( int nbRepas ) {
		
		if ( nbRepas >= ChambreLuxe.MIN_REPAS && nbRepas <= ChambreLuxe.MAX_REPAS ) {

			this.nbRepas = nbRepas;
		}
	}

	/**
	 * Red�finition de la m�thode qui lit les informations � la fin du s�jour (lorsque le client quitte).
	 */

	@Override
	public void lireInfosDepart() {
		
		// Constante de la m�thode.

		final String QUEST_NB_REPAS = "\nEntrez le nombre de repas servis en chambre (entre " +
				                      ChambreLuxe.MIN_REPAS + " et " + ChambreLuxe.MAX_REPAS + ") : ";

		super.lireInfosDepart();
		
		int nbRepasServis = OutilsLecture.lireEntierValide( QUEST_NB_REPAS, MIN_REPAS, MAX_REPAS );
		
		this.setNbRepas( nbRepasServis );
		
		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */


	}

	/**
	 * Red�finition de la m�thode qui calcule et retourne le prix total de la chambre.
	 */

	@Override
	public double calculerPrixTotal() {
		
		return this.getNbRepas() * PRIX_REPAS + super.calculerPrixTotal();

		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */
		

	}

	/**
	 * La m�thode statique afficherTarifsBase() permet d'afficher les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {
		
		System.out.println( "Prix pour un repas servi en chambre : \t" +
							OutilsAffichage.formaterMonetaire( PRIX_REPAS, 2 ) + "." );

		/*
		 * TODO (� COMPL�TER). Voir page 9 de l'�nonc� du TP4.
		 */


	}
}
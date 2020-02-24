/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : ChambreStandard.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, H�tel)
 */

// Package du programmeur.

import outilsjava.*;

/**
 * La classe ChambreStandard contient les informations et les m�thodes pour une chambre de type standard.
 */

public class ChambreStandard {

	// Constantes de la classe ChambreStandard.

	// Dur�e du s�jour entre 1 et 31 jours.
	
	public static final int MIN_JOURS = 1;
	public static final int MAX_JOURS = 31;

	// 120.00 $ par jour, taxes et frais de services inclus.
	
	public static final double PRIX_BASE = 120.00;

	// Champs d'instance priv�s de la classe ChambreStandard.

	// Nombre de jours du s�jour.
	
	private int nbJours;

	// true, la chambre est disponible et false, la chambre n'est pas disponible.
	
	private boolean disponible;

	/**
	 * Le constructeur de la classe ChambreStandard permet de construire une chambre de type standard de base.
	 * Au d�but, nombre de jours � 0 et la chambre est disponible.
	 */

	public ChambreStandard() {

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */
		initialiserChambre();

	}

	/**
	 * La m�thode initialiserChambre() permet d'initialiser une chambre.
	 * Nombre de jours � 0 et la chambre est disponible.
	 */

	public void initialiserChambre() {

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */
		this.setDisponible( true );
		this.setNbJours( 0 );

	}

	/**
	 * La m�thode accesseur getNbJours() permet de retourner le nombre de jours du s�jour.
	 * 
	 * @return Le nombre de jours du s�jour.
	 */

	public int getNbJours() {
		
		return this.nbJours;
	}

	/**
	 * La m�thode accesseur isDisponible() permet de retourner la disponiblit� de la chambre. Remarque : le nom est
	 * isDisponible au lieu de getDisponible, car l'accesseur retourne un bool�en.
	 * 
	 * @return true, la chambre est disponible et false, la chambre n'est pas disponible.
	 */

	public boolean isDisponible() {
		
		return this.disponible;
	}

	/**
	 * La m�thode mutateur setNbJours() permet de modifier le nombre de jours du s�jour
	 * avec celui re�u en param�tre.
	 * 
	 * @param nbJours
	 *            Le nombre de jours du s�jour.
	 */

	public void setNbJours( int nbJours ) {
		
		if ( nbJours >= 0 && nbJours <= ChambreStandard.MAX_JOURS ) {
			this.nbJours = nbJours;
		}
	}

	/**
	 * La m�thode mutateur setDisponible() permet de modifier la disponibilit� de la chambre
	 * avec celle re�ue en param�tre.
	 * 
	 * @param disponible
	 *            La disponibilit� de la chambre (true ou false).
	 */

	public void setDisponible( boolean disponible ) {
		
		this.disponible = disponible;
	}

	/**
	 * La m�thode lireInfosDepart() permet de lire les informations � la fin du s�jour (lorsque le client quitte).
	 */

	public void lireInfosDepart() {
		
		// Constante de la m�thode.
		
		final String QUEST_NB_JOURS = "\nEntrez le nombre de jours du s�jour (entre " +
									  ChambreStandard.MIN_JOURS + " et " + ChambreStandard.MAX_JOURS + ") : ";

		int nbJoursSejour = OutilsLecture.lireEntierValide( QUEST_NB_JOURS, MIN_JOURS, MAX_JOURS );
		
		
		this.setNbJours( nbJoursSejour );
		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode calculerPrixTotal() permet de calculer et de retourner le prix total de la chambre.
	 * 
	 * @return Le prix total de la chambre.
	 */

	public double calculerPrixTotal() {

		return this.getNbJours() * PRIX_BASE;
		
		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode reglerChambre() permet de r�gler la chambre � la fin du s�jour � l'h�tel. La m�thode
	 * lit les informations n�cessaires pour calculer la facture et r�initialise la chambre.
	 */

	public void reglerChambre() {
		
		lireInfosDepart();
		
		System.out.println( "\nPrix total pour la chambre : " +
							OutilsAffichage.formaterMonetaire(calculerPrixTotal(), 2 ) + "\n");
		
		initialiserChambre();

		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode statique afficherTarifsBase() permet d'afficher les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {
		
		System.out.println( "Prix pour la chambre : \t\t\t" + OutilsAffichage.formaterMonetaire(PRIX_BASE, 2) + 
							" par jour (taxes et frais de services inclus)." );	
		
		/*
		 * TODO (� COMPL�TER). Voir page 7 de l'�nonc� du TP4.
		 */


	}
}
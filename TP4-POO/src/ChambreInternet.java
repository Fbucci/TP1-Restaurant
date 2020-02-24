import outilsjava.OutilsAffichage;
import outilsjava.OutilsLecture;

/*
 * Auteurs : Simon Manouk et Christian Mongeon,	Groupe : 65
 * Fichier : ChambreInternet.java
 * Date    : 15 avril 2019
 * Cours   : 420-ZE4-MO (TP4, H�tel)
 */

// Package du programmeur.


/**
 * La classe ChambreInternet h�rite de la classe ChambreStandard.
 * 
 * La classe ChambreInternet contient les informations et les m�thodes suppl�mentaires
 * pour une chambre de l'h�tel qui a un acc�s � Internet.
 */

public class ChambreInternet extends ChambreStandard {

	// Constantes de la classe ChambreInternet.

	// Peut acc�der � Internet entre 0 et 744 heures (31 jours * 24 heures).
	
	public static final double MIN_HEURES = 0;
	public static final double MAX_HEURES = ChambreStandard.MAX_JOURS * 24;

	// L'acc�s Internet co�te 0.50 $ de l'heure.
	
	public static final double PRIX_INTERNET = 0.50;

	// Champ d'instance priv� de la classe ChambreInternet.

	private double nbHeures; // Nombre d'heures pour l'acc�s Internet.

	/**
	 * Le constructeur de la classe ChambreInternet permet de construire une chambre � acc�s Internet de base.
	 * Au d�but, aucun acc�s � Internet.
	 */

	public ChambreInternet() {
		
		initialiserChambre();
		
		/*
		 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP4.
		 */

		
	}

	/**
	 * Red�finition de la m�thode qui permet d'initialiser une chambre.
	 */

	@Override
	public void initialiserChambre() {
		
		super.initialiserChambre();
		
		/*
		 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP4.
		 */

		
	}

	/**
	 * La m�thode accesseur getNbHeures() permet de retourner le nombre d'heures d'acc�s � Internet.
	 * 
	 * @return Le nombre d'heures d'acc�s � Internet.
	 */

	public double getNbHeures() {
		
		return this.nbHeures;
	}

	/**
	 * La m�thode mutateur setNbHeures() permet de modifier le nombre d'heures d'acc�s � Internet
	 * avec celui re�u en param�tre.
	 * 
	 * @param nbHeures
	 *            Le nombre d'heures d'acc�s � Internet.
	 */

	public void setNbHeures( double nbHeures ) {
		
		if ( nbHeures >= ChambreInternet.MIN_HEURES && nbHeures <= ChambreInternet.MAX_HEURES ) {

			this.nbHeures = nbHeures;
		}
	}

	/**
	 * Red�finition de la m�thode qui lit les informations � la fin du s�jour (lorsque le client quitte).
	 */

	@Override
	public void lireInfosDepart() {

		// Constante de la m�thode.

		final String QUEST_NB_HEURES = "\nEntrez le nombre d'heures d'acc�s � Internet (entre " +
									   ChambreInternet.MIN_HEURES + " et " + ChambreInternet.MAX_HEURES + ") : ";

		super.lireInfosDepart();
		
		int nbHeuresInternet = OutilsLecture.lireEntierValide( QUEST_NB_HEURES, 
								(int) MIN_HEURES, (int) MAX_HEURES );
		
		this.setNbHeures( nbHeuresInternet );
		
		
		/*
		 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP4.
		 */

		
	}

	/**
	 * Red�finition de la m�thode qui calcule et retourne le prix total de la chambre.
	 */

	@Override
	public double calculerPrixTotal() {
		
		return this.getNbHeures() * PRIX_INTERNET + super.calculerPrixTotal();

		/*
		 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP4.
		 */


	}

	/**
	 * La m�thode statique afficherTarifsBase() permet d'afficher les tarifs de base de la chambre.
	 */

	public static void afficherTarifsBase() {
		
		System.out.println( "Prix pour l'acc�s � Internet : \t\t"+
							OutilsAffichage.formaterMonetaire( PRIX_INTERNET, 2 )+" de l'heure." );
		
		/*
		 * TODO (� COMPL�TER). Voir page 8 de l'�nonc� du TP4.
		 */


	}
}
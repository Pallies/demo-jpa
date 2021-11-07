package diginamic.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Fournisseur.
 */
@Entity
@Table(name = "FOURNISSEUR")
public class Fournisseur {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The nom. */
	@Column(name = "NOM")
	private String nom;

	/**
	 * #Constructor
	 * Instantiates a new fournisseur.
	 */
	public Fournisseur() {
	}

	/**
	 * Instantiates a new fournisseur.
	 *
	 * @param id  the id
	 * @param nom the nom
	 */
	public Fournisseur(int id, String nom) {
		setId(id);
		setNom(nom);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Fournisseur id : " + id + ", nom : " + nom;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}

package diginamic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Article.
 */
@Entity
@Table(name = "ARTICLE")
public class Article implements Serializable {


	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The ref. */
	@Column(name = "REF", length = 13)
	private String ref;

	/** The designation. */
	@Column(name = "DESIGNATION", nullable = true)
	private String designation;

	/** The prix. */
	@Column(name = "PRIX", scale = 7, precision = 2, nullable = true)
	private double prix;

	/** The id fournisseur. */

	@Column(name = "ID_FOU", nullable = true)
	private int idFournisseur;

	/**
	 * #Constructor
	 * Instantiates a new article.
	 */
	public Article() {
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * Gets the ref.
	 *
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Sets the ref.
	 *
	 * @param ref the new ref
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * Gets the designation.
	 *
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * Sets the designation.
	 *
	 * @param designation the new designation
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * Gets the prix.
	 *
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Sets the prix.
	 *
	 * @param prix the new prix
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * Gets the id fournisseur.
	 *
	 * @return the id fournisseur
	 */
	public int getIdFournisseur() {
		return idFournisseur;
	}

	/**
	 * Sets the id fournisseur.
	 *
	 * @param id_fournisseur the new id fournisseur
	 */
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

}

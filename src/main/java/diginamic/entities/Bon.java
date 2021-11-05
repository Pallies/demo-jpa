package diginamic.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Bon.
 */
@Entity
@Table(name = "BON")
public class Bon {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The numero. */
	@Column
	private int numero;

	/** The date. */
	@Column
	private LocalDate date;

	/** The delai. */
	@Column
	private int delai;

	/** The id fournisseur. */
	@Column
	private int idFournisseur;

	/**
	 * Gets the date.
	 *
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Gets the delai.
	 *
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
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
	 * Gets the id fournisseur.
	 *
	 * @return the id fournisseur
	 */
	public int getIdFournisseur() {
		return idFournisseur;
	}

	/**
	 * Gets the numero.
	 *
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Sets the delai.
	 *
	 * @param delai the new delai
	 */
	public void setDelai(int delai) {
		this.delai = delai;
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
	 * Sets the id fournisseur.
	 *
	 * @param id_fournisseur the new id fournisseur
	 */
	public void setIdFournisseur(int idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	/**
	 * Sets the numero.
	 *
	 * @param numero the new numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

}

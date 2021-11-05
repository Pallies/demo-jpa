package diginamic.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The Class Livre.
 */
@Entity
@Table(name="LIVRE")
public class Livre implements Serializable {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5924102290935847292L;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/** The titre. */
	@Column(name="TITRE",length=255)
	private String titre;
	
	/** The auteur. */
	@Column(name="AUTEUR",length=50)
	private String auteur;
	
	/**
	 * Instantiates a new livre.
	 */
	public Livre() {
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
	 * Gets the titre.
	 *
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * Sets the titre.
	 *
	 * @param titre the new titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * Gets the auteur.
	 *
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * Sets the auteur.
	 *
	 * @param auteur the new auteur
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Livre id : " + id + ", titre : " + titre + ", auteur : " + auteur ;
	}

}

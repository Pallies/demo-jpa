package diginamic.entities;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Compo.
 */

@Table(name = "COMPO")
public class Compo {

	/** The id art. */
	@Column(name = "ID_ART")
	@OneToOne(targetEntity = Article.class)
	private int idArt;

	/** The id bon. */
	@Column(name = "ID_BON")
	@OneToOne(targetEntity = Bon.class)
	private int IdBon;

	/** The quantité. */
	@Column(name = "QTE")
	private int quantité;

	/**
	 * Instantiates a new compo.
	 */
	public Compo() {
	}

	/**
	 * Gets the id art.
	 *
	 * @return the id art
	 */
	public int getidArt() {
		return idArt;
	}

	/**
	 * Gets the id bon.
	 *
	 * @return the id bon
	 */
	public int getIdBon() {
		return IdBon;
	}

	/**
	 * Gets the quantité.
	 *
	 * @return the quantité
	 */
	public int getQuantité() {
		return quantité;
	}

	/**
	 * Sets the id art.
	 *
	 * @param idArt the new id art
	 */
	public void setidArt(int idArt) {
		this.idArt = idArt;
	}

	/**
	 * Sets the id bon.
	 *
	 * @param IdBon the new id bon
	 */
	public void setIdBon(int IdBon) {
		this.IdBon = IdBon;
	}

	/**
	 * Sets the quantité.
	 *
	 * @param quantité the new quantité
	 */
	public void setQuantité(int quantité) {
		this.quantité = quantité;
	}
}

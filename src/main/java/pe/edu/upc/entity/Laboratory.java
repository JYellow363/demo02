package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "laboratory")
public class Laboratory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idLaboratory;

	@Column(name = "nameLaboratory", nullable = false, length = 45)
	private String nameLaboratory;
	@Column(name = "adressLaboratory", nullable = false, length = 45)
	private String adressLaboratory;
	private Date birthdateLaboratory;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adressLaboratory == null) ? 0 : adressLaboratory.hashCode());
		result = prime * result + ((birthdateLaboratory == null) ? 0 : birthdateLaboratory.hashCode());
		result = prime * result + idLaboratory;
		result = prime * result + ((nameLaboratory == null) ? 0 : nameLaboratory.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laboratory other = (Laboratory) obj;
		if (adressLaboratory == null) {
			if (other.adressLaboratory != null)
				return false;
		} else if (!adressLaboratory.equals(other.adressLaboratory))
			return false;
		if (birthdateLaboratory == null) {
			if (other.birthdateLaboratory != null)
				return false;
		} else if (!birthdateLaboratory.equals(other.birthdateLaboratory))
			return false;
		if (idLaboratory != other.idLaboratory)
			return false;
		if (nameLaboratory == null) {
			if (other.nameLaboratory != null)
				return false;
		} else if (!nameLaboratory.equals(other.nameLaboratory))
			return false;
		return true;
	}

	public Laboratory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laboratory(int idLaboratory, String nameLaboratory, String adressLaboratory, Date birthdateLaboratory) {
		super();
		this.idLaboratory = idLaboratory;
		this.nameLaboratory = nameLaboratory;
		this.adressLaboratory = adressLaboratory;
		this.birthdateLaboratory = birthdateLaboratory;
	}

	public int getIdLaboratory() {
		return idLaboratory;
	}

	public void setIdLaboratory(int idLaboratory) {
		this.idLaboratory = idLaboratory;
	}

	public String getNameLaboratory() {
		return nameLaboratory;
	}

	public void setNameLaboratory(String nameLaboratory) {
		this.nameLaboratory = nameLaboratory;
	}

	public String getAdressLaboratory() {
		return adressLaboratory;
	}

	public void setAdressLaboratory(String adressLaboratory) {
		this.adressLaboratory = adressLaboratory;
	}

	public Date getBirthdateLaboratory() {
		return birthdateLaboratory;
	}

	public void setBirthdateLaboratory(Date birthdateLaboratory) {
		this.birthdateLaboratory = birthdateLaboratory;
	}

}

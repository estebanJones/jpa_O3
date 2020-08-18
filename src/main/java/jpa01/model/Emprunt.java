package jpa01.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emprunt")
public class Emprunt {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="DATE_DEBUT", nullable=false)
	private String dateDebut;
	
	@Column(name="DELAI", length=10, nullable=true)
	private int delai;
	
	@Column(name="DATE_FIN", nullable=true)
	private String dateFin;

	@ManyToOne
	@JoinColumn(name="ID_CLIENT", nullable=false)
	private Client clientId;
	
	@ManyToMany
	@JoinTable(name="compo", joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID"),
							 inverseJoinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID")
	)
	private Set<Livre> livres;
	
	
	Emprunt() {	
	}
	
	public Client getClient() {
		return clientId;
	}

	public void setClient(Client client) {
		this.clientId = client;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}
	
	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	@Override
	public String toString() {
		return "[" + this.id + "]";
	}
}

package tn.iit.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Enseignement")
public class Enseignement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBase")
	private Integer id;

	@Column(name = "nom_ensi")
	private String nom;
	
	@Column(name = "date")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name = "mailsend")
	private boolean mailsend;

	@ManyToOne
	@JoinColumn(name = "COD_enseig")
	private Enseignant enseignant;

	@ManyToOne
	@JoinColumn(name = "COD_matiere")
	private Matiere matiere;

	@ManyToOne
	@JoinColumn(name = "cod_jour")
	private Jours jours;
	

	@ManyToOne
	@JoinColumn
	private Dep dep;

	@ManyToOne
	@JoinColumn(name = "cod_seance")
	private Seances seances;

	@ManyToOne
	@JoinColumn(name = "cod_niveaux")
	private Niveaux niveaux;

	@ManyToOne
	@JoinColumn(name = "cod_salle")
	private Salle salle;

	
	
	public boolean getMailsend() {
		return mailsend;
	}

	public void setMailsend(boolean mailsend) {
		this.mailsend = mailsend;
	}

	public Enseignement() {
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	

	public Jours getJours() {
		return jours;
	}

	public void setJours(Jours jours) {
		this.jours = jours;
	}

	public Dep getDep() {
		return dep;
	}

	public void setDep(Dep dep) {
		this.dep = dep;
	}

	public Seances getSeances() {
		return seances;
	}

	public void setSeances(Seances seances) {
		this.seances = seances;
	}

	public Niveaux getNiveaux() {
		return niveaux;
	}

	public void setNiveaux(Niveaux niveaux) {
		this.niveaux = niveaux;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Enseignement other = (Enseignement) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestWebBoca;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a.camberabero
 */
@Entity
@Table(name = "UTILISATEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u")
    , @NamedQuery(name = "Utilisateur.findByIdclient", query = "SELECT u FROM Utilisateur u WHERE u.idclient = :idclient")
    , @NamedQuery(name = "Utilisateur.findByEmail", query = "SELECT u FROM Utilisateur u WHERE u.email = :email")
    , @NamedQuery(name = "Utilisateur.findByMotdepasse", query = "SELECT u FROM Utilisateur u WHERE u.motdepasse = :motdepasse")
    , @NamedQuery(name = "Utilisateur.findByNom", query = "SELECT u FROM Utilisateur u WHERE u.nom = :nom")
    , @NamedQuery(name = "Utilisateur.findByPrenom", query = "SELECT u FROM Utilisateur u WHERE u.prenom = :prenom")})
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDCLIENT")
    private Long idclient;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "MOTDEPASSE")
    private String motdepasse;
    @Column(name = "NOM")
    private String nom;
    @Column(name = "PRENOM")
    private String prenom;
    @ManyToMany(mappedBy = "utilisateurCollection")
    private Collection<Comptebancaire> comptebancaireCollection;

    public Utilisateur() {
    }

    public Utilisateur(Long idclient) {
        this.idclient = idclient;
    }

    public Long getIdclient() {
        return idclient;
    }

    public void setIdclient(Long idclient) {
        this.idclient = idclient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @XmlTransient
    public Collection<Comptebancaire> getComptebancaireCollection() {
        return comptebancaireCollection;
    }

    public void setComptebancaireCollection(Collection<Comptebancaire> comptebancaireCollection) {
        this.comptebancaireCollection = comptebancaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestWebBoca.Utilisateur[ idclient=" + idclient + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestWebBoca;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
@Table(name = "COMPTEBANCAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comptebancaire.findAll", query = "SELECT c FROM Comptebancaire c")
    , @NamedQuery(name = "Comptebancaire.findById", query = "SELECT c FROM Comptebancaire c WHERE c.id = :id")
    , @NamedQuery(name = "Comptebancaire.findByIduser", query = "SELECT c FROM Comptebancaire c WHERE c.iduser = :iduser")
    , @NamedQuery(name = "Comptebancaire.findByIntitule", query = "SELECT c FROM Comptebancaire c WHERE c.intitule = :intitule")
    , @NamedQuery(name = "Comptebancaire.findBySolde", query = "SELECT c FROM Comptebancaire c WHERE c.solde = :solde")})
public class Comptebancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "IDUSER")
    private BigInteger iduser;
    @Column(name = "INTITULE")
    private String intitule;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SOLDE")
    private Double solde;
    @JoinTable(name = "UTILISATEUR_COMPTEBANCAIRE", joinColumns = {
        @JoinColumn(name = "LISTECOMPTES_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "UTILISATEUR_IDCLIENT", referencedColumnName = "IDCLIENT")})
    @ManyToMany
    private Collection<Utilisateur> utilisateurCollection;
    @JoinTable(name = "COMPTEBANCAIRE_OPERATIONBANCAIRE", joinColumns = {
        @JoinColumn(name = "COMPTEBANCAIRE_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "LISTEOPERATIONS_ID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Operationbancaire> operationbancaireCollection;

    public Comptebancaire() {
    }

    public Comptebancaire(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getIduser() {
        return iduser;
    }

    public void setIduser(BigInteger iduser) {
        this.iduser = iduser;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    @XmlTransient
    public Collection<Utilisateur> getUtilisateurCollection() {
        return utilisateurCollection;
    }

    public void setUtilisateurCollection(Collection<Utilisateur> utilisateurCollection) {
        this.utilisateurCollection = utilisateurCollection;
    }

    @XmlTransient
    public Collection<Operationbancaire> getOperationbancaireCollection() {
        return operationbancaireCollection;
    }

    public void setOperationbancaireCollection(Collection<Operationbancaire> operationbancaireCollection) {
        this.operationbancaireCollection = operationbancaireCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comptebancaire)) {
            return false;
        }
        Comptebancaire other = (Comptebancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestWebBoca.Comptebancaire[ id=" + id + " ]";
    }
    
}

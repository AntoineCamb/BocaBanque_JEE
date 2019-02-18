/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestWebBoca;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author a.camberabero
 */
@Entity
@Table(name = "OPERATIONBANCAIRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Operationbancaire.findAll", query = "SELECT o FROM Operationbancaire o")
    , @NamedQuery(name = "Operationbancaire.findById", query = "SELECT o FROM Operationbancaire o WHERE o.id = :id")
    , @NamedQuery(name = "Operationbancaire.findByDateoperation", query = "SELECT o FROM Operationbancaire o WHERE o.dateoperation = :dateoperation")
    , @NamedQuery(name = "Operationbancaire.findByDescription", query = "SELECT o FROM Operationbancaire o WHERE o.description = :description")
    , @NamedQuery(name = "Operationbancaire.findByIdcompte", query = "SELECT o FROM Operationbancaire o WHERE o.idcompte = :idcompte")
    , @NamedQuery(name = "Operationbancaire.findByMontant", query = "SELECT o FROM Operationbancaire o WHERE o.montant = :montant")
    , @NamedQuery(name = "Operationbancaire.findByTypeoperation", query = "SELECT o FROM Operationbancaire o WHERE o.typeoperation = :typeoperation")})
public class Operationbancaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "DATEOPERATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateoperation;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "IDCOMPTE")
    private BigInteger idcompte;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MONTANT")
    private Double montant;
    @Column(name = "TYPEOPERATION")
    private Integer typeoperation;
    @ManyToMany(mappedBy = "operationbancaireCollection")
    private Collection<Comptebancaire> comptebancaireCollection;

    public Operationbancaire() {
    }

    public Operationbancaire(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateoperation() {
        return dateoperation;
    }

    public void setDateoperation(Date dateoperation) {
        this.dateoperation = dateoperation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigInteger getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(BigInteger idcompte) {
        this.idcompte = idcompte;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Integer getTypeoperation() {
        return typeoperation;
    }

    public void setTypeoperation(Integer typeoperation) {
        this.typeoperation = typeoperation;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operationbancaire)) {
            return false;
        }
        Operationbancaire other = (Operationbancaire) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RestWebBoca.Operationbancaire[ id=" + id + " ]";
    }
    
}

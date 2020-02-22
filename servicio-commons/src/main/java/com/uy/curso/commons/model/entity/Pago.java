/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uy.curso.commons.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Eros
 */
@Entity
@Table(name = "pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pago.findAll", query = "SELECT p FROM Pago p"),
    @NamedQuery(name = "Pago.findByIdPago", query = "SELECT p FROM Pago p WHERE p.idPago = :idPago"),
    @NamedQuery(name = "Pago.findByMonto", query = "SELECT p FROM Pago p WHERE p.monto = :monto"),
    @NamedQuery(name = "Pago.findByTipoFormaPago", query = "SELECT p FROM Pago p WHERE p.tipoFormaPago = :tipoFormaPago"),
    @NamedQuery(name = "Pago.findByPagoParcial", query = "SELECT p FROM Pago p WHERE p.pagoParcial = :pagoParcial"),
    @NamedQuery(name = "Pago.findByVersion", query = "SELECT p FROM Pago p WHERE p.version = :version"),
    @NamedQuery(name = "Pago.findByDeleted", query = "SELECT p FROM Pago p WHERE p.deleted = :deleted")})
public class Pago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Float monto;
    @Column(name = "tipo_forma_pago")
    private String tipoFormaPago;
    @Column(name = "pago_parcial")
    private String pagoParcial;
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @Basic(optional = false)
    @Column(name = "deleted")
    private int deleted;
    @JoinColumn(name = "id_asignacion", referencedColumnName = "id_asignacion")
    @ManyToOne
    private Asignacion idAsignacion;

    public Pago() {
    }

    public Pago(Integer idPago) {
        this.idPago = idPago;
    }

    public Pago(Integer idPago, int version, int deleted) {
        this.idPago = idPago;
        this.version = version;
        this.deleted = deleted;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public String getTipoFormaPago() {
        return tipoFormaPago;
    }

    public void setTipoFormaPago(String tipoFormaPago) {
        this.tipoFormaPago = tipoFormaPago;
    }

    public String getPagoParcial() {
        return pagoParcial;
    }

    public void setPagoParcial(String pagoParcial) {
        this.pagoParcial = pagoParcial;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Asignacion getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Asignacion idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pago)) {
            return false;
        }
        Pago other = (Pago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uy.curso.commons.model.entity.Pago[ idPago=" + idPago + " ]";
    }
    
}

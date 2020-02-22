/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uy.curso.commons.model.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eros
 */
@Entity
@Table(name = "asignacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asignacion.findAll", query = "SELECT a FROM Asignacion a"),
    @NamedQuery(name = "Asignacion.findByIdAsignacion", query = "SELECT a FROM Asignacion a WHERE a.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "Asignacion.findByFechaInicio", query = "SELECT a FROM Asignacion a WHERE a.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Asignacion.findByFechaTermino", query = "SELECT a FROM Asignacion a WHERE a.fechaTermino = :fechaTermino"),
    @NamedQuery(name = "Asignacion.findByHorario", query = "SELECT a FROM Asignacion a WHERE a.horario = :horario"),
    @NamedQuery(name = "Asignacion.findByPrecioAlumno", query = "SELECT a FROM Asignacion a WHERE a.precioAlumno = :precioAlumno"),
    @NamedQuery(name = "Asignacion.findByTipoCuota", query = "SELECT a FROM Asignacion a WHERE a.tipoCuota = :tipoCuota"),
    @NamedQuery(name = "Asignacion.findByTipoEsquema", query = "SELECT a FROM Asignacion a WHERE a.tipoEsquema = :tipoEsquema"),
    @NamedQuery(name = "Asignacion.findByTipoPromocion", query = "SELECT a FROM Asignacion a WHERE a.tipoPromocion = :tipoPromocion"),
    @NamedQuery(name = "Asignacion.findByTipoDescuento", query = "SELECT a FROM Asignacion a WHERE a.tipoDescuento = :tipoDescuento"),
    @NamedQuery(name = "Asignacion.findByTipoMetodologia", query = "SELECT a FROM Asignacion a WHERE a.tipoMetodologia = :tipoMetodologia"),
    @NamedQuery(name = "Asignacion.findByFechaPagoInicial", query = "SELECT a FROM Asignacion a WHERE a.fechaPagoInicial = :fechaPagoInicial"),
    @NamedQuery(name = "Asignacion.findByEquipoComputo", query = "SELECT a FROM Asignacion a WHERE a.equipoComputo = :equipoComputo"),
    @NamedQuery(name = "Asignacion.findByVersion", query = "SELECT a FROM Asignacion a WHERE a.version = :version"),
    @NamedQuery(name = "Asignacion.findByDeleted", query = "SELECT a FROM Asignacion a WHERE a.deleted = :deleted")})
public class Asignacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;
    @Column(name = "fecha_termino")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaTermino;
    @Column(name = "horario")
    private String horario;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_alumno")
    private Float precioAlumno;
    @Column(name = "tipo_cuota")
    private String tipoCuota;
    @Column(name = "tipo_esquema")
    private String tipoEsquema;
    @Column(name = "tipo_promocion")
    private String tipoPromocion;
    @Column(name = "tipo_descuento")
    private String tipoDescuento;
    @Column(name = "tipo_metodologia")
    private String tipoMetodologia;
    @Column(name = "fecha_pago_inicial")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPagoInicial;
    @Column(name = "equipo_computo")
    private Short equipoComputo;
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @Basic(optional = false)
    @Column(name = "deleted")
    private int deleted;
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    @ManyToOne
    private Alumno idAlumno;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso")
    @ManyToOne
    private Curso idCurso;
    @JoinColumn(name = "id_sucursal", referencedColumnName = "id_sucursal")
    @ManyToOne
    private Sucursal idSucursal;
    @OneToMany(mappedBy = "idAsignacion")
    private List<Pago> pagoList;

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Asignacion(Integer idAsignacion, int version, int deleted) {
        this.idAsignacion = idAsignacion;
        this.version = version;
        this.deleted = deleted;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Float getPrecioAlumno() {
        return precioAlumno;
    }

    public void setPrecioAlumno(Float precioAlumno) {
        this.precioAlumno = precioAlumno;
    }

    public String getTipoCuota() {
        return tipoCuota;
    }

    public void setTipoCuota(String tipoCuota) {
        this.tipoCuota = tipoCuota;
    }

    public String getTipoEsquema() {
        return tipoEsquema;
    }

    public void setTipoEsquema(String tipoEsquema) {
        this.tipoEsquema = tipoEsquema;
    }

    public String getTipoPromocion() {
        return tipoPromocion;
    }

    public void setTipoPromocion(String tipoPromocion) {
        this.tipoPromocion = tipoPromocion;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public String getTipoMetodologia() {
        return tipoMetodologia;
    }

    public void setTipoMetodologia(String tipoMetodologia) {
        this.tipoMetodologia = tipoMetodologia;
    }

    public Date getFechaPagoInicial() {
        return fechaPagoInicial;
    }

    public void setFechaPagoInicial(Date fechaPagoInicial) {
        this.fechaPagoInicial = fechaPagoInicial;
    }

    public Short getEquipoComputo() {
        return equipoComputo;
    }

    public void setEquipoComputo(Short equipoComputo) {
        this.equipoComputo = equipoComputo;
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

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Curso getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Curso idCurso) {
        this.idCurso = idCurso;
    }

    public Sucursal getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(Sucursal idSucursal) {
        this.idSucursal = idSucursal;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignacion)) {
            return false;
        }
        Asignacion other = (Asignacion) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uy.curso.commons.model.entity.Asignacion[ idAsignacion=" + idAsignacion + " ]";
    }
    
}

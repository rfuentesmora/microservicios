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
@Table(name = "instructor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Instructor.findAll", query = "SELECT i FROM Instructor i"),
    @NamedQuery(name = "Instructor.findByIdInstructor", query = "SELECT i FROM Instructor i WHERE i.idInstructor = :idInstructor"),
    @NamedQuery(name = "Instructor.findByNombre", query = "SELECT i FROM Instructor i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Instructor.findByApellidoPaterno", query = "SELECT i FROM Instructor i WHERE i.apellidoPaterno = :apellidoPaterno"),
    @NamedQuery(name = "Instructor.findByApellidoMaterno", query = "SELECT i FROM Instructor i WHERE i.apellidoMaterno = :apellidoMaterno"),
    @NamedQuery(name = "Instructor.findByGenero", query = "SELECT i FROM Instructor i WHERE i.genero = :genero"),
    @NamedQuery(name = "Instructor.findByFechaNacimiento", query = "SELECT i FROM Instructor i WHERE i.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Instructor.findByVersion", query = "SELECT i FROM Instructor i WHERE i.version = :version"),
    @NamedQuery(name = "Instructor.findByDeleted", query = "SELECT i FROM Instructor i WHERE i.deleted = :deleted")})
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_instructor")
    private Integer idInstructor;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;
    @Column(name = "apellido_materno")
    private String apellidoMaterno;
    @Column(name = "genero")
    private String genero;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @Basic(optional = false)
    @Column(name = "deleted")
    private int deleted;
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto idContacto;
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne
    private Domicilio idDomicilio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idInstructor")
    private List<Curso> cursoList;

    public Instructor() {
    }

    public Instructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public Instructor(Integer idInstructor, String nombre, String apellidoPaterno, int version, int deleted) {
        this.idInstructor = idInstructor;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.version = version;
        this.deleted = deleted;
    }

    public Integer getIdInstructor() {
        return idInstructor;
    }

    public void setIdInstructor(Integer idInstructor) {
        this.idInstructor = idInstructor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
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

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
    }

    public Domicilio getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Domicilio idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInstructor != null ? idInstructor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Instructor)) {
            return false;
        }
        Instructor other = (Instructor) object;
        if ((this.idInstructor == null && other.idInstructor != null) || (this.idInstructor != null && !this.idInstructor.equals(other.idInstructor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.uy.curso.commons.model.entity.Instructor[ idInstructor=" + idInstructor + " ]";
    }
    
}

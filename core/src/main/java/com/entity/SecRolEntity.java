package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "sec_rol", schema = "sample", catalog = "")
public class SecRolEntity {
    private int id;
    private String rol;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "rol", nullable = true, length = 45)
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecRolEntity that = (SecRolEntity) o;

        if (id != that.id) return false;
        if (rol != null ? !rol.equals(that.rol) : that.rol != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (rol != null ? rol.hashCode() : 0);
        return result;
    }
}

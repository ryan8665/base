package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "alireza", schema = "sample", catalog = "")
public class AlirezaEntity {
    private int id;
    private String txt;
    private String password;
    private String role;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "txt", nullable = false, length = 10)
    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlirezaEntity that = (AlirezaEntity) o;

        if (id != that.id) return false;
        if (txt != null ? !txt.equals(that.txt) : that.txt != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (txt != null ? txt.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 100)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role", nullable = false, length = 100)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

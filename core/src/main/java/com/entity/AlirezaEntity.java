package com.entity;

import javax.persistence.*;

@Entity
@Table(name = "alireza")
public class AlirezaEntity {
    private int id;
    private String txt;

    @Id
    @Column(name = "id", nullable = false)
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
}

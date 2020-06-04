package com.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sec_user", schema = "sample", catalog = "")
public class SecUserEntity {
    private int id;
    private String name;
    private String family;
    private String identity;
    private String phone;
    private String cellphone;
    private String fax;
    private String address;
    private String language;
    private Timestamp createDate;
    private String createChanel;
    private Timestamp updateDate;
    private String updateChanel;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "family", nullable = true, length = 45)
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Basic
    @Column(name = "identity", nullable = true, length = 45)
    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 12)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "cellphone", nullable = true, length = 12)
    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    @Basic
    @Column(name = "fax", nullable = true, length = 45)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "language", nullable = true, length = 4)
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Basic
    @Column(name = "create_chanel", nullable = true, length = 10)
    public String getCreateChanel() {
        return createChanel;
    }

    public void setCreateChanel(String createChanel) {
        this.createChanel = createChanel;
    }

    @Basic
    @Column(name = "update_date", nullable = true)
    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "update_chanel", nullable = true, length = 10)
    public String getUpdateChanel() {
        return updateChanel;
    }

    public void setUpdateChanel(String updateChanel) {
        this.updateChanel = updateChanel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecUserEntity that = (SecUserEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (family != null ? !family.equals(that.family) : that.family != null) return false;
        if (identity != null ? !identity.equals(that.identity) : that.identity != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (cellphone != null ? !cellphone.equals(that.cellphone) : that.cellphone != null) return false;
        if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (createChanel != null ? !createChanel.equals(that.createChanel) : that.createChanel != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (updateChanel != null ? !updateChanel.equals(that.updateChanel) : that.updateChanel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (family != null ? family.hashCode() : 0);
        result = 31 * result + (identity != null ? identity.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (cellphone != null ? cellphone.hashCode() : 0);
        result = 31 * result + (fax != null ? fax.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (createChanel != null ? createChanel.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (updateChanel != null ? updateChanel.hashCode() : 0);
        return result;
    }
}

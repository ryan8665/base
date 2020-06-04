package com.entity;

import com.nsoft.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "sec_group_r_rol", schema = "sample", catalog = "")
public class SecGroupRRolEntity extends BaseEntity {
    private int id;
    private SecUserGroupEntity secUserGroupBySecUserGroupId;
    private SecRolEntity secRolBySecRolId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SecGroupRRolEntity that = (SecGroupRRolEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "sec_user_group_id", referencedColumnName = "id", nullable = false)
    public SecUserGroupEntity getSecUserGroupBySecUserGroupId() {
        return secUserGroupBySecUserGroupId;
    }

    public void setSecUserGroupBySecUserGroupId(SecUserGroupEntity secUserGroupBySecUserGroupId) {
        this.secUserGroupBySecUserGroupId = secUserGroupBySecUserGroupId;
    }

    @ManyToOne
    @JoinColumn(name = "sec_rol_id", referencedColumnName = "id", nullable = false)
    public SecRolEntity getSecRolBySecRolId() {
        return secRolBySecRolId;
    }

    public void setSecRolBySecRolId(SecRolEntity secRolBySecRolId) {
        this.secRolBySecRolId = secRolBySecRolId;
    }
}

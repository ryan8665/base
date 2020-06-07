package com.nsoft.dao;

import com.nsoft.entity.BaseEntity;


public interface BaseDao<T extends BaseEntity, PK> {

    T retrieveByPk(PK id);

    void create(T dto);

    void update(T dto);

    void delete(PK id);
}
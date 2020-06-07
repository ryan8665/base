package com.dao;

import com.entity.AlirezaEntity;
import com.entity.SecUserEntity;
import com.nsoft.dao.BaseDao;
import com.nsoft.entity.BaseEntity;
//todo
//public interface UserDao extends BaseDao<AlirezaEntity,UserDao> {
public interface UserDao {
    void persistUser(SecUserEntity user);

    AlirezaEntity findUserById(int id);

    void updateUser(AlirezaEntity user);

    void deleteUser(AlirezaEntity user);
}


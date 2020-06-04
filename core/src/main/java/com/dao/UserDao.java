package com.dao;

import com.entity.AlirezaEntity;
import com.entity.SecUserEntity;

public interface UserDao {
    void persistUser(SecUserEntity user);

    AlirezaEntity findUserById(int id);

    void updateUser(AlirezaEntity user);

    void deleteUser(AlirezaEntity user);
}


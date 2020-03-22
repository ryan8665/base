package com.dao;

import com.entity.AlirezaEntity;

public interface UserDao {
    void persistUser(AlirezaEntity user);

    AlirezaEntity findUserById(int id);

    void updateUser(AlirezaEntity user);

    void deleteUser(AlirezaEntity user);
}


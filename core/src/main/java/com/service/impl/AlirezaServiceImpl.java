package com.service.impl;

import com.dao.UserDao;
import com.entity.AlirezaEntity;
import com.service.AlirezaService;
import org.springframework.transaction.annotation.Transactional;

public class AlirezaServiceImpl implements AlirezaService {
    private UserDao alirezadao;

    public void setAlirezadao(UserDao alirezadao) {
        this.alirezadao = alirezadao;
    }


    @Transactional
    public void persistAlireza(AlirezaEntity alireza) {
        alirezadao.findUserById(1);
        alirezadao.persistUser(alireza);
    }


}

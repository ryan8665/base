package com.service.impl;

import com.dao.UserDao;
import com.entity.AlirezaEntity;
import com.service.AlirezaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlirezaServiceImpl implements AlirezaService {
    private UserDao alirezadao;

    public void setAlirezadao(UserDao alirezadao) {
        this.alirezadao = alirezadao;
    }



    public void persistAlireza(AlirezaEntity alireza) {
//        AlirezaEntity a =   alirezadao.findUserById(1);
        AlirezaEntity a =   alirezadao.findUserById(2);
        System.out.printf("aaaaaaaa" + a.getId());
        System.out.printf("aaaaaaaa" + a.getTxt());
        alirezadao.persistUser(alireza);
//        alirezadao.deleteUser(alireza);
    }


    public AlirezaEntity retrieveData(){
        return  alirezadao.findUserById(1);
    }


}

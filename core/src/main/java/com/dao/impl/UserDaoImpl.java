package com.dao.impl;

import com.dao.UserDao;
import com.entity.AlirezaEntity;
import com.entity.SecUserEntity;
import com.nsoft.entity.BaseEntity;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persistUser(SecUserEntity user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    @Override
    public AlirezaEntity findUserById(int id) {
        return (AlirezaEntity) sessionFactory.getCurrentSession().get(AlirezaEntity.class, id);
    }

    @Override
    public void updateUser(AlirezaEntity user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(AlirezaEntity user) {
        sessionFactory.getCurrentSession().delete(user);
    }


}

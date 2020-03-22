package com.dao.impl;

import com.dao.UserDao;
import com.entity.AlirezaEntity;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserDaoImpl implements UserDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persistUser(AlirezaEntity user) {
        try {
            sessionFactory.getCurrentSession().persist(user);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AlirezaEntity findUserById(int id) {
        return (AlirezaEntity) sessionFactory.getCurrentSession().get(AlirezaEntity.class, id);
    }

    @Override
    public void updateUser(AlirezaEntity user) {

    }

    @Override
    public void deleteUser(AlirezaEntity user) {

    }


}

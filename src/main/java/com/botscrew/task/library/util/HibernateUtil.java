package com.botscrew.task.library.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
    public static Session getSession(){
        SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=sessionFactory.openSession();
        return session;
    }

    public static void closeSession(Session session){
        session.close();
    }
}

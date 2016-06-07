package com.association.onetoone.annotation.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory=buildSessionFactory();
	
	private static SessionFactory buildSessionFactory(){
		try{
			return new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		}catch(Throwable e){
			throw e;
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}

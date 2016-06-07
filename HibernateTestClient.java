package com.association.onetoone.annotation.client;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.association.onetoone.annotation.model.Customer;
import com.association.onetoone.annotation.model.MyTransaction;
import com.association.onetoone.annotation.util.HibernateUtil;

/**
 * 
 * @author Anil Kumar
 * Bidirectional One-To-One association mapping using annotation
 */
public class HibernateTestClient {

	public static void main(String[] args) {
	
		Customer customer=new Customer();
		customer.setName("Anil Kumar");
		customer.setEmail("anil.kumar@gmail.com");
		customer.setAddress("BTM Layout 2nd Stage, Bangalore");

		MyTransaction transaction=new MyTransaction();
		transaction.setDate(new Date());
		transaction.setTotal(45000);
		
		transaction.setCustomer(customer);
		customer.setTransaction(transaction);

		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try{
			sessionFactory=HibernateUtil.getSessionFactory();
			session=sessionFactory.getCurrentSession();			
			tx=session.beginTransaction();
			session.save(transaction);
			//session.flush(); need this when we use openSession()			
			tx.commit();
			
		}catch(Exception e){
			if(tx!=null)tx.rollback();
			e.printStackTrace();
		}finally{
			//session.close(); need this when we use openSession();
		}
	}

}
/**
	Note: getCurrentSession() check whether session object is exist or not if it is not exist then this will create new
	session otherwise this will refer to exist session object.
	openSession() always create new instance of session.
	
	Example:
	Session session1=sessionFactory.getCurrentSession();
	Session session2=sessionFactory.getCurrentSession();
	
	System.out.println(session1==session2) => true;
	
	Session session1=sessionFactory.openSession();
	Session session2=sessionFactory.openSession();
	
	System.out.println(session1==session2) => false;
	
*/
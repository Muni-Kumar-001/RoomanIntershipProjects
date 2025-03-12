package com.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UserImplementation implements IUser{
	
	SessionFactory sf = HibernateUtil.getSessionFactory();
	Session s = sf.openSession();
	Transaction tx = s.beginTransaction();
	
	@Override
	public void register(String fName, String lName, String uName, String pswd) {
		User u = new User(fName,lName,uName,pswd);
		s.save(u);
		tx.commit();
	}

	@Override
	public boolean login(String uName, String pswd) {
		User u = s.load(User.class, 0);
		System.out.println(u);
		return false;
	}
	
}

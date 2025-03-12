package com.ecom.facebookBackend;

import java.sql.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CurdClient {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session ses = factory.openSession();
        Transaction tx = ses.beginTransaction();

        // Insert
        Scanner sc = new Scanner(System.in);
        System.out.println("***** Welcome facebook *****\n");
        
        System.out.print("Please enter your firstName :: ");
        String fName = sc.nextLine();
        
        System.out.print("Please enter your surName :: ");
        String sName = sc.nextLine();
        
        System.out.print("Please enter your date of birth (yyyy-mm-dd) :: ");
        String dob = sc.nextLine();
        
        System.out.print("Please enter your email :: ");
        String email = sc.nextLine();
        
        System.out.print("Please enter your password :: ");
        String pswd = sc.nextLine();
        
        Date d = Date.valueOf(dob);
        User u = new User(fName, sName, d, email, pswd);
        ses.save(u);
        
        tx.commit();
        ses.close();
        factory.close();
    }
}

package com.ecom.facebookBackend;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration cfg = new Configuration();
            Properties p = new Properties();
            p.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
            p.put(Environment.URL, "jdbc:mysql://localhost:3306/facebookdb");
            p.put(Environment.USER, "root");
            p.put(Environment.PASS, "root");
            p.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
            p.put(Environment.HBM2DDL_AUTO, "update");
            p.put(Environment.SHOW_SQL, "true");

            cfg.setProperties(p);
            cfg.addAnnotatedClass(User.class);
            ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
            sessionFactory = cfg.buildSessionFactory(registry);
        }
        return sessionFactory;
    }
}

package com.klef.jfsd.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ClientDemo {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        // I. Insert Records
        Client client1 = new Client();
        client1.setName("Alice");
        client1.setGender("Female");
        client1.setAge(25);
        client1.setLocation("New York");
        client1.setEmailAddress("alice@example.com");
        client1.setMobileNumber("1234567890");

        session.persist(client1);

        transaction.commit();

        // II. Fetch and Print All Records
        List<Client> clientList = session.createQuery("from Client", Client.class).list();
        for (Client client : clientList) {
            System.out.println(client);
        }

        session.close();
        sessionFactory.close();
    }
}

package com.hexaware.hibernate4.manytomany.com.hexaware.hibernate4.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args )
    {
    	UserDetails user=new UserDetails();
    	Vehicle vehicle=new Vehicle();
    	Vehicle vehicle2=new Vehicle();
    	
    	vehicle.setVehicleName("BMW");
    	vehicle2.setVehicleName("AUDI");
    	
    	user.setUserName("Shrutee");
    	
    	
    	user.getVechile().add(vehicle);
    	user.getVechile().add(vehicle2);
    	
    	SessionFactory sessionFactory=new Configuration().configure("hiber.config.xml").addAnnotatedClass(Vehicle.class).addAnnotatedClass(UserDetails.class).buildSessionFactory();
    	Session session=sessionFactory.openSession();
    	session.beginTransaction();
    	
    	session.save(vehicle);
    	session.save(vehicle2);
    	session.save(user);
    	
    	session.getTransaction().commit();
    	session.close();
        System.out.println( "Done!" );
    }
}

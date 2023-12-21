package org.sample.crud;

import org.sample.dto.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {
    public static void addEmployee(EntityManager em){
        Employee e1=new Employee(1,"dhanush");
        Employee e2=new Employee(2,"ram");
        em.getTransaction().begin();
        em.persist(e1);
        em.persist(e2);
        em.getTransaction().commit();
        System.out.println("Done!");
        em.close();
    }

    public static void findEmployee(EntityManager em){
        Employee e=em.find(Employee.class,2);
        if(e!=null){
            System.out.println(e);
        }
        else{
            System.out.println("enter valid id");
        }
    }

    public static void findallemp(EntityManager em){
        Query q=em.createQuery("select e.name from Employee e");
        List<String> list=q.getResultList();

        if(list!=null){
            list.forEach(System.out::println);
        }
        else{
            System.out.println("no employee");
        }
    }

    public static void deleteEmployee(EntityManager em){
        Employee e=em.find(Employee.class,1);
        if(e!=null){
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
            em.close();
            System.out.println("student deleted successfully");
        }
        else{
            System.out.println("enter valid id");
        }
    }

    public static void main(String[] args) {
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("empUnit");
        EntityManager em= emf.createEntityManager();
//        addEmployee(em);
//        findEmployee(em);
//        deleteEmployee(em);
        findallemp(em);
    }
}
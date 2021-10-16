/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentjpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tana_
 */
public class StudentJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student s1 = new Student(6, "sdafasdf", 2.6);
        Student s2 = new Student(7, "werwerwer", 3.5);
        StudentTable.insertStudent(s1);
        StudentTable.insertStudent(s2);

        

    }
    
    public static void printAllStudent(List<Student> studentList) {
        for(Student s : studentList) {
           System.out.print(s.getId() + " ");
           System.out.print(s.getName() + " ");
           System.out.println(s.getGpa() + " ");
       }
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudentJPAPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}

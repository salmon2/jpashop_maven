package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

    try {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hello");
        //고객의 요청이 올때마다 썻다가 버렸다가. 쓰레드간 공유 절대 안됨
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
    }
    catch(Exception e){
        tx.rollback();
    }finally {
        em.close();
    }


    }
}

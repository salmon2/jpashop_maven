package main;

import domain.Order;
import domain.OrderItem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hello");
        //고객의 요청이 올때마다 썻다가 버렸다가. 쓰레드간 공유 절대 안됨
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Order order = new Order();
            em.persist(order);

            OrderItem orderItem =  new OrderItem();
            orderItem.setOrder(order);
            em.persist(orderItem);

            System.out.println("=======");
            tx.commit();
        }
        catch(Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
    }
}

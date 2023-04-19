package dao;

import javax.persistence.*;

import model.Restaurante;

public class RestauranteDAO {
    private EntityManagerFactory emf;

    public RestauranteDAO() {
        emf = Persistence.createEntityManagerFactory("mysqltest");
    }

    public void create(Restaurante restaurant) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(restaurant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    public Restaurante read(long id) {
        EntityManager em = emf.createEntityManager();
        Restaurante restaurant = null;
        try {
            restaurant = em.find(Restaurante.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return restaurant;
    }

    public void update(Restaurante restaurant) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(restaurant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    public void delete(Restaurante restaurant) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            restaurant = em.merge(restaurant);
            em.remove(restaurant);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

}

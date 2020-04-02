package repository;

import entity.GoodsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class GoodsRepository {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("myUnit");
    private EntityManager em = emf.createEntityManager();

    public void create(GoodsEntity goods) {
        em.getTransaction().begin();
        em.persist(goods);
        em.getTransaction().commit();
    }

    public GoodsEntity read(int id) {
        em.getTransaction().begin();
        GoodsEntity goods = em.find(GoodsEntity.class, id);
        em.getTransaction().commit();
        return goods;
    }

    public void update(GoodsEntity goods) {
        em.getTransaction().begin();
        goods = em.merge(goods);
        em.getTransaction().commit();
    }

    public void delete(GoodsEntity goods) {
        em.getTransaction();
        em.remove(goods);
        em.getTransaction().commit();
    }

    public void close() {
        emf.close();
    }
}

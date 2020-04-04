package repository;

import entity.GoodsEntity;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class GoodsRepository {

//    @PersistenceUnit(unitName = "myUnit")
//    private EntityManagerFactory emf;
//
//    private EntityManager em = emf.createEntityManager();

    @PersistenceContext(name = "myUnit")
    private EntityManager em;

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

//    public void close() {
//        emf.close();
//    }
}

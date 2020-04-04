package repository;

import entity.GoodsEntity;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless
public class GoodsRepository {

    @PersistenceContext(name = "myUnit")
    private EntityManager em;

    public void create(GoodsEntity goods) {
        em.persist(goods);
    }

    public GoodsEntity read(int id) {
        GoodsEntity goods = em.find(GoodsEntity.class, id);
        return goods;
    }

    public void update(GoodsEntity goods) {
        goods = em.merge(goods);
    }

    public void delete(GoodsEntity goods) {
        em.remove(goods);
    }
}

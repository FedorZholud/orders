package service;

import entity.GoodsEntity;
import repository.GoodsRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class GoodsService {

    int id;
    String name;
    double price;

    @EJB
    GoodsRepository goodsRepository;
//    @EJB
//    GoodsRepositoryImpl goodsRepository;

    public String writeSomething(int id) {
        GoodsEntity goods = goodsRepository.read(id);

        this.id = goods.getId();
        this.name = goods.getName();
        this.price = goods.getPrice();

        String string = "Goods: id-" + this.id + " name-" + this.name + " price-" + this.price;

        return string;
    }

    public String writeSomethingNew() {
        List<GoodsEntity> goods = goodsRepository.findAll();

        String string = "";

        for (int i = 0; i < goods.size(); i++) {
            if (i == 1) {
                this.id = goods.get(i).getId();
                this.name = goods.get(i).getName();
                this.price = goods.get(i).getPrice();

                string = "Goods: id-" + this.id + " name-" + this.name + " price-" + this.price;
            }
        }

        return string;
    }
}
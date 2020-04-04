import entity.GoodsEntity;
import repository.GoodsRepository;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/goods")
public class App extends HttpServlet {

    @EJB
    GoodsRepository goodsRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsEntity goods;

        goods = goodsRepository.read(1);
        int id = goods.getId();
        String name = goods.getName();
        double price = goods.getPrice();

        resp.getWriter().println("Hello from servlet");
        resp.getWriter().println("Goods: id-" + id + " name-" + name + " price-" + price);
    }
}

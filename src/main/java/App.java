import entity.GoodsEntity;
import repository.GoodsRepository;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        GoodsRepository repository = null;
        try {
            repository = new GoodsRepository();
            GoodsEntity goods = new GoodsEntity();

            goods = repository.read(1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (repository != null)
                repository.close();
        }
    }
}

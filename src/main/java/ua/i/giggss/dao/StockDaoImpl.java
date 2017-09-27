package ua.i.giggss.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.i.giggss.model.Stock;

import java.util.Collections;
import java.util.List;

@Repository
public class StockDaoImpl implements StockDao {
    private static final Logger logger = LoggerFactory.getLogger(StockDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStock(Stock stock) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(stock);
        logger.info("Stock successfully saved. Stock details: " + stock);
    }

    @Override
    public void updateStock(Stock stock) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(stock);
        logger.info("Stock successfully update. Stock details: " + stock);
    }

    @Override
    public void removeStock(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Stock stock = (Stock) session.load(Stock.class, new Integer(id));

        if (stock != null) {
            session.delete(stock);
        }
        logger.info("Stock successfully removed. Stock details: " + stock);
    }

    @Override
    public Stock getStockById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Stock stock = (Stock) session.load(Stock.class, new Integer(id));
        logger.info("Stock successfully loaded. Stock details: " + stock);

        return stock;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Stock> listStock() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Stock> stockList = session.createQuery("from Stock").list();
//        Collections.sort(workerList, Worker.COMPARE_BY_WORKER_ID);
        for(Stock stock: stockList){
            logger.info("Stock list: " + stock);
        }

        return stockList;
    }
}

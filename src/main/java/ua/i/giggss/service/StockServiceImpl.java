package ua.i.giggss.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.i.giggss.dao.StockDao;
import ua.i.giggss.model.Stock;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {
    private StockDao stockDao;

    public void setStockDao(StockDao stockDao) {
        this.stockDao = stockDao;
    }

    @Override
    @Transactional
    public void addStock(Stock stock) {
        this.stockDao.addStock(stock);
    }

    @Override
    @Transactional
    public void updateStock(Stock stock) {
        this.stockDao.updateStock(stock);
    }

    @Override
    @Transactional
    public void removeStock(int id) {
        this.stockDao.removeStock(id);
    }

    @Override
    @Transactional
    public Stock getStockById(int id) {
        return this.stockDao.getStockById(id);
    }

    @Override
    @Transactional
    public List<Stock> listStock() {
        return this.stockDao.listStock();
    }
}

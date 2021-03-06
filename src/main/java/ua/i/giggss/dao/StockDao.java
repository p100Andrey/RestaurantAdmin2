package ua.i.giggss.dao;

import ua.i.giggss.model.Stock;

import java.util.List;

public interface StockDao {
    public void addStock(Stock stock);

    public void updateStock(Stock stock);

    public void removeStock(int id);

    public Stock getStockById(int id);

    public List<Stock> listStock();
}
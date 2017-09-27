package ua.i.giggss.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.i.giggss.dao.OrderDao;
import ua.i.giggss.model.Order;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    @Transactional
    public void addOrder(Order order) {
        this.orderDao.addOrder(order);
    }

    @Override
    @Transactional
    public void updateOrder(Order order) {
        this.orderDao.updateOrder(order);
    }

    @Override
    @Transactional
    public void removeOrder(int id) {
        this.orderDao.removeOrder(id);
    }

    @Override
    @Transactional
    public Order getOrderById(int id) {
        return this.orderDao.getOrderById(id);
    }

    @Override
    @Transactional
    public List<Order> listOrder() {
        return this.orderDao.listOrder();
    }
}

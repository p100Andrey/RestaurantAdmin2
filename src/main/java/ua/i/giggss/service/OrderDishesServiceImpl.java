package ua.i.giggss.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.i.giggss.dao.OrderDishesDao;
import ua.i.giggss.model.OrderDishes;

import java.util.List;

@Service
public class OrderDishesServiceImpl implements OrderDishesService{
    private OrderDishesDao orderDishesDao;

    public void setOrderDishesDao(OrderDishesDao orderDishesDao) {
        this.orderDishesDao = orderDishesDao;
    }

    @Override
    @Transactional
    public void addOrderDishes(OrderDishes orderDishes) {
        this.orderDishesDao.addOrderDishes(orderDishes);
    }

    @Override
    @Transactional
    public void updateOrderDishes(OrderDishes orderDishes) {
        this.orderDishesDao.updateOrderDishes(orderDishes);
    }

    @Override
    @Transactional
    public void removeOrderDishes(int id) {
        this.orderDishesDao.removeOrderDishes(id);
    }

    @Override
    @Transactional
    public OrderDishes getOrderDishesById(int id) {
        return this.orderDishesDao.getOrderDishesById(id);
    }

    @Override
    @Transactional
    public List<OrderDishes> listOrderDishes() {
        return this.orderDishesDao.listOrderDishes();
    }
}

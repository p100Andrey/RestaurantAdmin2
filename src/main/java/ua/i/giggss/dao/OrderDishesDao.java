package ua.i.giggss.dao;

import ua.i.giggss.model.OrderDishes;

import java.util.List;

public interface OrderDishesDao {
    public void addOrderDishes(OrderDishes orderDishes);

    public void updateOrderDishes(OrderDishes orderDishes);

    public void removeOrderDishes(int id);

    public OrderDishes getOrderDishesById(int id);

    public List<OrderDishes> listOrderDishes();
}

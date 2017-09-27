package ua.i.giggss.service;

import ua.i.giggss.model.OrderDishes;

import java.util.List;

public interface OrderDishesService {
    public void addOrderDishes(OrderDishes orderDishes);

    public void updateOrderDishes(OrderDishes orderDishes);

    public void removeOrderDishes(int id);

    public OrderDishes getOrderDishesById(int id);

    public List<OrderDishes> listOrderDishes();
}
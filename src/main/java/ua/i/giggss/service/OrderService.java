package ua.i.giggss.service;

import ua.i.giggss.model.Order;

import java.util.List;

public interface OrderService {
    public void addOrder(Order order);

    public void updateOrder(Order order);

    public void removeOrder(int id);

    public Order getOrderById(int id);

    public List<Order> listOrder();
}
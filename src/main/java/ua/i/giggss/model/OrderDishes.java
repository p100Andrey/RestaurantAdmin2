package ua.i.giggss.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orderdishes")
public class OrderDishes {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderDishesId;

    @Column(name = "orderid")
    private int orderId;

    @Column(name = "dishid")
    private int dishId;

    public int getOrderDishesId() {
        return orderDishesId;
    }

    public void setOrderDishesId(int orderDishesId) {
        this.orderDishesId = orderDishesId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDishId() {
        return dishId;
    }

    public void setDishId(int dishId) {
        this.dishId = dishId;
    }

    @Override
    public String toString() {
        return "OrderDishes{" +
                "orderDishesId=" + orderDishesId +
                ", orderId=" + orderId +
                ", dishId=" + dishId +
                '}';
    }
}
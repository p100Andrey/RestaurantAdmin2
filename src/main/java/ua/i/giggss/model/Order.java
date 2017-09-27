package ua.i.giggss.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "orderid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    @Column(name = "waiter")
    private int waiter;

    @Column(name = "tablenumber")
    private int tableNumber;

    @Column(name = "date")
    private Date date;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getWaiter() {
        return waiter;
    }

    public void setWaiter(int waiter) {
        this.waiter = waiter;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", waiter=" + waiter +
                ", tableNumber='" + tableNumber + '\'' +
                ", date=" + date +
                '}';
    }
}

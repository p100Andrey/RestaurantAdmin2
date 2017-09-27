package ua.i.giggss.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ua.i.giggss.model.OrderDishes;

import java.util.List;

@Repository
public class OrderDishesDaoImpl implements OrderDishesDao{
    private static final Logger logger = LoggerFactory.getLogger(OrderDishesDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrderDishes(OrderDishes orderDishes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(orderDishes);
        logger.info("OrderDishes successfully saved. OrderDishes details: " + orderDishes);
    }

    @Override
    public void updateOrderDishes(OrderDishes orderDishes) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(orderDishes);
        logger.info("OrderDishes successfully update. OrderDishes details: " + orderDishes);
    }

    @Override
    public void removeOrderDishes(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        OrderDishes orderDishes = (OrderDishes) session.load(OrderDishes.class, new Integer(id));

        if (orderDishes != null) {
            session.delete(orderDishes);
        }
        logger.info("OrderDishes successfully removed. OrderDishes details: " + orderDishes);
    }

    @Override
    public OrderDishes getOrderDishesById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        OrderDishes orderDishes = (OrderDishes) session.load(OrderDishes.class, new Integer(id));
        logger.info("OrderDishes successfully loaded. OrderDishes details: " + orderDishes);

        return orderDishes;
    }

    @Override
        @SuppressWarnings("unchecked")
        public List<OrderDishes> listOrderDishes() {
            Session session = this.sessionFactory.getCurrentSession();
            List<OrderDishes> orderDishesList = session.createQuery("from OrderDishes").list();
//        Collections.sort(workerList, Worker.COMPARE_BY_ORDERDISHES_ID);
            for(OrderDishes orderDishes: orderDishesList){
                logger.info("OrderDishes list: " + orderDishes);
            }

            return orderDishesList;
    }
}

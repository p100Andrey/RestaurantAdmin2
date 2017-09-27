package ua.i.giggss.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import ua.i.giggss.model.Dish;
import ua.i.giggss.model.Order;
import ua.i.giggss.model.OrderDishes;
import ua.i.giggss.model.Worker;
import ua.i.giggss.service.DishService;
import ua.i.giggss.service.OrderDishesService;
import ua.i.giggss.service.OrderService;
import ua.i.giggss.service.WorkerService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {

    @Mock
    private OrderService orderService;
    @Mock
    private DishService dishService;
    @Mock
    private WorkerService workerService;
    @Mock
    private OrderDishesService orderDishesService;

    @InjectMocks
    private OrderController orderController;

    private Model model;

    @Before
    public void setUp() throws Exception {
        model = new ExtendedModelMap();
    }

    @Test
    public void testListOrder() throws Exception {
        List<Order> expectedOrders = asList();
        List<Dish> expectedDish = asList();
        List<OrderDishes> expectedOrderDishes = asList();
        List<Worker> expectedWorker = asList();
        when(orderService.listOrder()).thenReturn(expectedOrders);
        when(dishService.listDishes()).thenReturn(expectedDish);
        when(orderDishesService.listOrderDishes()).thenReturn(expectedOrderDishes);
        when(workerService.listWorkers()).thenReturn(expectedWorker);
        assertEquals("order", orderController.listOrder(model));
        assertSame(expectedOrders, model.asMap().get("listOrder"));
        assertSame(expectedDish, model.asMap().get("listDishes"));
        assertSame(expectedOrderDishes, model.asMap().get("listOrderDishes"));
        assertSame(expectedWorker, model.asMap().get("listWorkers"));
    }

    @Test
    public void addOrder() throws Exception {
        Order order = new Order();
        String result = orderController.addOrder(order);
        assertEquals("redirect:/order", result);
    }

}
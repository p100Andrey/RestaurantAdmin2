package ua.i.giggss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.i.giggss.model.Dish;
import ua.i.giggss.model.Order;
import ua.i.giggss.model.OrderDishes;
import ua.i.giggss.model.Worker;
import ua.i.giggss.service.DishService;
import ua.i.giggss.service.OrderDishesService;
import ua.i.giggss.service.OrderService;
import ua.i.giggss.service.WorkerService;

@Controller
public class OrderController {

    private WorkerService workerService;

    @Autowired(required = true)
    @Qualifier(value = "workerService")
    public void setWorkerService(WorkerService workerService) {
        this.workerService = workerService;
    }

    private OrderDishesService orderDishesService;

    @Autowired(required = true)
    @Qualifier(value = "orderDishesService")
    public void setOrderDishesService(OrderDishesService orderDishesService) {
        this.orderDishesService = orderDishesService;
    }

    private DishService dishService;

    @Autowired(required = true)
    @Qualifier(value = "dishService")
    public void setDishService(DishService dishService) {
        this.dishService = dishService;
    }

    private OrderService orderService;

    @Autowired(required = true)
    @Qualifier(value = "orderService")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    // формерую полный список
    @RequestMapping(value = "order", method = RequestMethod.GET)
    public String listOrder(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("listOrder", this.orderService.listOrder());

        model.addAttribute("dish", new Dish());
        model.addAttribute("listDishes", this.dishService.listDishes());

        model.addAttribute("orderdishes", new OrderDishes());
        model.addAttribute("listOrderDishes", this.orderDishesService.listOrderDishes());

        model.addAttribute("worker", new Worker());
        model.addAttribute("listWorkers", this.workerService.listWorkers());

        return "order";
    }

//    @RequestMapping("/orderremove/{id}")
//    public String removeOrder(@PathVariable("id") int id) {
//        Order order = new Order();
//        order.setOrderId(id);
//        order.setWaiter(0);
//        order.setTableNumber(0);
//        order.setDate(null);
//        this.orderService.updateOrder(order);
//
//        return "redirect:/order";
//    }

//    @RequestMapping("orderedit/{id}")
//    public String editOrder(@PathVariable("id") int id, Model model) {
//        model.addAttribute("order", this.orderService.getOrderById(id));
//        model.addAttribute("listOrder", this.orderService.listOrder());
//
//        return "order";
//    }

    @RequestMapping(value = "/order/add", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order) {
        if (order.getOrderId() == 0) {
            this.orderService.addOrder(order);
        } else {
            this.orderService.updateOrder(order);
        }

        return "redirect:/order";
    }
}

//package ua.i.giggss.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import ua.i.giggss.model.OrderDishes;
//import ua.i.giggss.service.OrderDishesService;
//
//@Controller
//public class OrderDishesController {

//    private OrderDishesService orderDishesService;
//
//    @Autowired(required = true)
//    @Qualifier(value = "orderDishesService")
//    public void setOrderDishesService(OrderDishesService orderDishesService) {
//        this.orderDishesService = orderDishesService;
//    }
//
//    // формерую полный список
//    @RequestMapping(value = "orderdishes", method = RequestMethod.GET)
//    public String listOrderDishes(Model model) {
//        model.addAttribute("orderdishes", new OrderDishes());
//        model.addAttribute("listorderdishes", this.orderDishesService.listOrderDishes());
//
//        return "orderdishes";
//    }
//
//    @RequestMapping("/orderdishesremove/{id}")
//    public String removeOrderDishes(@PathVariable("id") int id) {
//        OrderDishes orderDishes = new OrderDishes();
//        orderDishes.setOrderId(0);
//        orderDishes.setDishId(0);
//        this.orderDishesService.updateOrderDishes(orderDishes);
//
//        return "redirect:/orderdishes";
//    }
//
//    @RequestMapping("orderdishesedit/{id}")
//    public String editOrderDishes(@PathVariable("id") int id, Model model) {
//        model.addAttribute("orderdishes", this.orderDishesService.getOrderDishesById(id));
//        model.addAttribute("listOrderDishes", this.orderDishesService.listOrderDishes());
//
//        return "orderdishes";
//    }
//
//    @RequestMapping(value = "/orderdishes/add", method = RequestMethod.POST)
//    public String addOrderDishes(@ModelAttribute("orderdishes") OrderDishes orderDishes) {
//        this.orderDishesService.addOrderDishes(orderDishes);
//
//        return "redirect:/orderdishes";
//    }
//
//    @RequestMapping("ingredientdata/{id}")
//    public String ingredientData(@PathVariable("id") int id, Model model) {
//        model.addAttribute("ingredient", this.orderDishesService.getOrderDishesById(id));
//
//        return "ingredientdata";
//    }
//}
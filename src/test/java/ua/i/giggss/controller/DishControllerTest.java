package ua.i.giggss.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import ua.i.giggss.model.Dish;
import ua.i.giggss.service.DishService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class DishControllerTest {

    @Mock
    private DishService dishService;
    @InjectMocks
    private DishController dishController;

    private Model model;

    @Before
    public void setUp() throws Exception {
        model = new ExtendedModelMap();
    }

//    @After
//    public void tearDown() throws Exception {
//    }

    @Test
    public void testContacts() throws Exception {
        String result = dishController.contacts();
        assertEquals("contacts", result);
    }

    @Test
    public void testRestaurantmap() throws Exception {
        String result = dishController.restaurantmap();
        assertEquals("restaurantmap", result);
    }

    @Test
    public void testListDishes() throws Exception {
        List<Dish> expectedDishes = asList();
        when(dishService.listDishes()).thenReturn(expectedDishes);
        assertEquals("dishes", dishController.listDishes(model));
        assertSame(expectedDishes, model.asMap().get("listDishes"));
    }

    @Test
    public void testEditDish() throws Exception {
        List<Dish> expectedDishes = asList();
        when(dishService.listDishes()).thenReturn(expectedDishes);
        assertEquals("dishes", dishController.editDish(11, model));
        assertSame(expectedDishes, model.asMap().get("listDishes"));
    }

    @Test
    public void testAddDish() throws Exception {
        Dish dish = new Dish();
        String result = dishController.addDish(dish);
        assertEquals("redirect:/dishes", result);
    }

    @Test
    public void testRemoveDish() throws Exception {
        String result = dishController.removeDish(13);
        assertEquals("redirect:/dishes", result);
    }

    @Test
    public void testDishData() throws Exception {
        Dish dish = new Dish();
        dish.setDishId(11);
        dish.setDishName("Tiramisu");
        dish.setCategory("dessert");
        dish.setIngredients("sugar egg cheese coffee");
        dish.setCost(20);
        dish.setWeight(110);
        when(dishService.getDishById(11)).thenReturn(dish);
        assertEquals("dishdata", dishController.dishData(11, model));
        assertSame(dish, model.asMap().get("dish"));
    }
}
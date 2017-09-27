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
import ua.i.giggss.model.Stock;
import ua.i.giggss.service.DishService;
import ua.i.giggss.service.StockService;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {

    @Mock
    private StockService stockService;
    @InjectMocks
    private StockController stockController;

    private Model model;

    @Before
    public void setUp() throws Exception {
        model = new ExtendedModelMap();
    }

    @Test
    public void listStock() throws Exception {
        List<Stock> expectedStock = asList();
        when(stockService.listStock()).thenReturn(expectedStock);
        assertEquals("stock", stockController.listStock(model));
        assertSame(expectedStock, model.asMap().get("listStock"));
    }

    @Test
    public void removeStock() throws Exception {
        String result = stockController.removeStock(13);
        assertEquals("redirect:/stock", result);
    }

    @Test
    public void editStock() throws Exception {
        List<Stock> expectedStock = asList();
        when(stockService.listStock()).thenReturn(expectedStock);
        assertEquals("stock", stockController.editStock(11, model));
        assertSame(expectedStock, model.asMap().get("listStock"));
    }

    @Test
    public void addStock() throws Exception {
        Stock stock = new Stock();
        String result = stockController.addStock(stock);
        assertEquals("redirect:/stock", result);
    }

    @Test
    public void ingredientData() throws Exception {
        Stock stock = new Stock();
        when(stockService.getStockById(13)).thenReturn(stock);
        assertEquals("ingredientdata", stockController.ingredientData(13, model));
        assertSame(stock, model.asMap().get("ingredient"));
    }

}
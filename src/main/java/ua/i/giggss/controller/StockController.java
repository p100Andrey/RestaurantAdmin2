package ua.i.giggss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.i.giggss.model.Stock;
import ua.i.giggss.service.StockService;

@Controller
public class StockController {

    private StockService stockService;

    @Autowired(required = true)
    @Qualifier(value = "stockService")
    public void setStockService(StockService stockService) {
        this.stockService = stockService;
    }

    // формерую полный список
    @RequestMapping(value = "stock", method = RequestMethod.GET)
    public String listStock(Model model) {
        model.addAttribute("stock", new Stock());
        model.addAttribute("listStock", this.stockService.listStock());

        return "stock";
    }

    @RequestMapping("/stockremove/{id}")
    public String removeStock(@PathVariable("id") int id) {
        Stock stock = new Stock();
        stock.setStockId(id);
        stock.setIngredientName("empty");
        stock.setQuantity(0);
        stock.setMeasure(null);
        this.stockService.updateStock(stock);

        return "redirect:/stock";
    }

    @RequestMapping("stockedit/{id}")
    public String editStock(@PathVariable("id") int id, Model model) {
        model.addAttribute("stock", this.stockService.getStockById(id));
        model.addAttribute("listStock", this.stockService.listStock());

        return "stock";
    }

    @RequestMapping(value = "/stock/add", method = RequestMethod.POST)
    public String addStock(@ModelAttribute("stock") Stock stock) {
        if (stock.getStockId() == 0) {
            this.stockService.addStock(stock);
        } else {
            this.stockService.updateStock(stock);
        }

        return "redirect:/stock";
    }

    @RequestMapping("ingredientdata/{id}")
    public String ingredientData(@PathVariable("id") int id, Model model) {
        model.addAttribute("ingredient", this.stockService.getStockById(id));

        return "ingredientdata";
    }
}
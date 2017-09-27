package ua.i.giggss.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
    @Table(name = "stock")
    public class Stock {

        @Id
        @Column(name = "ingredientid")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int stockId;

        @Column (name = "ingredientname")
        private String ingredientName;

        @Column (name = "quantity")
        private double quantity;

        @Column (name = "measure")
        private String measure;

    public int getStockId() {
        return stockId;
    }

    public void setStockId(int stockId) {
        this.stockId = stockId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "stockId=" + stockId +
                ", ingredientName=" + ingredientName +
                ", quantity=" + quantity +
                ", measure='" + measure + '\'' +
                '}';
    }
}

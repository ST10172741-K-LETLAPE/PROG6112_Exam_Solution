package q1test;

import q1.ProductSales;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductSalesTest {

    private final int[][] productSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        ProductSales sales = new ProductSales();
        int expected = 2200;
        int actual = sales.TotalSales(productSales);
        assertEquals(expected, actual);
    }

    @Test
    public void AverageSales_ReturnsAverageProductSales() {
        ProductSales sales = new ProductSales();
        double expected = 366.6666666666667;
        double actual = sales.AverageSales(productSales);
        assertEquals(expected, actual, 0.01);
    }
}

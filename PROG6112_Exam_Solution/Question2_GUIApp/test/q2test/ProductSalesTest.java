package q2test;

import q2.ProductSales;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductSalesTest {

    @Test
    public void GetSalesOverLimit_ReturnsNumberOfSales() {
        ProductSales sales = new ProductSales();
        int expected = 2;
        int actual = sales.GetSalesOverLimit();
        assertEquals(expected, actual);
    }

    @Test
    public void GetSalesUnderLimit_ReturnsNumberOfSales() {
        ProductSales sales = new ProductSales();
        int expected = 4;
        int actual = sales.GetSalesUnderLimit();
        assertEquals(expected, actual);
    }
}

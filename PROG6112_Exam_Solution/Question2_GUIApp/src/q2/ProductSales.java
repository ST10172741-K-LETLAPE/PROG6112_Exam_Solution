package q2;

public class ProductSales implements IProductSales {

    private final int SALES_LIMIT = 500;

    // Data from Q2.1 table: rows = years, columns = products
    // Year 1: Microphone 300, Speakers 150, Mixing Desk 700
    // Year 2: Microphone 250, Speakers 200, Mixing Desk 600
    private final int[][] productSales = {
        {300, 150, 700},
        {250, 200, 600}
    };

    @Override
    public int[][] GetProductSales() {
        return productSales;
    }

    @Override
    public int GetTotalSales() {
        int total = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                total += productSales[i][j];
            }
        }
        return total;
    }

    @Override
    public double GetAverageSales() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            count += productSales[i].length;
        }
        if (count == 0) return 0;
        return (double) GetTotalSales() / count;
    }

    @Override
    public int GetSalesOverLimit() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                if (productSales[i][j] > SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetSalesUnderLimit() {
        int count = 0;
        for (int i = 0; i < productSales.length; i++) {
            for (int j = 0; j < productSales[i].length; j++) {
                if (productSales[i][j] < SALES_LIMIT) {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public int GetProductsProcessed() {
        return productSales.length;
    }
}

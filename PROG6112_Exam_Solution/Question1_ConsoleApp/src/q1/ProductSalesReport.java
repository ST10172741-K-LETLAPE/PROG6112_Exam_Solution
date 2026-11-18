package q1;

public class ProductSalesReport {
    public static void main(String[] args) {
        String[] quarters = {"QUARTER 1", "QUARTER 2", "QUARTER 3"};
        String[] years = {"YEAR 1", "YEAR 2"};

        // 2D array: rows = years, columns = quarters
        int[][] productSales = {
            {300, 150, 700},  // YEAR 1
            {250, 200, 600}   // YEAR 2
        };

        ProductSales sales = new ProductSales();

        int total = sales.TotalSales(productSales);
        int average = (int) Math.round(sales.AverageSales(productSales));
        int max = sales.MaxSale(productSales);
        int min = sales.MinSale(productSales);

        System.out.println("PRODUCT SALES REPORT - 2025");
        System.out.println("--------------------------------");
        System.out.println("Total sales:   " + total);
        System.out.println("Average sales: " + average);
        System.out.println("Maximum sale:  " + max);
        System.out.println("Minimum sale:  " + min);
        System.out.println("--------------------------------");
    }
}

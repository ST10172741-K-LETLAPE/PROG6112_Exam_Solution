package q2;

import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import java.awt.*;

public class ProductSalesGUI extends JFrame {

    private JButton btnLoad;
    private JButton btnSave;
    private JTextArea txtDisplay;
    private JLabel lblYearsProcessed;

    private JMenuItem mnuExit;
    private JMenuItem mnuLoad;
    private JMenuItem mnuSave;
    private JMenuItem mnuClear;

    private ProductSales productSales;

    public ProductSalesGUI() {
        productSales = new ProductSales();
        initComponents();
    }

    private void initComponents() {
        setTitle("Product Sales Application");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        JMenu mnuTools = new JMenu("Tools");

        mnuExit = new JMenuItem("Exit");
        mnuLoad = new JMenuItem("Load Product Data");
        mnuSave = new JMenuItem("Save Product Data");
        mnuClear = new JMenuItem("Clear");

        mnuFile.add(mnuExit);
        mnuTools.add(mnuLoad);
        mnuTools.add(mnuSave);
        mnuTools.add(mnuClear);
        menuBar.add(mnuFile);
        menuBar.add(mnuTools);
        setJMenuBar(menuBar);

        btnLoad = new JButton("Load Product Data");
        btnSave = new JButton("Save Product Data");
        txtDisplay = new JTextArea(8, 30);
        txtDisplay.setEditable(false);
        lblYearsProcessed = new JLabel("Years Processed: ");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(10, 10));
        JPanel topPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        topPanel.add(btnLoad);
        topPanel.add(btnSave);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(txtDisplay), BorderLayout.CENTER);
        panel.add(lblYearsProcessed, BorderLayout.SOUTH);
        add(panel);

        btnLoad.addActionListener(e -> loadProductData());
        mnuLoad.addActionListener(e -> loadProductData());

        btnSave.addActionListener(e -> saveProductData());
        mnuSave.addActionListener(e -> saveProductData());

        mnuExit.addActionListener(e -> System.exit(0));

        mnuClear.addActionListener(e -> {
            txtDisplay.setText("");
            lblYearsProcessed.setText("Years Processed: ");
        });
    }

    private void loadProductData() {
        int total = productSales.GetTotalSales();
        int average = (int) Math.round(productSales.GetAverageSales());
        int over = productSales.GetSalesOverLimit();
        int under = productSales.GetSalesUnderLimit();
        int years = productSales.GetProductsProcessed();

        txtDisplay.setText(
            "Total Sales: " + total + "\n" +
            "Average Sales: " + average + "\n" +
            "Sales over limit: " + over + "\n" +
            "Sales under limit: " + under
        );
        lblYearsProcessed.setText("Years Processed: " + years);
    }

    private void saveProductData() {
        try (FileWriter writer = new FileWriter("data.txt")) {
            writer.write("DATA LOG\n");
            writer.write("********************************\n");
            writer.write(txtDisplay.getText() + "\n");
            writer.write("********************************\n");
            JOptionPane.showMessageDialog(this, "Data saved to data.txt");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ProductSalesGUI().setVisible(true);
        });
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.JFrame;
import javax.swing.JTable;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author TVD
 */
/**
 *
 * @author 84338
 */
public class StaticsChart extends javax.swing.JFrame {

    /**
     * Creates new form StaticsChart
     */
    public void JFreeChartTest() {
        ChartPanel chartPanel = new ChartPanel(createChart());
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        JFrame frame = new JFrame();
        frame.add(chartPanel);
        frame.setTitle("Chart Statics Product");
        frame.setSize(1500, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private static CategoryDataset createDataset() {
        Statics sourceFrame = new Statics();
        Object[][] tableData = sourceFrame.getTableData();
        List<Integer> topValues = new ArrayList<>();
        for (Object[] row : tableData) {
            int value = (int) row[1];
            topValues.add(value);
        }
        Collections.sort(topValues, Comparator.naturalOrder());
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 20 && i < topValues.size(); i++) {
            int value = topValues.get(i);
            for (Object[] row : tableData) {
                int rowValue = (int) row[1];
                if (rowValue == value) {
                    String column1 = String.valueOf(row[0]);
                    dataset.addValue(value, "", column1);
                    break;
                }
            }
        }

        return dataset;
    }

    public static JFreeChart createChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                "20 Products with the smallest Quantity",
                "PRODUCT", "QUANTITY",
                createDataset(), PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StaticsChart();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

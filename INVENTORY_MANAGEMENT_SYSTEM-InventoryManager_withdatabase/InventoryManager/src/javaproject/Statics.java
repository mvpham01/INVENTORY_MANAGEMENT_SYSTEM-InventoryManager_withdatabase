/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaproject;

import java.awt.Color;
import java.awt.Font;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class Statics extends javax.swing.JFrame {

    public Statics() {
        initComponents();
        addData();
        totalPrice();
        SaveStaticsBtn.setVisible(false);
    }

    public void addData() {
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String staticsDay = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT P.[Product_Name], P.[Product_quantity], P.[Product_Price], C.[Category_Name]\n"
                    + "        FROM [dbo].[Products] P\n"
                    + "        JOIN [dbo].[GoodsCategories] C ON P.[Category_ID] = C.[Category_ID]";
            rs = stmt.executeQuery(sql);

            DefaultTableModel tableModel = (DefaultTableModel) StaticsTable.getModel();
            tableModel.setRowCount(0);
            // Thêm dữ liệu từ ResultSet vào bảng DataTable
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("Product_Name");
                row[1] = rs.getInt("Product_quantity");
                row[2] = rs.getString("Product_Price");
                row[3] = rs.getString("Category_Name");
                tableModel.addRow(row);
            }
            //Select Total Orders
            String totalOrders = "";
            sql = "SELECT COUNT(O.Order_ID) AS TotalOrders "
                    + "FROM Orders O "
                    + "WHERE O.Order_date > (SELECT MAX(IS1.Date) FROM InventoryStatics IS1)";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                totalOrders = rs.getString("TotalOrders");  // Lưu giá trị vào biến totalOrders
            }
            CountOrder.setText(totalOrders);
            // total money
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Font headerFont = new Font("Segoe UI", Font.BOLD, 14);
        JTableHeader tableHeader1 = StaticsTable.getTableHeader();
        tableHeader1.setFont(headerFont);
        tableHeader1.setBackground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BackMenuBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        StaticsTable = new javax.swing.JTable();
        StaticsBtn = new javax.swing.JButton();
        SaveStaticsBtn = new javax.swing.JButton();
        ShowChartBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        CountOrder = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        totalPriceVar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Inventory Statics");

        BackMenuBtn.setText("Main Menu");
        BackMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(245, 245, 245)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(271, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(BackMenuBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(38, 38, 38))
        );

        StaticsTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        StaticsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Quantity Product", "Price", "Category"
            }
        ));
        jScrollPane1.setViewportView(StaticsTable);

        StaticsBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        StaticsBtn.setText("Statics");
        StaticsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StaticsBtnActionPerformed(evt);
            }
        });

        SaveStaticsBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SaveStaticsBtn.setText("Save");
        SaveStaticsBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveStaticsBtnActionPerformed(evt);
            }
        });

        ShowChartBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ShowChartBtn.setText("Chart Data");
        ShowChartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowChartBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("New Order : ");

        CountOrder.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CountOrder.setText("0");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Total Price : ");

        totalPriceVar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalPriceVar.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ShowChartBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CountOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(StaticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
            .addGroup(layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(SaveStaticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalPriceVar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ShowChartBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StaticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CountOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(totalPriceVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(SaveStaticsBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void StaticsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StaticsBtnActionPerformed
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        String staticsDay = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT P.[Product_Name], \n"
                    + "       P.[Product_Quantity] - COALESCE(PO.[Total_Quantity_Ordered], 0) AS [Product_Quantity], \n"
                    + "       P.[Product_Price], \n"
                    + "       C.[Category_Name]\n"
                    + "FROM Products P\n"
                    + "JOIN GoodsCategories C ON P.Category_ID = C.Category_ID\n"
                    + "LEFT JOIN (\n"
                    + "    SELECT POD.Product_ID, SUM(POD.[Product_Quantity_Order]) AS Total_Quantity_Ordered\n"
                    + "    FROM Product_Order_Detail POD\n"
                    + "    LEFT JOIN Orders O ON POD.Order_ID = O.Order_ID\n"
                    + "    WHERE O.Order_date > (SELECT MAX(IS1.Date) FROM InventoryStatics IS1)\n"
                    + "    GROUP BY POD.Product_ID\n"
                    + ") AS PO ON P.Product_ID = PO.Product_ID";
            rs = stmt.executeQuery(sql);
            // Xóa các dữ liệu cũ trong bảng DataTable
            DefaultTableModel tableModel = (DefaultTableModel) StaticsTable.getModel();
            tableModel.setRowCount(0);
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("Product_Name");
                row[1] = rs.getInt("Product_quantity");
                row[2] = rs.getString("Product_Price");
                row[3] = rs.getString("Category_Name");
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (!CountOrder.getText().equals("0")) {
            SaveStaticsBtn.setVisible(true);
        }
        totalPrice();
    }//GEN-LAST:event_StaticsBtnActionPerformed

    private void SaveStaticsBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveStaticsBtnActionPerformed
        Connection conn = MainConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String staticsDay = null;
        java.util.Date currentDate = new java.util.Date();
        long currentTimeMillis = currentDate.getTime();
        Statement stmt = null;
        java.sql.Timestamp timestamp = new java.sql.Timestamp(currentTimeMillis);
        //
        String inventoryStaticsID = "IS0001";
        try {
            inventoryStaticsID = null;
            String maxIdSql = "SELECT MAX(InventoryStatics_ID) AS MaxId FROM InventoryStatics";
            PreparedStatement maxIdStmt = conn.prepareStatement(maxIdSql);
            ResultSet maxIdRs = maxIdStmt.executeQuery();
            if (maxIdRs.next()) {
                String maxId = maxIdRs.getString("MaxId");
                if (maxId != null) {
                    int numericPart = Integer.parseInt(maxId.substring(2)) + 1;
                    inventoryStaticsID = "IS" + String.format("%04d", numericPart);
                } else {
                    inventoryStaticsID = "IS0001";
                }
            }
            int inventoryManagerID = 1;
            String insertSql = "INSERT INTO InventoryStatics (InventoryStatics_ID, InventoryManager_ID, Quantity_Products, Date) VALUES (?, ?, ?, ?)";
            PreparedStatement insertStmt = conn.prepareStatement(insertSql);
            insertStmt.setString(1, inventoryStaticsID);
            insertStmt.setInt(2, inventoryManagerID);
            insertStmt.setInt(3, StaticsTable.getRowCount());
            insertStmt.setObject(4, timestamp);
            insertStmt.executeUpdate();
            CreateStaticDetailByID(inventoryStaticsID);
        } catch (SQLException e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_SaveStaticsBtnActionPerformed

    private void ShowChartBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowChartBtnActionPerformed
        StaticsChart importDetailFrame = new StaticsChart();
        importDetailFrame.JFreeChartTest();
    }//GEN-LAST:event_ShowChartBtnActionPerformed

    private void BackMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMenuBtnActionPerformed
        ManagerMenu importDetailFrame = new ManagerMenu();
        importDetailFrame.ManagerMenu();
        importDetailFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMenuBtnActionPerformed
    private void CreateStaticDetailByID(String inventoryStaticsID) {
        System.out.println(inventoryStaticsID);
        Connection conn = MainConnection.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String staticsDay = null;
        java.util.Date currentDate = new java.util.Date();
        long currentTimeMillis = currentDate.getTime();
        Statement stmt = null;
        java.sql.Timestamp timestamp = new java.sql.Timestamp(currentTimeMillis);
        DefaultTableModel model = (DefaultTableModel) StaticsTable.getModel();
        try {
            // Lấy số hàng và cột trong JTable
            int rowCount = StaticsTable.getRowCount();
            int columnCount = StaticsTable.getColumnCount();
            int productID = 0;
            for (int row = 0; row < rowCount; row++) {

                String Product_Name = StaticsTable.getValueAt(row, 0).toString();
                String selectSql = "SELECT Product_ID FROM Products WHERE Product_Name = ?";
                try {
                    PreparedStatement selectStmt = conn.prepareStatement(selectSql);
                    selectStmt.setString(1, Product_Name);
                    ResultSet resultSet = selectStmt.executeQuery();
                    if (resultSet.next()) {
                        productID = resultSet.getInt("Product_ID");
                    } else {
                        System.out.println("Không tìm thấy Product_name");
                    }
                    resultSet.close();
                    selectStmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                };
                String inventoryStaticsDetailID = inventoryStaticsID + "-" + (row + 1);
                int quantityProducts = Integer.parseInt(StaticsTable.getValueAt(row, 1).toString()); // Lấy giá trị cột 1
                // truy vấn INSERT
                stmt = conn.createStatement();
                System.out.println(inventoryStaticsDetailID);
                System.out.println(quantityProducts);
                String insertSql = "INSERT INTO InventoryStaticsDetail (Inventory_Statics_Detail_ID, InventoryStatics_ID, Product_ID, Inventory_Statics_Detail_Date,Quantity_Product)\n"
                        + "VALUES ('" + inventoryStaticsDetailID + "', '" + inventoryStaticsID + "', " + productID + ", '" + timestamp + "', " + quantityProducts + ");";
                stmt.executeUpdate(insertSql);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        SaveStaticsBtn.setVisible(false);
        JOptionPane.showMessageDialog(null, "The data has been create.");
    }

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Statics().setVisible(true);
            }
        });
    }
    public void totalPrice(){
        int total = 0;
            int quantityColumnIndex = 1; // Vị trí cột số lượng
            int priceColumnIndex = 2; // Vị trí cột giá tiền
            int rowCount = StaticsTable.getRowCount(); // Số hàng trong bảng
            for (int i = 0; i < rowCount; i++) {
                Object quantityObj = StaticsTable.getValueAt(i, quantityColumnIndex);
                Object priceObj = StaticsTable.getValueAt(i, priceColumnIndex);
                // Chuyển đổi từ Integer sang String
                String quantityStr = quantityObj.toString();
                String priceStr = priceObj.toString();
                // Chuyển đổi từ String sang Integer
                int quantity = Integer.parseInt(quantityStr);
                int price = Integer.parseInt(priceStr);
                int subtotal = quantity * price;
                total += subtotal;
            }
            totalPriceVar.setText(total+" $");
    }
    public Object[][] getTableData() {
        DefaultTableModel model = (DefaultTableModel) StaticsTable.getModel();
        int rowCount = model.getRowCount();
        int columnCount = 2; // Lấy hai cột đầu tiên
        Object[][] data = new Object[rowCount][columnCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                data[i][j] = model.getValueAt(i, j);
            }
        }
        System.out.println(data[0][1]);
        return data;
    }

    public void call() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackMenuBtn;
    private javax.swing.JLabel CountOrder;
    private javax.swing.JButton SaveStaticsBtn;
    private javax.swing.JButton ShowChartBtn;
    private javax.swing.JButton StaticsBtn;
    private javax.swing.JTable StaticsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel totalPriceVar;
    // End of variables declaration//GEN-END:variables

}

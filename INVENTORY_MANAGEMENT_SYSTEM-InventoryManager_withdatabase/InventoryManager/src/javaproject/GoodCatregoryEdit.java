/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author 84338
 */
public class GoodCatregoryEdit extends javax.swing.JFrame {

    /**
     * Creates new form GoodCatregoryEdit
     */
    public void GoodCatregoryEdit() {
        initComponents();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });
    }

    public void closeFrame() {
        SwingUtilities.invokeLater(() -> {
            WindowEvent windowClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosing);
            dispose();
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProductNameTextFiel = new javaproject.ImportTextField();
        jLabel1 = new javax.swing.JLabel();
        CategoriName = new javax.swing.JComboBox<>();
        SaveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProductNameTextFiel.setEditable(false);
        ProductNameTextFiel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProductNameTextFiel.setLabelText("Product Name");
        ProductNameTextFiel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProductNameTextFielActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Category");

        CategoriName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CategoriName.setForeground(new java.awt.Color(0, 0, 0));
        CategoriName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CategoriName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriNameActionPerformed(evt);
            }
        });

        SaveBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProductNameTextFiel, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(CategoriName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(72, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(ProductNameTextFiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoriName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ProductNameTextFielActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProductNameTextFielActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProductNameTextFielActionPerformed

    private void CategoriNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriNameActionPerformed

    }//GEN-LAST:event_CategoriNameActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        String ProductName = ProductNameTextFiel.getText();
        String CategoriesName = CategoriName.getSelectedItem().toString();
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = MainConnection.getConnection();
            //Get the category_id based on CategoriesName
            String getCategoryIDQuery = "SELECT Category_ID FROM GoodsCategories WHERE Category_name=?";
            stmt = conn.prepareStatement(getCategoryIDQuery);
            stmt.setString(1, CategoriesName);
            rs = stmt.executeQuery();

            int categoryID = -1; // Default value in case the category is not found
            if (rs.next()) {
                categoryID = rs.getInt("Category_ID");
            }

            // Update the category_id for the corresponding product
            String updateProductQuery = "UPDATE Products SET Category_ID=? WHERE Product_name=?";
            stmt = conn.prepareStatement(updateProductQuery);
            stmt.setInt(1, categoryID);
            stmt.setString(2, ProductName);
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "New Data Update !");
            } else {
                System.out.println("No product found with the given name.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all Statement, ResultSet, and Connection objects
            try {
                if (rs != null) {
                    rs.close();
                }
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
       

    }//GEN-LAST:event_SaveBtnActionPerformed
    public void adddatabyProductName(String ProductName) {
        comboboxCategories();
        
        ProductNameTextFiel.setText(ProductName);
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = MainConnection.getConnection();
            String sql = "SELECT Products.Product_name, GoodsCategories.Category_name\n"
                    + "FROM Products JOIN GoodsCategories ON Products.Category_ID = GoodsCategories.Category_ID \n"
                    + "WHERE Product_name=?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ProductName);
            rs = stmt.executeQuery();

            // Add each category to the combo box
            while (rs.next()) {
                String categoryName = rs.getString("Category_name");
                CategoriName.setSelectedItem(categoryName);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all Statement, ResultSet, and Connection objects
            try {
                if (rs != null) {
                    rs.close();
                }
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

    }

    public void comboboxCategories() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = MainConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT Category_name FROM GoodsCategories";
            rs = stmt.executeQuery(sql);
            // Clear the combo box
            CategoriName.removeAllItems();
            // Add each category to the combo box
            while (rs.next()) {
                String categoryName = rs.getString("Category_name");
                CategoriName.addItem(categoryName);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close all Statement, ResultSet, and Connection objects
            try {
                if (rs != null) {
                    rs.close();
                }
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
        CategoriName.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (isSelected) {
                    component.setFont(new Font("Arial", Font.BOLD, 14));
                } else {
                    component.setBackground(Color.WHITE); // Đặt màu nền mặc định cho các mục khác
                }
                return component;
            }
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GoodCatregoryEdit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CategoriName;
    private javaproject.ImportTextField ProductNameTextFiel;
    private javax.swing.JButton SaveBtn;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

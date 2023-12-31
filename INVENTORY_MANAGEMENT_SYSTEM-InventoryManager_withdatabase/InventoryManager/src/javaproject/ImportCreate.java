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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author 84338
 */
public class ImportCreate extends javax.swing.JFrame {

    /**
     * Creates new form ImportCreate
     */
    public ImportCreate() {
        initComponents();
        populateCategoriesComboBox();
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

        ImportID = new javaproject.ImportTextField();
        ImportName = new javaproject.ImportTextField();
        Expiry = new javaproject.ImportTextField();
        CategoriName = new javax.swing.JComboBox<>();
        LabelCategoryName = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        CreateImportBtn = new javax.swing.JButton();
        SupplierCombobox = new javax.swing.JComboBox<>();
        LabelSupplier = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImportID.setLabelText("Import ID");
        ImportID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportIDActionPerformed(evt);
            }
        });

        ImportName.setLabelText("Import Product Name");

        Expiry.setLabelText("Expiry");

        CategoriName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CategoriName.setForeground(new java.awt.Color(0, 0, 0));
        CategoriName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CategoriName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriNameActionPerformed(evt);
            }
        });

        LabelCategoryName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelCategoryName.setText("Categories Name :");

        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        CreateImportBtn.setText("Create");
        CreateImportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateImportBtnActionPerformed(evt);
            }
        });

        SupplierCombobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SupplierCombobox.setForeground(new java.awt.Color(0, 0, 0));
        SupplierCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SupplierCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SupplierComboboxActionPerformed(evt);
            }
        });

        LabelSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        LabelSupplier.setText("Supplier");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ImportID, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(ImportName, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(SupplierCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CategoriName, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CreateImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ImportID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SupplierCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategoriName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(ImportName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Expiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateImportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ImportIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImportIDActionPerformed

    private void CategoriNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriNameActionPerformed

    }//GEN-LAST:event_CategoriNameActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        dispose();
        ImportProductManager phanloaiFrame = new ImportProductManager();
        if (phanloaiFrame != null && phanloaiFrame.isVisible()) {
            System.out.println("sus");
        } else if (phanloaiFrame != null) {
            phanloaiFrame.toFront();
        }
    }//GEN-LAST:event_BackBtnActionPerformed

    private void CreateImportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateImportBtnActionPerformed
        String importID = ImportID.getText();
        String categoryName = CategoriName.getSelectedItem().toString();
        String SupName = SupplierCombobox.getSelectedItem().toString();
        String expiry = Expiry.getText();
        String ImportName = this.ImportName.getText();
        Connection conn = MainConnection.getConnection();
        String SupID = "";
        Statement stmt = null;
        ResultSet rs = null;
        if (importID.isEmpty() || categoryName.isEmpty() || expiry.isEmpty() || ImportName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.");
            return;
        }
        try {
            LocalDate.parse(expiry);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "date is not valid !");
            return;
        }
        try {
            stmt = conn.createStatement();
            String selectSql = "SELECT * FROM Import_Product WHERE Import_ID = '" + importID + "'";
            boolean recordExists = stmt.executeQuery(selectSql).next();
            if (recordExists) {
                JOptionPane.showMessageDialog(null, "ImportID exist , No new imports added");
            } else {
                selectSql = "SELECT Sup_ID FROM Supplier where Sup_Name='" + SupName + "';";
                rs = stmt.executeQuery(selectSql);
                if (rs.next()) {
                    SupID = rs.getString("Sup_ID");
                    System.out.println(SupID);
                }
                  
                String insertSql = "INSERT INTO Import_Product (Import_ID, Categories_name,Sup_ID, Import_Product_Name, Expiry) "
                        + "VALUES ('" + importID + "', '" + categoryName + "','" + SupID + "', '" + ImportName + "', '" + expiry + "')";
                int rowsInserted = stmt.executeUpdate(insertSql);
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(null, "The new data has been added successfully");
                } else {
                    System.out.println("No new data has been added.");
                }
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
    }//GEN-LAST:event_CreateImportBtnActionPerformed

    private void SupplierComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SupplierComboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SupplierComboboxActionPerformed

    /**
     * @param args the command line arguments
     */
    public void populateCategoriesComboBox() {
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
            sql = "SELECT Sup_Name FROM Supplier";
            rs = stmt.executeQuery(sql);
            // Clear the combo box
            SupplierCombobox.removeAllItems();
            // Add each category to the combo box
            while (rs.next()) {
                String SupName = rs.getString("Sup_Name");
                SupplierCombobox.addItem(SupName);
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

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ImportCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImportCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImportCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImportCreate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImportCreate().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BackBtn;
    private javax.swing.JComboBox<String> CategoriName;
    public javax.swing.JButton CreateImportBtn;
    private javaproject.ImportTextField Expiry;
    private javaproject.ImportTextField ImportID;
    private javaproject.ImportTextField ImportName;
    private javax.swing.JLabel LabelCategoryName;
    private javax.swing.JLabel LabelSupplier;
    private javax.swing.JComboBox<String> SupplierCombobox;
    // End of variables declaration//GEN-END:variables
}

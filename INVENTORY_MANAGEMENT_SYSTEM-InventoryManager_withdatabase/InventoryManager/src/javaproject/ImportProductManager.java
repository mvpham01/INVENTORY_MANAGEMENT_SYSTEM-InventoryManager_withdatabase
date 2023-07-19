package javaproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaproject.ImportDetail;
import javaproject.MainConnection;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class ImportProductManager extends javax.swing.JFrame {

    public ImportProductManager() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        initComponents();
        initializeTable();
        ShowTableData();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        ShortById.setComponentPopupMenu(PopUpMenuShortById);
    }

    private void initializeTable() {
        //
        //**Table Short By Date
        //
        // Lấy dữ liệu từ cơ sở dữ liệu
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT ImportDate, COUNT(*) AS Total_Imports, STRING_AGG(Import_ID, ',') AS Import_IDs "
                    + "FROM Import_Product_Detail "
                    + "GROUP BY ImportDate "
                    + "ORDER BY ImportDate DESC";
            rs = stmt.executeQuery(sql);
            // Xóa các dữ liệu cũ trong bảng DataTable
            DefaultTableModel tableModel = (DefaultTableModel) ShortByDate.getModel();
            tableModel.setRowCount(0);
            
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("ImportDate");
                row[1] = rs.getInt("Total_Imports");
                row[2] = rs.getString("Import_IDs");
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        //**Table Short Category
        //
        try {
            stmt = conn.createStatement();
            String sql = "SELECT ip.Categories_name, COUNT(ipd.Import_Product_Detail_ID) AS NumberImportDetail,\n"
                    + "STRING_AGG(ipd.Import_Product_Detail_ID, ', ') AS Import_Product_Detail_IDs\n"
                    + "FROM Import_Product ip\n"
                    + "INNER JOIN Import_Product_Detail ipd ON ip.Import_ID = ipd.Import_ID\n"
                    + "INNER JOIN Products p ON ipd.Product_ID = p.Product_ID\n"
                    + "INNER JOIN GoodsCategories gc ON p.Category_ID = gc.Category_ID\n"
                    + "GROUP BY ip.Categories_name;";
            rs = stmt.executeQuery(sql);
           
            DefaultTableModel tableModel = (DefaultTableModel) ShortByCategory.getModel();
            tableModel.setRowCount(0);
           
            while (rs.next()) {
                Object[] row = new Object[3];
                row[0] = rs.getString("Categories_name");
                row[1] = rs.getInt("NumberImportDetail");
                row[2] = rs.getString("Import_Product_Detail_IDs");
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //
        //**Table Short By ID
        //
        DefaultTableModel tableModel = (DefaultTableModel) ShortById.getModel();
        tableModel.setRowCount(0);
        // Truy cập các phần tử trong danh sách
        try {
            stmt = conn.createStatement();
            String sql = "SELECT * FROM Import_Product";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Object[] row = new Object[4];
                row[0] = rs.getString("Import_Id");
                row[1] = rs.getString("Categories_name");
                row[2] = rs.getString("Import_product_Name");
                row[3] = rs.getString("Expiry");
                tableModel.addRow(row);
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
    }

    private void ShowTableData() {
        //set default
        ContainShortByCategory.setVisible(false);
        ContainShortByDate.setVisible(false);
        pack();
        //
        TypeImport.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedValue = (String) TypeImport.getSelectedItem();
                    if (selectedValue.equals("Date")) {
                       
                        ContainShortByDate.setVisible(true);
                        ContainShortById.setVisible(false);
                        ContainShortByCategory.setVisible(false);
                    } else if (selectedValue.equals("ID")) {
                        
                        ContainShortByDate.setVisible(false);
                        ContainShortById.setVisible(true);
                        ContainShortByCategory.setVisible(false);
                    } else if (selectedValue.equals("Category")) {
                       
                        ContainShortByDate.setVisible(false);
                        ContainShortById.setVisible(false);
                        ContainShortByCategory.setVisible(true);
                    }
                
                    pack();
                }
            }
        });
        //Style Table and Combobox   
        SetFontTableHeader();
        TypeImport.setRenderer(new DefaultListCellRenderer() {
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

    private void SetFontTableHeader() {
        Font headerFont = new Font("Segoe UI", Font.BOLD, 14);
        JTableHeader tableHeader1 = ShortByCategory.getTableHeader();
        tableHeader1.setFont(headerFont);
        tableHeader1.setBackground(Color.black);
        //
        JTableHeader tableHeader2 = ShortById.getTableHeader();
        tableHeader2.setFont(headerFont);
        tableHeader2.setBackground(Color.black);
        //
        JTableHeader tableHeader3 = ShortByDate.getTableHeader();
        tableHeader3.setFont(headerFont);
        tableHeader3.setBackground(Color.black);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpMenuShortById = new javax.swing.JPopupMenu();
        DeleteTableId = new JMenuItem("Delete",DeleteIcon);
        EditTableId = new JMenuItem("Edit",EditIcon);
        PopUpMenuShortByCategory = new javax.swing.JPopupMenu();
        DeleteTableCategory = new javax.swing.JMenuItem();
        EditTableCategory = new javax.swing.JMenuItem();
        ContainShortByDate = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ShortByDate = new javax.swing.JTable();
        ContainShortById = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        ShortById = new javax.swing.JTable();
        CreateImportPanel = new javax.swing.JButton();
        ResetBtn = new javax.swing.JButton();
        ContainShortByCategory = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ShortByCategory = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BackMenuBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        TypeImport = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        DeleteTableId.setText("Delete Import");
        DeleteTableId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTableIdActionPerformed(evt);
            }
        });
        PopUpMenuShortById.add(DeleteTableId);

        EditTableId.setText("Edit Import");
        EditTableId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditTableIdActionPerformed(evt);
            }
        });
        PopUpMenuShortById.add(EditTableId);

        DeleteTableCategory.setText("Delete");
        DeleteTableCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTableCategoryActionPerformed(evt);
            }
        });
        PopUpMenuShortByCategory.add(DeleteTableCategory);

        EditTableCategory.setText("Edit");
        EditTableCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditTableCategoryActionPerformed(evt);
            }
        });
        PopUpMenuShortByCategory.add(EditTableCategory);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ShortByDate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ShortByDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Number Import", "Import Ids"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ShortByDate.setMaximumSize(new java.awt.Dimension(1080, 720));
        ShortByDate.getTableHeader().setReorderingAllowed(false);
        ShortByDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ImportProductManager.this.mousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(ShortByDate);

        javax.swing.GroupLayout ContainShortByDateLayout = new javax.swing.GroupLayout(ContainShortByDate);
        ContainShortByDate.setLayout(ContainShortByDateLayout);
        ContainShortByDateLayout.setHorizontalGroup(
            ContainShortByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainShortByDateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        ContainShortByDateLayout.setVerticalGroup(
            ContainShortByDateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainShortByDateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );

        ShortById.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ShortById.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Import id", "Category", "Import Product Name", "Expiry"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ShortById.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ShortByIdMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(ShortById);

        CreateImportPanel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CreateImportPanel.setText("Create New Import");
        CreateImportPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateImportPanelActionPerformed(evt);
            }
        });

        ResetBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ResetBtn.setText("Reset");
        ResetBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ContainShortByIdLayout = new javax.swing.GroupLayout(ContainShortById);
        ContainShortById.setLayout(ContainShortByIdLayout);
        ContainShortByIdLayout.setHorizontalGroup(
            ContainShortByIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ContainShortByIdLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(ContainShortByIdLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185)
                .addComponent(CreateImportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContainShortByIdLayout.setVerticalGroup(
            ContainShortByIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainShortByIdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ContainShortByIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateImportPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ResetBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        ShortByCategory.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ShortByCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Categoriy", "Number Import", "Import Detail Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ShortByCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ShortByCategoryMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(ShortByCategory);

        javax.swing.GroupLayout ContainShortByCategoryLayout = new javax.swing.GroupLayout(ContainShortByCategory);
        ContainShortByCategory.setLayout(ContainShortByCategoryLayout);
        ContainShortByCategoryLayout.setHorizontalGroup(
            ContainShortByCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainShortByCategoryLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ContainShortByCategoryLayout.setVerticalGroup(
            ContainShortByCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ContainShortByCategoryLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(102, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Import Product Manager");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(220, 220, 220))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(BackMenuBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        TypeImport.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TypeImport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID","Date","Category" }));
        TypeImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeImportActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Short By :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(494, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TypeImport, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeImport, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ContainShortByCategory, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ContainShortByDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ContainShortById, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ContainShortByDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ContainShortById, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(ContainShortByCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mousePressed
        if (evt.getClickCount() == 2) { // Kiểm tra số lần nhấp chuột là 2
            int row = ShortByDate.getSelectedRow();
            if (row >= 0) {
                String DateImport = (String) ShortByDate.getValueAt(row, 0);
                ImportDetail importDetailFrame = new ImportDetail(); 
                importDetailFrame.addDataByDate(DateImport); 
                importDetailFrame.setVisible(true); 
            }
        }
    }//GEN-LAST:event_mousePressed

    private void DeleteTableIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTableIdActionPerformed
        int selectedRow = ShortById.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) ShortById.getModel();
            int rowCount = tableModel.getRowCount();
            if (rowCount > 0) {
              
                if (selectedRow >= rowCount) {
                    // Điều chỉnh chỉ số hàng nếu ngoài giới hạn
                    selectedRow = rowCount - 1;
                }
                String importID = (String) ShortById.getValueAt(selectedRow, 0);
                tableModel.removeRow(selectedRow); // Xóa dòng khỏi mô hình bảng
                DeleteDataInDatabase(importID);
            }
        }

    }//GEN-LAST:event_DeleteTableIdActionPerformed

    private void EditTableIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditTableIdActionPerformed
        int row = ShortById.getSelectedRow();
        if (row >= 0) {
            String importID = (String) ShortById.getValueAt(row, 0);
            ImportEdit importDetailFrame = new ImportEdit();  
            importDetailFrame.populateCategoriesComboBox();
            importDetailFrame.addDataById(importID);  
            importDetailFrame.setVisible(true);  
        }

    }//GEN-LAST:event_EditTableIdActionPerformed

    private void TypeImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeImportActionPerformed

    private void DeleteTableCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTableCategoryActionPerformed
        int selectedRow = ShortByCategory.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) ShortByCategory.getModel();
            int rowCount = tableModel.getRowCount();
            if (rowCount > 0) {
                
                if (selectedRow >= rowCount) {
                    // Điều chỉnh chỉ số hàng nếu ngoài giới hạn
                    selectedRow = rowCount - 1;
                }
                String importID = (String) ShortByCategory.getValueAt(selectedRow, 1);
                DeleteDataInDatabase(importID);
            } else {
            }
        }

    }//GEN-LAST:event_DeleteTableCategoryActionPerformed
    private void DeleteDataInDatabase(String importID) {
        // Xóa dữ liệu khỏi cơ sở dữ liệu
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            // Xóa bản ghi từ bảng Import_Product_Detail
            String deleteDetailSql = "DELETE FROM Import_Product_Detail WHERE Import_Id = '" + importID + "'";
            stmt.executeUpdate(deleteDetailSql);
            // Xóa bản ghi từ bảng Import_Product
            String deleteProductSql = "DELETE FROM Import_Product WHERE Import_Id = '" + importID + "'";
            stmt.executeUpdate(deleteProductSql);
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
        JOptionPane.showMessageDialog(null, "Delete data successfully");
    }

    private void EditTableCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditTableCategoryActionPerformed

    }//GEN-LAST:event_EditTableCategoryActionPerformed

    private void ShortByCategoryMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShortByCategoryMousePressed
        if (evt.getClickCount() == 2) { // Kiểm tra số lần nhấp chuột là 2
            int row = ShortByCategory.getSelectedRow();
            if (row >= 0) {
                String importIDs = (String) ShortByCategory.getValueAt(row, 0);
                ImportDetail importDetailFrame = new ImportDetail();  
                importDetailFrame.addDataByCategory(importIDs);  
                importDetailFrame.setVisible(true);  
            }
        }
    }//GEN-LAST:event_ShortByCategoryMousePressed

    private void ShortByIdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ShortByIdMousePressed
        if (evt.getClickCount() == 2) { // Kiểm tra số lần nhấp chuột là 2
            int row = ShortById.getSelectedRow();
            if (row >= 0) {
                String importID = (String) ShortById.getValueAt(row, 0);
                ImportDetail importDetailFrame = new ImportDetail();  
                importDetailFrame.addDataById(importID);  
                importDetailFrame.setVisible(true);  
            }
        }
    }//GEN-LAST:event_ShortByIdMousePressed

    private void CreateImportPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateImportPanelActionPerformed
       
        ImportCreate importEditFrame = new ImportCreate();  
        importEditFrame.populateCategoriesComboBox();
        importEditFrame.setVisible(true);  
    }//GEN-LAST:event_CreateImportPanelActionPerformed

    private void BackMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMenuBtnActionPerformed
        ManagerMenu importDetailFrame = new ManagerMenu();
        importDetailFrame.ManagerMenu();
        importDetailFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMenuBtnActionPerformed

    private void ResetBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetBtnActionPerformed
        ImportProductManager phanloaiFrame = new ImportProductManager();
        phanloaiFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_ResetBtnActionPerformed

    //Icon PopUp Menu
    int width = 20;
    int height = 20;
    String imagePathDelete = "ImgImport/dowload.png";
    ImageIcon DeleteIcon = resizeImageIcon(imagePathDelete, width, height);
    String imagePathEdit = "ImgImport/edit.png";
    ImageIcon EditIcon = resizeImageIcon(imagePathEdit, width, height);

    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        try {
            // Đọc hình ảnh từ tệp
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            
            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = scaledImage.createGraphics();
            // Thiết lập các chỉ dẫn vẽ để giữ nguyên độ phân giải
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // Vẽ hình ảnh mới
            g2.drawImage(originalImage, 0, 0, width, height, null);
            g2.dispose();
            return new ImageIcon(scaledImage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImportProductManager();
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackMenuBtn;
    private javax.swing.JPanel ContainShortByCategory;
    private javax.swing.JPanel ContainShortByDate;
    private javax.swing.JPanel ContainShortById;
    private javax.swing.JButton CreateImportPanel;
    private javax.swing.JMenuItem DeleteTableCategory;
    private javax.swing.JMenuItem DeleteTableId;
    private javax.swing.JMenuItem EditTableCategory;
    private javax.swing.JMenuItem EditTableId;
    private javax.swing.JPopupMenu PopUpMenuShortByCategory;
    private javax.swing.JPopupMenu PopUpMenuShortById;
    private javax.swing.JButton ResetBtn;
    private javax.swing.JTable ShortByCategory;
    private javax.swing.JTable ShortByDate;
    private javax.swing.JTable ShortById;
    private javax.swing.JComboBox<String> TypeImport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

}

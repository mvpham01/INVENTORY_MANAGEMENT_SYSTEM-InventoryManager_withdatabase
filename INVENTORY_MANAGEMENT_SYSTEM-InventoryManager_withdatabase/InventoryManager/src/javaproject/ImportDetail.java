/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaproject;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class ImportDetail extends javax.swing.JFrame {

    public ImportDetail() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        //Look and feels libary
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Select Data Combobox
        populateCategoriesComboBox();
        //Popup menu
        ImportDetailTable.setComponentPopupMenu(PopUpMenu);
        //Hide panel
        EditImportDetailPanel.setVisible(false);
        CreatePanel.setVisible(false);
        pack();
        //turn off Frame
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PopUpMenu = new javax.swing.JPopupMenu();
        DeletePopUpMenu = new JMenuItem("Delete",DeleteIcon);
        EditPopUpMenu = new JMenuItem("Edit",EditIcon);
        jScrollPane1 = new javax.swing.JScrollPane();
        ImportDetailTable = new javax.swing.JTable();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BackMenuBtn = new javax.swing.JButton();
        EditImportDetailPanel = new javax.swing.JPanel();
        SaveBtn = new javax.swing.JButton();
        ImportID = new javaproject.ImportTextField();
        Expiry = new javaproject.ImportTextField();
        ImportDetailID = new javaproject.ImportTextField();
        ProductName = new javaproject.ImportTextField();
        Quantity = new javaproject.ImportTextField();
        ImportDate = new javaproject.ImportTextField();
        CategoriNameCombobox = new javax.swing.JComboBox<>();
        LabelCategoryName = new javax.swing.JLabel();
        CreatePanel = new javax.swing.JPanel();
        NewImportDetailID = new javaproject.ImportTextField();
        jLabel2 = new javax.swing.JLabel();
        NewProductNameComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        NewQuantity = new javaproject.ImportTextField();
        NewImportDate = new javaproject.ImportTextField();
        NewImportIdComboBox = new javax.swing.JComboBox<>();
        CreateDetailBtn = new javax.swing.JButton();
        NewExpiry = new javaproject.ImportTextField();
        ShowCreateDetail = new javax.swing.JButton();

        DeletePopUpMenu.setText("Delete");
        DeletePopUpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePopUpMenuActionPerformed(evt);
            }
        });
        PopUpMenu.add(DeletePopUpMenu);

        EditPopUpMenu.setText("Edit");
        EditPopUpMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPopUpMenuActionPerformed(evt);
            }
        });
        PopUpMenu.add(EditPopUpMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImportDetailTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ImportDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Import ID", "Import Detail ID", "Product Name", "Quantity_Product", "Import Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ImportDetailTable);

        Header.setBackground(new java.awt.Color(102, 255, 255));
        Header.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Import Product Detail");

        BackMenuBtn.setText("Main Menu");
        BackMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackMenuBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BackMenuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BackMenuBtn))
                    .addGroup(HeaderLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        SaveBtn.setText("Save");
        SaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveBtnActionPerformed(evt);
            }
        });

        ImportID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ImportID.setLabelText("Import ID");

        Expiry.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Expiry.setLabelText("Expiry");
        Expiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExpiryActionPerformed(evt);
            }
        });

        ImportDetailID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ImportDetailID.setLabelText("Import Detail ID");

        ProductName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ProductName.setLabelText("Product Name");

        Quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Quantity.setLabelText("Quantity Product");

        ImportDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ImportDate.setLabelText("Import Date");
        ImportDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportDateActionPerformed(evt);
            }
        });

        CategoriNameCombobox.setEditable(true);
        CategoriNameCombobox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CategoriNameCombobox.setForeground(new java.awt.Color(0, 0, 0));
        CategoriNameCombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        CategoriNameCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategoriNameComboboxActionPerformed(evt);
            }
        });

        LabelCategoryName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        LabelCategoryName.setText("Categories Name :");

        javax.swing.GroupLayout EditImportDetailPanelLayout = new javax.swing.GroupLayout(EditImportDetailPanel);
        EditImportDetailPanel.setLayout(EditImportDetailPanelLayout);
        EditImportDetailPanelLayout.setHorizontalGroup(
            EditImportDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditImportDetailPanelLayout.createSequentialGroup()
                .addGroup(EditImportDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(EditImportDetailPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(EditImportDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImportID, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ImportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(EditImportDetailPanelLayout.createSequentialGroup()
                                .addComponent(LabelCategoryName)
                                .addGap(36, 36, 36)
                                .addComponent(CategoriNameCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(EditImportDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ProductName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                .addComponent(ImportDetailID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Expiry, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(EditImportDetailPanelLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        EditImportDetailPanelLayout.setVerticalGroup(
            EditImportDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditImportDetailPanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(ImportDetailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(EditImportDetailPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCategoryName, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategoriNameCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Expiry, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(ImportID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ImportDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        NewImportDetailID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NewImportDetailID.setLabelText("Import Detail ID");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Import ID  :");

        NewProductNameComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NewProductNameComboBox.setForeground(new java.awt.Color(0, 0, 0));
        NewProductNameComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        NewProductNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProductNameComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Import Product :");

        NewQuantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NewQuantity.setLabelText("Quantity Product");

        NewImportDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NewImportDate.setLabelText("Import Date");
        NewImportDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewImportDateActionPerformed(evt);
            }
        });

        NewImportIdComboBox.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NewImportIdComboBox.setForeground(new java.awt.Color(0, 0, 0));
        NewImportIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CreateDetailBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CreateDetailBtn.setText("Create Import Detail");
        CreateDetailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateDetailBtnActionPerformed(evt);
            }
        });

        NewExpiry.setEditable(false);
        NewExpiry.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        NewExpiry.setLabelText("Expiry");

        javax.swing.GroupLayout CreatePanelLayout = new javax.swing.GroupLayout(CreatePanel);
        CreatePanel.setLayout(CreatePanelLayout);
        CreatePanelLayout.setHorizontalGroup(
            CreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePanelLayout.createSequentialGroup()
                .addGroup(CreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CreatePanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(CreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewImportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(CreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(CreatePanelLayout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NewProductNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CreatePanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NewImportIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(NewImportDetailID, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                                .addComponent(NewExpiry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(NewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CreatePanelLayout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(CreateDetailBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CreatePanelLayout.setVerticalGroup(
            CreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CreatePanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(NewImportDetailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewImportIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CreatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NewProductNameComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(NewExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NewImportDate, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NewQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(CreateDetailBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        ShowCreateDetail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ShowCreateDetail.setText("Create New Import Detail");
        ShowCreateDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowCreateDetailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(ShowCreateDetail)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditImportDetailPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreatePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(EditImportDetailPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ShowCreateDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17))
            .addComponent(CreatePanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void DeletePopUpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePopUpMenuActionPerformed
        int selectedRow = ImportDetailTable.getSelectedRow();
        if (selectedRow != -1) {
            DefaultTableModel tableModel = (DefaultTableModel) ImportDetailTable.getModel();
            int rowCount = tableModel.getRowCount();
            if (rowCount > 0) {
                if (selectedRow >= rowCount) {
                    selectedRow = rowCount - 1;
                }
                String importDetailID = (String) ImportDetailTable.getValueAt(selectedRow, 1);
                tableModel.removeRow(selectedRow);
                DeleteDataInDatabase(importDetailID);
            } else {
                // Không có dữ liệu trong bảng

            }
        }
    }//GEN-LAST:event_DeletePopUpMenuActionPerformed
    private void EditPopUpMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPopUpMenuActionPerformed
        int row = ImportDetailTable.getSelectedRow();
        if (row >= 0) {
            String importDetailID = (String) ImportDetailTable.getValueAt(row, 1);
//            ImportEditDetail importDetailFrame = new ImportEditDetail(); 

            addData(importDetailID);
//            importDetailFrame.setVisible(true);

        }
        EditImportDetailPanel.setVisible(true);
        CreatePanel.setVisible(false);
        pack();
    }//GEN-LAST:event_EditPopUpMenuActionPerformed

    private void SaveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveBtnActionPerformed
        String importID = ImportID.getText();
        Object selectedCategory = CategoriNameCombobox.getSelectedItem();
        if (selectedCategory != null) {
            String categoryName = CategoriNameCombobox.getSelectedItem().toString();
            String expiry = Expiry.getText();
            String importDetailID = ImportDetailID.getText();
            String importDate = ImportDate.getText();
            String quantity = Quantity.getText();
            String ProductName = this.ProductName.getText();
            ResultSet rs = null;
            int productID = 0;
            try {
                LocalDate.parse(importDate);
                LocalDate.parse(expiry);
                LocalDate ImportDatePase = LocalDate.parse(importDate);
                LocalDate ExpiryDatePase = LocalDate.parse(expiry);
                if (ImportDatePase.isAfter(ExpiryDatePase)) {
                    JOptionPane.showMessageDialog(null, "importDate must be before expiry !");
                    return;
                }
            } catch (DateTimeParseException e) {
                JOptionPane.showMessageDialog(null, "ImportDate is not valid  !");
                return;
            }
            if (!importID.isEmpty() && !categoryName.isEmpty() && !expiry.isEmpty() && !importDetailID.isEmpty()
                    && !importDate.isEmpty() && !quantity.isEmpty()) {
                if (quantity.matches("\\d+") && Integer.parseInt(quantity) > 0) {

                    Connection conn = MainConnection.getConnection();
                    Statement stmt = null;
                    try {
                        stmt = conn.createStatement();
                        String selectSql = "SELECT Product_ID FROM Products WHERE Product_name = '" + ProductName + "'";
                        rs = stmt.executeQuery(selectSql);
                        if (rs.next()) {
                            productID = rs.getInt("Product_ID");
                            System.out.println("Product_ID: " + productID);
                        }
                        System.out.println(categoryName);
                        System.out.println(productID);

                        // Kiểm tra xem Import_Product_Detail_ID đã tồn tại trong bảng Import_Product_Detail hay chưa
                        selectSql = "SELECT * FROM Import_Product_Detail WHERE Import_Product_Detail_ID = '" + importDetailID + "'";
                        boolean recordExists = stmt.executeQuery(selectSql).next();
                        if (recordExists) {

                            // Import_Product_Detail_ID đã tồn tại, thực hiện cập nhật dữ liệu
                            String updateSql = "UPDATE Import_Product_Detail SET Import_ID = '" + importID + "', "
                                    + "Product_ID = " + productID + ", "
                                    + "Import_Quantity_Product = " + quantity + ", "
                                    + "ImportDate = '" + importDate + "' "
                                    + "WHERE Import_Product_Detail_ID = '" + importDetailID + "'";
                            int rowsUpdated = stmt.executeUpdate(updateSql);
                            if (rowsUpdated > 0) {
                                JOptionPane.showMessageDialog(null, "The data has been updated successfully.");
                            } else {
                                JOptionPane.showMessageDialog(null, "No data has been updated.");
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
                } else {

                    JOptionPane.showMessageDialog(null, "quantity must be a positive integer !");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Content must not be blank !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Category Error !");
        }

    }//GEN-LAST:event_SaveBtnActionPerformed

    private void ExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExpiryActionPerformed
    }//GEN-LAST:event_ExpiryActionPerformed
    private void ImportDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportDateActionPerformed
    }//GEN-LAST:event_ImportDateActionPerformed
    private void CategoriNameComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategoriNameComboboxActionPerformed
    }//GEN-LAST:event_CategoriNameComboboxActionPerformed
    private void NewProductNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProductNameComboBoxActionPerformed
    }//GEN-LAST:event_NewProductNameComboBoxActionPerformed
    private void NewImportDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewImportDateActionPerformed
    }//GEN-LAST:event_NewImportDateActionPerformed

    private void CreateDetailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateDetailBtnActionPerformed
        String NewimportID = NewImportIdComboBox.getSelectedItem().toString();
        String NewcategoryName = NewImportIdComboBox.getSelectedItem().toString();
        String NewimportDetailID = NewImportDetailID.getText();
        String NewimportDate = NewImportDate.getText();
        String Newquantity = NewQuantity.getText();
        String NewExpiry = this.NewExpiry.getText();
        String NewProductName = NewProductNameComboBox.getSelectedItem().toString();
        ResultSet rs = null;
        int NewproductID = 0;
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        try {
            LocalDate.parse(NewExpiry);
            LocalDate.parse(NewimportDate);
            LocalDate ImportDatePase = LocalDate.parse(NewimportDate);
            LocalDate ExpiryDatePase = LocalDate.parse(NewExpiry);
            if (ImportDatePase.isAfter(ExpiryDatePase)) {
                JOptionPane.showMessageDialog(null, "importDate must be before expiry !");
                return;
            }
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(null, "ImportDate is not valid  !");
            return;
        }
        if (!NewimportID.isEmpty() && !NewcategoryName.isEmpty() && !NewimportDetailID.isEmpty()
                && !NewimportDate.isEmpty() && !Newquantity.isEmpty()) {
            if (Newquantity.matches("\\d+") && Integer.parseInt(Newquantity) > 0) {
                // addData

                try {
                    stmt = conn.createStatement();
                    String selectSql = "SELECT Product_ID FROM Products WHERE Product_name = '" + NewProductName + "'";
                    rs = stmt.executeQuery(selectSql);
                    if (rs.next()) {
                        NewproductID = rs.getInt("Product_ID");
                        System.out.println("Product_ID: " + NewproductID);
                    }
                    selectSql = "SELECT * FROM Import_Product_Detail WHERE Import_Product_Detail_ID = '" + NewimportDetailID + "'";
                    boolean recordExists = stmt.executeQuery(selectSql).next();
                    if (recordExists) {
                        JOptionPane.showMessageDialog(null, "Import Product Detail ID was exist");
                    } else {
                        String sql = "UPDATE Import_Product\n"
                                + "SET Categories_name = '" + NewcategoryName + "' \n"
                                + "WHERE Import_ID IN (SELECT Import_ID FROM Import_Product_Detail WHERE Import_Product_Detail_ID = '" + NewimportDetailID + "')";
                        stmt.executeUpdate(sql);
                        // Import_Product_Detail_ID không tồn tại, thực hiện thêm mới dữ liệu
                        String insertSql = "INSERT INTO Import_Product_Detail (Import_Product_Detail_ID, Import_ID, Product_ID, Import_Quantity_Product, ImportDate) "
                                + "VALUES ('" + NewimportDetailID + "', '" + NewimportID + "', " + NewproductID + ", " + Newquantity + ", '" + NewimportDate + "')";
                        int rowsInserted = stmt.executeUpdate(insertSql);
                        if (rowsInserted > 0) {
                            JOptionPane.showMessageDialog(null, "The new data has been added successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "No new data has been added.");
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
            } else {

                JOptionPane.showMessageDialog(null, "quantity must be a positive integer !");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Content must not be blank !");
        }
    }//GEN-LAST:event_CreateDetailBtnActionPerformed

    private void ShowCreateDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowCreateDetailActionPerformed
        EditImportDetailPanel.setVisible(false);
        CreatePanel.setVisible(true);
        AddExpiryDate("IMP001");
        pack();
    }//GEN-LAST:event_ShowCreateDetailActionPerformed

    private void BackMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackMenuBtnActionPerformed
        ManagerMenu importDetailFrame = new ManagerMenu();
        importDetailFrame.ManagerMenu();
        importDetailFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_BackMenuBtnActionPerformed
    private void DeleteDataInDatabase(String importDetailID) {

        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            String deleteDetailSql = "DELETE FROM Import_Product_Detail WHERE Import_Product_Detail_ID = '" + importDetailID + "'";
            System.out.println(importDetailID);
            stmt.executeUpdate(deleteDetailSql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các đối tượng Statement và Connection
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

    public void addDataById(String importID) {
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT  ipd.Import_ID,ipd.Import_Product_Detail_ID, p.Product_name, ipd.Import_Quantity_Product, ipd.ImportDate\n"
                    + "FROM Import_Product_Detail ipd\n"
                    + "JOIN Products p ON ipd.Product_ID = p.Product_ID\n"
                    + "WHERE ipd.Import_ID =  '" + importID + "';";
            rs = stmt.executeQuery(sql);
            DefaultTableModel tableModel = (DefaultTableModel) ImportDetailTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("Import_ID");
                row[1] = rs.getString("Import_Product_Detail_ID");
                row[2] = rs.getString("Product_Name");
                row[3] = rs.getString("Import_Quantity_Product");
                row[4] = rs.getString("ImportDate");
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các đối tượng Statement và Connection
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
        //Style Table and Combobox   
        SetFontTableHeader();
    }

    public void addDataByDate(String Date) {
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT ip.Import_ID,ipd.Import_Product_Detail_ID, p.Product_Name, ipd.ImportDate, ipd.Import_Quantity_Product\n"
                    + "FROM Import_Product ip\n"
                    + "INNER JOIN Import_Product_Detail ipd ON ip.Import_Id = ipd.Import_ID\n"
                    + "INNER JOIN Products p ON ipd.Product_Id = p.Product_Id\n"
                    + "WHERE ipd.ImportDate = '" + Date + "'";
            rs = stmt.executeQuery(sql);
            DefaultTableModel tableModel = (DefaultTableModel) ImportDetailTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("Import_ID");
                row[1] = rs.getString("Import_Product_Detail_ID");
                row[2] = rs.getString("Product_Name");
                row[3] = rs.getString("Import_Quantity_Product");
                row[4] = rs.getString("ImportDate");
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các đối tượng Statement và Connection
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

    public void addDataByCategory(String CategoryName) {
        System.out.println(CategoryName);
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT ip.Import_ID,ipd.Import_Product_Detail_ID, p.Product_name, ipd.Import_Quantity_Product,ipd.ImportDate\n"
                    + "FROM Import_Product_Detail ipd\n"
                    + "INNER JOIN Import_Product ip ON ipd.Import_ID = ip.Import_ID\n"
                    + "INNER JOIN Products p ON ipd.Product_ID = p.Product_ID\n"
                    + "INNER JOIN GoodsCategories gc ON p.Category_ID = gc.Category_ID\n"
                    + "WHERE ip.Categories_name ='" + CategoryName + "';";
            rs = stmt.executeQuery(sql);
            DefaultTableModel tableModel = (DefaultTableModel) ImportDetailTable.getModel();

            while (rs.next()) {
                Object[] row = new Object[5];
                row[0] = rs.getString("Import_ID");
                row[1] = rs.getString("Import_Product_Detail_ID");
                row[2] = rs.getString("Product_Name");
                row[3] = rs.getString("Import_Quantity_Product");
                row[4] = rs.getString("ImportDate");
                tableModel.addRow(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các đối tượng Statement và Connection
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

    public void addData(String importDetail) {
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT ipd.Import_Product_Detail_ID, ip.Categories_name, p.Product_Name, ipd.ImportDate, ipd.Import_Quantity_Product,ip.Import_ID,ip.Expiry\n"
                    + "FROM Import_Product ip\n"
                    + "INNER JOIN Import_Product_Detail ipd ON ip.Import_Id = ipd.Import_ID\n"
                    + "INNER JOIN Products p ON ipd.Product_Id = p.Product_Id\n"
                    + "WHERE ipd.Import_Product_Detail_ID = '" + importDetail + "';";
            rs = stmt.executeQuery(sql);
            // Process the ResultSet and populate the DataTable
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            if (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    String columnValue = rs.getString(i);
                    // Update the corresponding text field with the column value
                    switch (columnName) {
                        case "Import_ID":
                            ImportID.setText(columnValue);
                            ImportID.setEditable(false);
                            break;
                        case "Categories_name":
                            // Set the default value of the combo box
                            CategoriNameCombobox.setSelectedItem(columnValue);
                            CategoriNameCombobox.setEditable(false);
                            break;
                        case "Expiry":
                            String ExpiryDate = columnValue.substring(0, 10);
                            Expiry.setText(ExpiryDate);
                            Expiry.setEditable(false);

                            break;
                        case "Import_Product_Detail_ID":
                            ImportDetailID.setText(columnValue);
                            ImportDetailID.setEditable(false);

                            break;
                        case "Product_Name":
                            ProductName.setText(columnValue);
                            ProductName.setEditable(false);
                            break;
                        case "ImportDate":
                            String importDate = columnValue.substring(0, 10);
                            ImportDate.setText(importDate);
                            break;
                        case "Import_Quantity_Product":
                            Quantity.setText(columnValue);
                            break;
                        default:
                            break;
                    }
                }
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

    public void populateCategoriesComboBox() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = MainConnection.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT Category_name FROM GoodsCategories";
            rs = stmt.executeQuery(sql);
            CategoriNameCombobox.removeAllItems();

            //
            sql = "SELECT Import_ID FROM Import_Product";
            rs = stmt.executeQuery(sql);
            NewImportIdComboBox.removeAllItems();
            while (rs.next()) {
                String importid = rs.getString("Import_ID");
                NewImportIdComboBox.addItem(importid);
            }
            //
            NewImportIdComboBox.addActionListener(e -> {
                JComboBox comboBox = (JComboBox) e.getSource();
                String selectedImportId = comboBox.getSelectedItem() != null ? comboBox.getSelectedItem().toString() : "";
                AddExpiryDate(selectedImportId);
            });
            //
            sql = "SELECT Product_name FROM Products";
            rs = stmt.executeQuery(sql);
            NewProductNameComboBox.removeAllItems();
            while (rs.next()) {
                String Product_name = rs.getString("Product_name");
                NewProductNameComboBox.addItem(Product_name);
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
        CategoriNameCombobox.setRenderer(new DefaultListCellRenderer() {
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
        JTableHeader tableHeader1 = ImportDetailTable.getTableHeader();
        tableHeader1.setFont(headerFont);
        tableHeader1.setBackground(Color.black);

    }
    int width = 20;
    int height = 20;
    String imagePathDelete = "ImgImport/dowload.png";
    ImageIcon DeleteIcon = resizeImageIcon(imagePathDelete, width, height);
    String imagePathEdit = "ImgImport/edit.png";
    ImageIcon EditIcon = resizeImageIcon(imagePathEdit, width, height);

    private ImageIcon resizeImageIcon(String imagePath, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = scaledImage.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // Vẽ hình ảnh mới với kích thước mới
            g2.drawImage(originalImage, 0, 0, width, height, null);
            g2.dispose();
            // Tạo ImageIcon mới từ hình ảnh đã thay đổi kích thước
            return new ImageIcon(scaledImage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private void AddExpiryDate(String selectedImportId) {
        Connection conn = MainConnection.getConnection();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.createStatement();
            String sql = "SELECT Expiry FROM  [dbo].[Import_Product] Where [Import_ID] ='" + selectedImportId + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String ExpiryDatedemo = rs.getString("Expiry");
                String ExpiryDate = ExpiryDatedemo.substring(0, 10);
                NewExpiry.setText(ExpiryDate);
            } else {
                // Không có dòng dữ liệu tồn tại, xử lý tương ứng
                System.out.println("No data found in the ResultSet.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng tất cả các đối tượng Statement và Connection
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

    public void closeFrame() {
        SwingUtilities.invokeLater(() -> {
            WindowEvent windowClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(windowClosing);
            dispose();
        });
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImportDetail().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackMenuBtn;
    private javax.swing.JComboBox<String> CategoriNameCombobox;
    public javax.swing.JButton CreateDetailBtn;
    private javax.swing.JPanel CreatePanel;
    private javax.swing.JMenuItem DeletePopUpMenu;
    private javax.swing.JPanel EditImportDetailPanel;
    private javax.swing.JMenuItem EditPopUpMenu;
    private javaproject.ImportTextField Expiry;
    private javax.swing.JPanel Header;
    private javaproject.ImportTextField ImportDate;
    private javaproject.ImportTextField ImportDetailID;
    private javax.swing.JTable ImportDetailTable;
    private javaproject.ImportTextField ImportID;
    private javax.swing.JLabel LabelCategoryName;
    private javaproject.ImportTextField NewExpiry;
    private javaproject.ImportTextField NewImportDate;
    private javaproject.ImportTextField NewImportDetailID;
    private javax.swing.JComboBox<String> NewImportIdComboBox;
    private javax.swing.JComboBox<String> NewProductNameComboBox;
    private javaproject.ImportTextField NewQuantity;
    private javax.swing.JPopupMenu PopUpMenu;
    private javaproject.ImportTextField ProductName;
    private javaproject.ImportTextField Quantity;
    public javax.swing.JButton SaveBtn;
    private javax.swing.JButton ShowCreateDetail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}

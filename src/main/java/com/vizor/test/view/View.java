package com.vizor.test.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.File;

public class View extends javax.swing.JFrame {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    DefaultTableModel model;




    public void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setTitle("DT Developer Test");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane1.setViewportView(jTable1);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
        addTableHeader();
        getImagesFromFolder();
    }


    public void addTableHeader() {
        model = (DefaultTableModel) jTable1.getModel();
        Object[] newIdentifiers = new Object[]{"Name", "Image"};
        model.setColumnIdentifiers(newIdentifiers);
        jTable1.setFillsViewportHeight(true);
        jTable1.getColumn("Image").setCellRenderer(new CellRenderer());
    }

    public void getImagesFromFolder() {
        File folder = new File("C:\\Users\\Viktor\\IdeaProjects\\dt-developer-test\\assets");
        File[] listOfFiles = folder.listFiles();

        //get each picture from the folder and display it on UI
        for (File file : listOfFiles) {
            if (file.isFile()) {
                JLabel imageLabel = new JLabel();
                ImageIcon imageicon = new ImageIcon(file.getPath());
                Image img = imageicon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
                model.addRow(new Object[]{file.getName(), imageLabel});
            }
        }
    }

    class CellRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table,
                                                       Object value,
                                                       boolean isSelected,
                                                       boolean hasFocus,
                                                       int row,
                                                       int column) {

            TableColumn tb = jTable1.getColumn("Image");
            tb.setMaxWidth(120);
            tb.setMinWidth(120);
            jTable1.setRowHeight(120);
            return (Component) value;
        }
    }
}
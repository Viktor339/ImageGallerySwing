package com.vizor.test.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class View extends javax.swing.JFrame {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private DefaultTableModel tableModel;
    private javax.swing.JButton jButtonBrowseImage;
    private javax.swing.JTextField searchTxt;


    public void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonBrowseImage = new javax.swing.JButton();
        searchTxt = new javax.swing.JTextField();

        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setTitle("DT Developer Test");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
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

        jScrollPane.setViewportView(jTable);

        jButtonBrowseImage.setText("Open");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonBrowseImage)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButtonBrowseImage)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(searchTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        pack();
        addTableHeader();
        getImagesFromFolder();
    }


    public void addTableHeader() {
        tableModel = (DefaultTableModel) jTable.getModel();
        Object[] newIdentifiers = new Object[]{"Name", "Image"};
        tableModel.setColumnIdentifiers(newIdentifiers);
        jTable.setFillsViewportHeight(true);
        jTable.getColumn("Image").setCellRenderer(new CellRenderer());
    }

    public void getImagesFromFolder() {
        Path currentRelativePath = Paths.get("");
        String currentFolderPath = currentRelativePath.toAbsolutePath().toString();
        File folder = new File(currentFolderPath + "/assets");
        File[] listOfFiles = folder.listFiles();

        //get each picture from the folder and display it on UI
        for (File file : listOfFiles) {
            if (file.isFile()) {
                JLabel imageLabel = new JLabel();
                ImageIcon imageicon = new ImageIcon(file.getPath());
                Image img = imageicon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
                tableModel.addRow(new Object[]{file.getName(), imageLabel});
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

            TableColumn tb = jTable.getColumn("Image");
            tb.setMaxWidth(120);
            tb.setMinWidth(120);
            jTable.setRowHeight(120);
            return (Component) value;
        }
    }

    public void addJButtonListener(ActionListener jButtonListener) {
        jButtonBrowseImage.addActionListener(jButtonListener);
    }

    public void addSearchTxtListener(KeyListener keyTxtListener) {
        searchTxt.addKeyListener(keyTxtListener);
    }

    public void addJTableMouseListener(MouseAdapter mouseAdapter) {
        jTable.addMouseListener(mouseAdapter);
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public JTable getJTable() {
        return jTable;
    }

    public JTextField getSearchTxt() {
        return searchTxt;
    }
}

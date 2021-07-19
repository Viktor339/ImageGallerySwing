package com.vizor.test.model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.File;
import java.nio.file.Paths;

public class Model {
    private final String currentFolderPath = Paths.get("").toAbsolutePath().toString();
    private JFrame_Show_Images jFrameShowFullSizeImages = new JFrame_Show_Images();


    public Object[] actionForJButtonListener() {
        //select the required images
        JFileChooser browseImageFile = new JFileChooser(currentFolderPath + "/assets");
        FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("IMAGES", "png");
        browseImageFile.addChoosableFileFilter(fileFilter);

        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();

            // add selected images and display them on UI
            JLabel imageLabel = new JLabel();
            ImageIcon imageicon = new ImageIcon(selectedImagePath);
            Image img = imageicon.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(img));
            return new Object[]{selectedImageFile.getName(), imageLabel};
        }
        return null;
    }

    public void actionForSearchTxtListener(JTable jTable, JTextField searchTxt) {
        // enter the required name of the image
        DefaultTableModel table = (DefaultTableModel) jTable.getModel();
        String searchQuery = searchTxt.getText().toLowerCase();

        //displaying the query result
        TableRowSorter<DefaultTableModel> tableSorter = new TableRowSorter<DefaultTableModel>(table);
        jTable.setRowSorter(tableSorter);
        tableSorter.setRowFilter(RowFilter.regexFilter(searchQuery));
    }

    public void actionForJTableMouseListener(JTable jTable) {
        // get the index of the selected row
        int row = jTable.getSelectedRow();
        int imageIndex = jTable.convertRowIndexToModel(row);

        // get the image name using jtable model
        TableModel model = jTable.getModel();
        String imageName = model.getValueAt(imageIndex, 0).toString();

        jFrameShowFullSizeImages.setVisible(true);
        jFrameShowFullSizeImages.pack();
        jFrameShowFullSizeImages.setLocationRelativeTo(null);
        jFrameShowFullSizeImages.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ImageIcon icon = new ImageIcon(currentFolderPath + "/assets/" + imageName);
        Image image = icon.getImage();
        jFrameShowFullSizeImages.jLabel_Show_Image.setIcon(new ImageIcon(image));
    }

    public class JFrame_Show_Images extends javax.swing.JFrame {
        public javax.swing.JLabel jLabel_Show_Image;

        public JFrame_Show_Images() {
            initComponents();
        }

        @SuppressWarnings("unchecked")
        private void initComponents() {

            jLabel_Show_Image = new javax.swing.JLabel();
            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Show_Image, javax.swing.GroupLayout.DEFAULT_SIZE, 954, Short.MAX_VALUE)
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Show_Image, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
            );
            pack();
        }
    }
}

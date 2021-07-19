package com.vizor.test.model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Model {

    public Object[] actionForJButtonListener() {
        //select the required images
        Path currentRelativePath = Paths.get("");
        String currentFolderPath = currentRelativePath.toAbsolutePath().toString();
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
}

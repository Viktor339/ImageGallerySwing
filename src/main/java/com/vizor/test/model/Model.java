package com.vizor.test.model;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class Model {

    public Object[] actionForJButtonListener() {
        //select the required images
        JFileChooser browseImageFile = new JFileChooser("C:\\Users\\Viktor\\IdeaProjects\\Heap\\src\\dtdevelopertest\\assets");
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
}

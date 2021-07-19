package com.vizor.test.controller;

import com.vizor.test.model.Model;
import com.vizor.test.view.View;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addJButtonListener(new ButtonListener());
        this.view.addSearchTxtListener(new SearchTxt());
    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object[] addedImage = model.actionForJButtonListener();
            if (addedImage != null) {
                view.getTableModel().addRow(addedImage);
                JOptionPane.showMessageDialog(null, "Image is added");
            }
        }
    }

    class SearchTxt extends KeyAdapter {
        public void keyReleased(KeyEvent e) {
            JTable jTable = view.getJTable();
            JTextField searchTxt= view.getSearchTxt();
            model.actionForSearchTxtListener(jTable,searchTxt);
        }
    }
}

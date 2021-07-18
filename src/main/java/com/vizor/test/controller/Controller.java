package com.vizor.test.controller;

import com.vizor.test.model.Model;
import com.vizor.test.view.View;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Controller {
    View view;
    Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addJButtonListener(new ButtonListener());

    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            view.getTableModel().addRow(model.actionForJButtonListener());
            JOptionPane.showMessageDialog(null, "Image is added");
        }
    }
}

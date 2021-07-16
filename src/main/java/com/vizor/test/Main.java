package com.vizor.test;

import com.vizor.test.controller.Controller;
import com.vizor.test.model.Model;
import com.vizor.test.view.View;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class Main {


    private static final int WIDTH = 1024;
    private static final int HEIGHT = 768;

//    public void run() {
//        JFrame frame = new JFrame("DT Developer Test");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
//        frame.setVisible(true);
//        frame.setLocationRelativeTo(null);
//    }

   // public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Main()::run);
//    }

    public static void main(String args[]) {
        View view =new View();
        view.initComponents();
        Model model = new Model();
        Controller controller = new Controller(view,model);

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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // JFrame frame = new JFrame("DT Developer Test");
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setMinimumSize(new Dimension(WIDTH, HEIGHT));
//                frame.setVisible(true);
//                frame.setLocationRelativeTo(null);
                view.setVisible(true);
            }

        });
    }
}

package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Seleccion {
    public JPanel MainPanel;
    private JButton ingresarButton;
    private JButton buscarButton;
    private JButton actualizarButton;
    private JButton eliminarButton;

    public Seleccion() {
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                frame.setContentPane(new Actualizar().MainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(500,500);
                frame.setVisible(true);
                ((JFrame)SwingUtilities.getWindowAncestor(actualizarButton)).dispose();
            }
        });
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}

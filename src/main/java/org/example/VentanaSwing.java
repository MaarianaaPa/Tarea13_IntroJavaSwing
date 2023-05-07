package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaSwing extends JFrame {
    //conversor C a F
    // etiqueta, boton, cuadro de text, etiqueta
    private JLabel etiqueta1;
    private JTextField txtGrados;
    private JButton boton;
    private JLabel lblResultado;

    // de awt para las disposiciones
    private FlowLayout layout;

    //const por defecto sobreescribiendo JFrame
    public VentanaSwing(String title) throws HeadlessException {
        super(title);
        //
        this.setSize(800, 600);

        layout = new FlowLayout();
        // awt agregamos contenedor para organizar los componentes
        // obtenemos el componente y le ponemos el layaout
        this.getContentPane().setLayout(layout);
        etiqueta1 = new JLabel("Grados C ");
        //agregamos
        this.getContentPane().add(etiqueta1);

        txtGrados = new JTextField(10);
        this.getContentPane().add(txtGrados);

        // boton
        boton = new JButton("Convertir");
        // agregamos y obtenemos el boton del panel
        this.getContentPane().add(boton);

        lblResultado = new JLabel("0.0 F°");
        this.getContentPane().add(lblResultado);
        // agregamos el evento sobre el boton

        this.boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // super.mouseClicked(e);
                // convierte string a ese tipo de dato (Text)
                // excepcion de tipo formato numerico
                double centigrados = Double.parseDouble(txtGrados.getText());
                double farenheit = (centigrados * 9.0 / 5.0) + 32;
                lblResultado.setText(farenheit + "°F");
            }
        });
        // agregamos el evento a ventana
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //super.windowClosing(e);
                JOptionPane.showMessageDialog(null, "Adios");
                System.exit(0);
            }
        });
        this.setVisible(true);
    }
}

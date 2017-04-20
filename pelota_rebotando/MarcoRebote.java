package ProConcurrente;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MarcoRebote extends JFrame {

    Thread t1, t2, t3;
    JButton bola1, bola2, bola3;
    JButton detener1, detener2, detener3;

    private LaminaPelota lamina;

    public MarcoRebote() {
        JPanel laminaBotones = new JPanel();
        setBounds(600, 300, 600, 350);

        setTitle("Rebotes");

        bola1 = new JButton("hilo 1");
        bola2 = new JButton("hilo 2");
        bola3 = new JButton("hilo 3");
        detener1 = new JButton("detener 1");
        detener2 = new JButton("detener 2");
        detener3 = new JButton("detener 3");

        bola1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                comienza_el_juego(ae);
            }
        });
        bola2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                comienza_el_juego(ae);
            }
        });
        bola3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                comienza_el_juego(ae);
            }
        });
        detener1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                detener(ae);
            }
        });
        detener2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                detener(ae);
            }
        });
        detener3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                detener(ae);
            }
        });

        lamina = new LaminaPelota();

        add(lamina, BorderLayout.CENTER);

        add(laminaBotones, BorderLayout.SOUTH);
        laminaBotones.add(bola1);
        laminaBotones.add(bola2);
        laminaBotones.add(bola3);
        laminaBotones.add(detener1);
        laminaBotones.add(detener2);
        laminaBotones.add(detener3);
    }

    public void comienza_el_juego(ActionEvent ae) {
        Pelota pelota = new Pelota();
        lamina.add(pelota);
        Runnable r = new PelotaHilos(pelota, lamina);
        if (ae.getSource().equals(bola1)) {
            t1 = new Thread(r);
            t1.start();
        } else if (ae.getSource().equals(bola2)) {
            t2 = new Thread(r);
            t2.start();
        } else if (ae.getSource().equals(bola3)) {
            t3 = new Thread(r);
            t3.start();
        }
    }
    
    public void detener(ActionEvent ae) {

        if (ae.getSource().equals(detener1)) {
            t1.interrupt();
        } else if (ae.getSource().equals(detener2)) {
            t2.interrupt();
        } else if (ae.getSource().equals(detener3)) {
            t3.interrupt();
        }
    }
}

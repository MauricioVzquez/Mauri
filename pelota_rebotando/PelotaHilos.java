package ProConcurrente;

import java.awt.Component;

public class PelotaHilos implements Runnable {

    private Pelota pelota;
    private Component componente;

    public PelotaHilos(Pelota unaPelota, Component unComponente) {
        pelota = unaPelota;
        componente = unComponente;
    }

    @Override
    public void run() {
        System.out.println("Estado del hilo al comenzar: " + Thread.currentThread().isInterrupted());
        while (!Thread.currentThread().isInterrupted()) {
            pelota.mueve_pelota(componente.getBounds());
            componente.paint(componente.getGraphics());

            try {
                Thread.sleep(4);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Estado del hilo al terminar: " + Thread.currentThread().isInterrupted());
    }
}

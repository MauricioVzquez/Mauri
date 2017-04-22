package bancossinsincronizar;


public class EjecucionTransferencia implements Runnable {
    
    private Banco banco;
    private int deLaCuenta;
    private double cantidadMax;
    
    public EjecucionTransferencia(Banco b,int de,double max){
       banco=b; 
       deLaCuenta=de;
       cantidadMax=max;
    }

    @Override
    public void run() {
        while(true){
           int paraLaCuenta=(int)(100*Math.random()); 
           double cantidad=cantidadMax*Math.random();
            try {
                banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
            } catch (InterruptedException ex) {
            }
            try {
                Thread.sleep((int)(Math.random()*10));
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
}

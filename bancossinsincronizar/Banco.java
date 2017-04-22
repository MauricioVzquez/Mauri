package bancossinsincronizar;

//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final double[] cuentas;
//    private Lock cierreBanco=new ReentrantLock();
//    private Condition saldoSuficiente;
    
    public Banco(){
        cuentas=new double[100];
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i]=2000;
            
        }
       // saldoSuficiente=cierreBanco.newCondition();
    }
    
    public synchronized void transferencia(int cuentaOrigen,int cuentaDestino,double cantidad) throws InterruptedException{
       // cierreBanco.lock();
       // try{
            
        while(cuentas[cuentaOrigen]<cantidad){
            wait();
           // saldoSuficiente.await();
        }
        System.out.println(Thread.currentThread());
        
        cuentas[cuentaOrigen]-=cantidad;
        System.out.printf("%10.2f de %d para %d",cantidad,cuentaOrigen,cuentaDestino);
        cuentas[cuentaDestino]+=cantidad;
        System.out.printf(" Saldo total: %10.2f%n",getSaldoTotal());
        
//        saldoSuficiente.signalAll();

        notifyAll();
//    }finally{
//            cierreBanco.unlock();
//        }
    }
    
    public double getSaldoTotal(){
        double suma_cuentas=0;
        
        for(double a: cuentas){
            suma_cuentas+=a;
        }
        return suma_cuentas;
    }
}

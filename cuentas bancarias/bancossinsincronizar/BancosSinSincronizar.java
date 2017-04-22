package bancossinsincronizar;

public class BancosSinSincronizar {

    public static void main(String[] args) {
        Banco b=new Banco();
        for(int i=0;i<100;i++){
            EjecucionTransferencia r=new EjecucionTransferencia(b, i, 2000);
            Thread t=new Thread(r);
            t.start();
        }

    }
    
}

package Menu;
import gui.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/*Integrantes:
Isaac Perez Segura
Mauricio Vázquez Valdivia
María Fernanda Escobedo Rodríguez
*/
public class Menu {
   public static void main(String [] args){
      Marco gui=new Marco();
        gui.setTitle("GUI");
        gui.setVisible(true);
        gui.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gui.setSize(1000,500); 
   } 
}

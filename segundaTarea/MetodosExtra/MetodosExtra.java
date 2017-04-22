package MetodosExtra;
import Figuras.*;
public class MetodosExtra{
public MiFigura[] moverRectas(MiFigura[] m, int t,int indice){
    if(t==1){
     m[indice].setY1(m[indice].getY1()-5);
     m[indice].setY2(m[indice].getY2()-5);
    }else if(t==2){
       m[indice].setY1(m[indice].getY1()+5);
     m[indice].setY2(m[indice].getY2()+5);
    }else if(t==3){
      m[indice].setX1(m[indice].getX1()+5);
      m[indice].setX2(m[indice].getX2()+5); 
    }else if(t==4){
      m[indice].setX1(m[indice].getX1()-5);
      m[indice].setX2(m[indice].getX2()-5); 
    }
     return m;
}
public MiFiguraDelimitada[] moverOR(MiFiguraDelimitada[] m, int t,int indice){
    if(t==1){
     m[indice].setY(m[indice].getY()-5); 
    }else if(t==2){
      m[indice].setY(m[indice].getY()+5);  
    }else if(t==3){
      m[indice].setX(m[indice].getX()+5);  
    }else if(t==4){
      m[indice].setX(m[indice].getX()-5);  
    }
     return m;
}
}

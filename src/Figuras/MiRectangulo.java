package Figuras;
import java.awt.Color;
import java.awt.Graphics;

public class MiRectangulo extends MiFiguraDelimitada{
public MiRectangulo(int x,int y,int w,int h, String t){
super(x,y,w,h,t);
}    
public MiRectangulo(int x, int y, int w, int h, String t, Color c, boolean r){
   super(x,y,w,h,t,c,r);
}    

 @Override
 public void dibujar(Graphics g){
     g.setColor(this.getColor());
     if(!getRelleno()){
    g.drawRect(this.getX(), this.getY(), this.getW(), this.getH());
     }else if(getRelleno()){
        g.fillRect(this.getX(), this.getY(), this.getW(), this.getH());
     }
 }
}

package Figuras;
import java.awt.Color;
import java.awt.Graphics;

public class MiOvalo extends MiFiguraDelimitada{
public MiOvalo(int x,int y,int w,int h,String t){
super(x,y,w,h,t);
}
public MiOvalo(int x, int y, int w, int h, String t, Color c, boolean r){
super(x,y,w,h,t,c,r);
} 

@Override
public void dibujar(Graphics g){
    g.setColor(this.getColor());
    if(this.getRelleno()){
        g.fillOval(this.getX(), this.getY(), this.getW(), this.getH());
    }else if(!this.getRelleno()){
        g.drawOval(this.getX(), this.getY(), this.getW(), this.getH());
    }
}
}

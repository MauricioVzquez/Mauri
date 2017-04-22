package Figuras;
import java.awt.Color;
import java.awt.Graphics;

public class MiLinea extends MiFigura{
public MiLinea(int x1,int y1,int x2,int y2){
super(x1,y1,x2,y2);
}    
public MiLinea(int x1, int y1, int x2, int y2, Color c){
super(x1,y1,x2,y2,c);
}    
@Override
public void dibujar(Graphics g){
g.setColor(this.getColor());
g.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());
}
}

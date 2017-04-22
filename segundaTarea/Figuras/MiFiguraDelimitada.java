package Figuras;

import java.awt.Color;
import java.awt.Graphics;

/*Clase usada para rectangulo y ovalo*/
public abstract class MiFiguraDelimitada {
// w= ancho h= altura
private int x,y,w,h;
private String tipo;
private Color color;
private boolean relleno;
public MiFiguraDelimitada(int x,int y,int w, int h,String t){
 this.x=x;
 this.y=y;
 this.w=w;
 this.h=h;
 this.color=Color.BLACK;
 this.relleno=false;
 this.tipo=t;
}
public MiFiguraDelimitada(int x, int y, int w,int h, String t, Color c, boolean r){
    this.x=x;
    this.y=y;
    this.w=w;
    this.h=h;
    this.tipo=t;
    this.color=c;
    this.relleno=r;
}

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean getRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public String getTipo() {
        return tipo;
    }

abstract public void dibujar(Graphics g);
}

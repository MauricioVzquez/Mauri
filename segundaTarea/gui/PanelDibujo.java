package gui;
import Figuras.*;
import MetodosExtra.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

 public class PanelDibujo extends JPanel{
    private final JCheckBox relleno;
    private final JPanel menu;
    private final JComboBox figurasCreadas,figurasC,colorC;
    private final MetodosExtra metodosExtra;
    private final JButton arriba,abajo,izquierda,derecha,limpiar,borrar;
    private int x1,x2,y1,y2;
    private  MiFigura [] misfiguras;
    private  MiFiguraDelimitada [] misFigurasD;      
    public int cuentaFigura;
    private MiFigura figuraActual;
    private MiFiguraDelimitada figuraActualD;
    private final Color [] colorActual={null,Color.RED,Color.BLUE,Color.GREEN,Color.CYAN};
    private boolean figuraRellena;
    private final JLabel etiquetaEstado;
    private final EventosRaton eventosMouse;
    private final EventosCheckBox rellenoListener;
    private final EventosComboBox eventCombo;
    private final EventosBotones eventBotones;
 public PanelDibujo(){
        setBackground(Color.WHITE);
        setLayout(new BorderLayout(5,5));
        //Panel que contiene botones,comboBox y checkBox
        menu=new JPanel(new FlowLayout());
        add(menu,BorderLayout.NORTH);
        //Construccion del objeto que contiene todos los metodos extra
        metodosExtra=new MetodosExtra();
         //Construccion de boton que borra figura
        borrar=new JButton("Borrar");
        menu.add(borrar);
        //Construccion de boton que limpia el panel
        limpiar=new JButton("Limpiar");
        menu.add(limpiar);
        //Construccion de ComboBox sobre colores disponibles
        colorC=new JComboBox();
        colorC.addItem("-----");
        colorC.addItem("Rojo");
        colorC.addItem("Azul");
        colorC.addItem("Verde");
        colorC.addItem("Cianico");
        menu.add(colorC);
          //Construccion de ComboBox sobre figuras disponibles
        figurasC=new JComboBox();
        figurasC.addItem("-----");
        figurasC.addItem("Linea");
        figurasC.addItem("Rectangulo");
        figurasC.addItem("Ovalo");
        menu.add(figurasC);
        /*Construccion de ComboBox sobre las figuras que ya han sido creadas
        para borrarlas a libertad o modificarlas*/
        figurasCreadas=new JComboBox();
        menu.add(figurasCreadas);
        //Construccion de CheckBox que indica si tiene relleno o no
        relleno=new JCheckBox("Relleno");
        menu.add(relleno);
        //Botones que mueven las figuras
        arriba=new JButton(new ImageIcon(getClass().getResource("/Iconos/arriba.png")));
        derecha=new JButton(new ImageIcon(getClass().getResource("/Iconos/derecha.png")));
        abajo=new JButton(new ImageIcon(getClass().getResource("/Iconos/abajo.png")));
        izquierda=new JButton(new ImageIcon(getClass().getResource("/Iconos/izquierda.png")));
        menu.add(arriba); menu.add(abajo);
        menu.add(izquierda); menu.add(derecha);

  /*Construccion de variables*/
  misfiguras = new MiFigura[100];
  misFigurasD = new MiFiguraDelimitada[100];
  cuentaFigura=0;
  figuraActual=null;
  figuraActualD=null;
  //Etiqueta que muestra coordenadas del mouse
  etiquetaEstado=new JLabel();
  add(etiquetaEstado,BorderLayout.SOUTH);
  //Construccion de eventos del mouseMotion
  eventosMouse=new EventosRaton();
  this.addMouseMotionListener(eventosMouse);
  //Construccion de eventos del mouse
  this.addMouseListener(eventosMouse);
  //Eventos de relleno
  rellenoListener=new EventosCheckBox();
  relleno.addItemListener(rellenoListener);
  //Eventos de color
  eventCombo=new EventosComboBox();
  //cambia color de la figura
  colorC.addItemListener(eventCombo);
  //Adapta los componentes segun la figura
  figurasCreadas.addItemListener(eventCombo);
  //Eventos de los botones
  eventBotones=new EventosBotones();
  //Limpia pantalla
  limpiar.addActionListener(eventBotones);
  //Borra ultima figura colocada
  borrar.addActionListener(eventBotones);
  //Eventos de cambio de posicion
  arriba.addActionListener(eventBotones); 
  abajo.addActionListener(eventBotones);
  derecha.addActionListener(eventBotones);
  izquierda.addActionListener(eventBotones);
}
public void crearFigura(int x1,int x2,int y1, int y2){
    if((Math.abs(x1-x2)>0)){
        switch (figurasC.getSelectedIndex()) {
            case 1:
                figuraActual=new MiLinea(x1,y1,x2,y2,colorActual[colorC.getSelectedIndex()]);
                misfiguras[cuentaFigura]=figuraActual;
                misFigurasD[cuentaFigura]=null;
                figurasCreadas.addItem(figuraActual.getTipo()+" "+(cuentaFigura+1));
                cuentaFigura=cuentaFigura+1;
                break;
            case 2:
                relleno.setEnabled(true);
                figuraActualD=new MiRectangulo(x1,y1,Math.abs(x1-x2),Math.abs(y1-y2)
                        ,"Rectangulo",colorActual[colorC.getSelectedIndex()],relleno.isSelected());
                misFigurasD[cuentaFigura]=figuraActualD;
                figurasCreadas.addItem(figuraActualD.getTipo()+" "+(cuentaFigura+1));
                cuentaFigura=cuentaFigura+1;
                break;
            case 3:
                relleno.setEnabled(true);
                figuraActualD=new MiOvalo(x1,y1,Math.abs(x1-x2),Math.abs(y1-y2)
                        ,"Ovalo",colorActual[colorC.getSelectedIndex()],relleno.isSelected());
                misFigurasD[cuentaFigura]=figuraActualD;
                figurasCreadas.addItem(figuraActualD.getTipo()+" "+(cuentaFigura+1));
                cuentaFigura=cuentaFigura+1;
                break;
        }
        repaint();
}
}
public void borrarUltimaFigura(){
 if(cuentaFigura>=1){
 if(misfiguras[cuentaFigura-1]==null){
    misFigurasD[cuentaFigura-1]=null;
}else if(misFigurasD[cuentaFigura-1]==null){
    misfiguras[cuentaFigura-1]=null;
}
 figurasCreadas.removeItemAt(cuentaFigura-1);
 cuentaFigura=cuentaFigura-1;
 repaint();
 }
}
public void borrarDibujo(){
   for(int i=0;i<=cuentaFigura;i++){
      misfiguras [i]=null;
      misFigurasD[i]=null;
}
    figuraActual=null;
    figurasCreadas.removeAllItems();
    setCuentaFigura(0);
    repaint();
}
private class EventosBotones implements ActionListener{
     @Override
     public void actionPerformed(ActionEvent e){
         if(e.getSource()==limpiar){
             borrarDibujo();
         }else if(e.getSource()==borrar){
             borrarUltimaFigura();
         }else if(e.getSource()==arriba && figurasCreadas.getSelectedIndex()>=0){
             if(misfiguras[figurasCreadas.getSelectedIndex()]!=null){
                misfiguras=metodosExtra.moverRectas(misfiguras,1,figurasCreadas.getSelectedIndex());
             }else if(misFigurasD[figurasCreadas.getSelectedIndex()]!=null){
                misFigurasD=metodosExtra.moverOR(misFigurasD,1,figurasCreadas.getSelectedIndex());
             }   
         }else if(e.getSource()==abajo && figurasCreadas.getSelectedIndex()>=0){
             if(misfiguras[figurasCreadas.getSelectedIndex()]!=null){
                misfiguras=metodosExtra.moverRectas(misfiguras,2,figurasCreadas.getSelectedIndex());
             }else if(misFigurasD[figurasCreadas.getSelectedIndex()]!=null){
                misFigurasD=metodosExtra.moverOR(misFigurasD,2,figurasCreadas.getSelectedIndex());
             }  
         }else if(e.getSource()==derecha && figurasCreadas.getSelectedIndex()>=0){
             if(misfiguras[figurasCreadas.getSelectedIndex()]!=null){
                misfiguras=metodosExtra.moverRectas(misfiguras,3,figurasCreadas.getSelectedIndex());
             }else if(misFigurasD[figurasCreadas.getSelectedIndex()]!=null){
                misFigurasD=metodosExtra.moverOR(misFigurasD,3,figurasCreadas.getSelectedIndex());
             }  
         }else if(e.getSource()==izquierda && figurasCreadas.getSelectedIndex()>=0){
             if(misfiguras[figurasCreadas.getSelectedIndex()]!=null){
                misfiguras=metodosExtra.moverRectas(misfiguras,4,figurasCreadas.getSelectedIndex());
             }else if(misFigurasD[figurasCreadas.getSelectedIndex()]!=null){
                misFigurasD=metodosExtra.moverOR(misFigurasD,4,figurasCreadas.getSelectedIndex());
             }  
         }
         repaint();
     }
 }
//Clase de que responde a los eventos del mouse
private class EventosRaton extends MouseAdapter implements MouseMotionListener{
//Eventos que ocurren al presionar el mouse
@Override
public void mousePressed(MouseEvent e){
    x1=e.getX();
    y1=e.getY();
}
//Eventos que ocurren al dejar de presionar el mouse
@Override
public void mouseReleased (MouseEvent e){
    x2=e.getX();
    y2=e.getY();
    crearFigura(x1,x2,y1,y2);
}
@Override
public void mouseMoved(MouseEvent e){
    etiquetaEstado.setText(e.getX()+","+e.getY());
}
@Override
public void mouseDragged(MouseEvent e){}
}
//Clase que responde a los eventos del checkbox, sobre el relleno de la figura
private class EventosCheckBox implements ItemListener{
    @Override
    public void itemStateChanged(ItemEvent e){
        if(figurasCreadas.getSelectedIndex()>=0){
        if(relleno.isSelected() && misFigurasD[figurasCreadas.getSelectedIndex()]!=null){
            misFigurasD[figurasCreadas.getSelectedIndex()].setRelleno(true);
        }else if(!relleno.isSelected()&& misFigurasD[figurasCreadas.getSelectedIndex()]!=null){
            misFigurasD[figurasCreadas.getSelectedIndex()].setRelleno(false);
        }
        repaint();
    }
    }
}
//clase que responde a los eventos de los ComboBox, sobre las propiedades de la figura
private class EventosComboBox implements ItemListener{
@Override
public void itemStateChanged(ItemEvent e){
         if(e.getSource()==figurasCreadas && figurasCreadas.getSelectedIndex()>=0){
            if(misFigurasD[figurasCreadas.getSelectedIndex()]!=null){
            for(int i=0;i<colorActual.length;i++){
              if(misFigurasD[figurasCreadas.getSelectedIndex()].getColor()==colorActual[i]){
                colorC.setSelectedIndex(i);
                relleno.setEnabled(true);
                relleno.setSelected(misFigurasD[figurasCreadas.getSelectedIndex()].getRelleno());
                break;
              }
            }
            }else if(misfiguras[figurasCreadas.getSelectedIndex()]!=null){
              for(int i=0;i<colorActual.length;i++){
              if(misfiguras[figurasCreadas.getSelectedIndex()].getColor()==colorActual[i]){
                colorC.setSelectedIndex(i);
                relleno.setEnabled(false);
                relleno.setSelected(false);
                break;
              }
            }
            } 
        }else if(e.getSource()==colorC && figurasCreadas.getSelectedIndex()>=0){
             if(misfiguras[figurasCreadas.getSelectedIndex()]!=null){
             misfiguras[figurasCreadas.getSelectedIndex()].setColor(colorActual[colorC.getSelectedIndex()]);
        }else{
             misFigurasD[figurasCreadas.getSelectedIndex()].setColor(colorActual[colorC.getSelectedIndex()]);
        }
       }
       repaint();
    }
}
@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    int i=0;
    //Dibuja
    while(misfiguras[i]!=null || misFigurasD[i]!=null){
        if( misfiguras[i]!=null){
            misfiguras[i].dibujar(g);
               i=i+1;
        }else if( misFigurasD[i]!=null){
            misFigurasD[i].dibujar(g);
               i=i+1;
        }
    }
}
        public void setCuentaFigura(int cuentaFigura) {
            this.cuentaFigura = cuentaFigura;
        }
}
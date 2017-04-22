package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Marco extends JFrame implements ActionListener{
    private final JDesktopPane deskPane;
    private  PanelDibujo dibujo;
    public Marco(){
       deskPane=new JDesktopPane();
       add(deskPane);
       
       JMenuBar menuBar=new JMenuBar();
       JMenu menu=new JMenu("Añadir");
       JMenuItem newFrame = new JMenuItem("Nuevo");
       menu.add(newFrame);
       newFrame.addActionListener(this);
       
       menuBar.add(menu);
       setJMenuBar(menuBar);

    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        dibujo=new PanelDibujo();
        JInternalFrame frameInterno = new JInternalFrame("Nueva hoja",true,true,true,true);
        frameInterno.add(dibujo);
        frameInterno.setVisible(true);
        frameInterno.setSize(765,370);
        deskPane.add(frameInterno);
    }
}

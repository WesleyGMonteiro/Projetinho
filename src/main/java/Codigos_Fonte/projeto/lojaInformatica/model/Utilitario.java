/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Codigos_Fonte.projeto.lojaInformatica.model;

import com.toedter.calendar.JDayChooser;
import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.xml.crypto.Data;

/**
 *
 * @author wesleygomesmonteiro
 */
public class Utilitario {
    
    public void limpaTela(JPanel container){
        Component components[] = container.getComponents();
        for(Component component : components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
            if(component instanceof JDayChooser){
                ((JDayChooser)component).setCalendar(null);
            }
            if(component instanceof JComboBox){
                ((JComboBox)component).setSelectedItem(null);
            }
        }
    }
}

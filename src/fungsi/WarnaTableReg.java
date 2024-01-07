/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fungsi;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Owner
 */
public class WarnaTableReg extends DefaultTableCellRenderer {
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        Object statusmjkntbl = table.getValueAt(row,24);
        Object statusbooking = table.getValueAt(row,25);
        Object bridgingsep = table.getValueAt(row,26);
        String statusmjkn = (statusmjkntbl==null)?"":statusmjkntbl.toString();
        String statussipentol = (statusbooking==null)?"":statusbooking.toString();
        String statussep = (bridgingsep==null)?"":bridgingsep.toString();
        
        if (row % 2 == 1){
            component.setBackground(new Color(217, 248, 196));
            if(isSelected){
                component.setForeground(Color.RED);
            }else{
                component.setForeground(new Color(50,50,50));
            }
        }else{
            component.setBackground(new Color(255,255,255));
            if(isSelected){
                component.setForeground(Color.RED);
            }else{
                component.setForeground(new Color(50,50,50));
            }
        }        
           
        if(statussipentol.equals("Terdaftar")){
            component.setBackground(new Color(180,118,184));
            if(isSelected){
                component.setForeground(Color.YELLOW);
            }else{
                component.setForeground(new Color(255,255,255));
            }
        }
        
        if(statussep.isBlank()){
          if (row % 2 == 1){
            component.setBackground(new Color(217, 248, 196));
            if(isSelected){
                component.setForeground(Color.RED);
            }else{
                component.setForeground(new Color(50,50,50));
            }
            }else{
            component.setBackground(new Color(255,255,255));
            if(isSelected){
                component.setForeground(Color.RED);
            }else{
                component.setForeground(new Color(50,50,50));
            }
        }
        }else{
            component.setBackground(new Color(48,116,57));
            if(isSelected){
                component.setForeground(Color.yellow);
            }else{
                component.setForeground(new Color(255,255,255));
            }
        }
        
        if(statusmjkn.equals("Checkin")){
            component.setBackground(new Color(180,118,184));
            if(isSelected){
                component.setForeground(Color.YELLOW);
            }else{
                component.setForeground(new Color(255,255,255));
            }
        }
        
        return component;
    }

}

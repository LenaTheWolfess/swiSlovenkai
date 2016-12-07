/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.db.entity;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Slavomír
 */
public class DescriptedBankConditionCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object object, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = super.getListCellRendererComponent(list, object, index, isSelected, cellHasFocus); //To change body of generated methods, choose Tools | Templates.
        if (object instanceof DescriptedBankCondition) {
            DescriptedBankCondition ds = (DescriptedBankCondition) object;
            component.setBackground(Color.white);
            component.setForeground(Color.BLACK);

            boolean selected = ds.isSelected();

            if (selected) {
                component.setForeground(new Color(200, 255, 200));
            }

        }
        return component;
    }

}

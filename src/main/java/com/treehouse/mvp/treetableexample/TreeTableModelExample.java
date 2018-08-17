/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.jdesktop.swingx.treetable.AbstractTreeTableModel;

/**
 *
 * @author hanus
 */
public class TreeTableModelExample extends AbstractTreeTableModel {

    private final static String[] COLUMN_NAMES = {"Jméno", "Cena"};
    
    private final Collection<Item> items;
    
    public TreeTableModelExample(Item root, Collection<Item> listItems) {
        super(root);
        this.items = listItems;
        
    }
    
    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Object getValueAt(Object o, int column) {
        Item item = (Item) o;
        switch (column) {
            case 0:
                return item.getJmeno();
            case 1:
                return item.getCena();
            default:
                return "";
        }
    }

    @Override
    public Object getChild(Object parent, int index) {
        return ((Item) parent).getChildren().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        return ((Item) parent).getChildren().size();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

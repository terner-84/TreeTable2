/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample.tree;

import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

/**
 *
 * @author hanus
 */
public class ItemTreeListener implements TreeSelectionListener {

    private JTree itemTree;
    private String itemName;
    
    public ItemTreeListener(JTree itemTree) {
        this.itemTree = itemTree;
    }
    
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        Object o = itemTree.getLastSelectedPathComponent();
        itemName = o.toString();
    }
    
    
}

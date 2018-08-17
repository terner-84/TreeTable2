/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample.tree;

import com.treehouse.mvp.treetableexample.Item;
import com.treehouse.mvp.treetableexample.ItemComparator;
import java.util.Comparator;
import java.util.List;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author hanus
 */
public class ItemTree {
    
    private final List<Item> items;
    private final Item rootItem;
    private final JTree treeItem;
    
    public ItemTree(Item rootItem, List<Item> items) {
        this.items = items;
        ItemComparator ic = new ItemComparator();
        items.sort(ic);
        this.rootItem = rootItem;
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(rootItem.getJmeno());
        createNodes(root);
        treeItem = new JTree(root);
        treeItem.setRowHeight(30);
        
        treeItem.setRootVisible(false);
        
    }
    
    public JTree getTreeItem() {
        return treeItem;
    }
    
    public static void setExpanded(JTree strom) {
        for (int i = 0; i < strom.getRowCount(); i++) {
            strom.expandRow(i);
        }
    }
    
        
    private void createNodes(DefaultMutableTreeNode root) {
        DefaultMutableTreeNode itemParent = null;
        DefaultMutableTreeNode itemChild = null;

        for (Item parent : items) {
            itemParent = new DefaultMutableTreeNode(parent.getJmeno());
            root.add(itemParent);
            if (parent.getChildren().size() > 0) {
                for (Item child : parent.getChildren()) {
                    itemChild = new DefaultMutableTreeNode(child.getJmeno());
                    itemParent.add(itemChild);
                    
                }
            }
        }
        
    }
}

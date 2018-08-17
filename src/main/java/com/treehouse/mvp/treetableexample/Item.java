/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanus
 */
public class Item {
    private String jmeno;
    private double cena;
    private List<Item> children = new ArrayList<>();
    private Item parent; 

    public Item(String jmeno, double cena) {
        this.jmeno = jmeno;
        this.cena = cena;
        
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public List<Item> getChildren() {
        return children;
    }

    public void setChildren(List<Item> children) {
        this.children = children;
    }
    
    public void addChild(Item item) {
        children.add(item);
    }

    public Item getParent() {
        return parent;
    }

    public void setParent(Item parent) {
        this.parent = parent;
    }
    
    
    
}

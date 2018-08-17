/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 *
 * @author hanus
 */
public class ItemsGenerator {
    private Random rnd;
    private int numberOfItems;
    private String separator;
    private int parentUid;
    private List<Item> children = new ArrayList<>();
    private List<Item> listOfItems;
    
    public ItemsGenerator(int numberOfItems, String separator) {
        rnd = new Random();
        this.numberOfItems = numberOfItems;
        this.separator = separator;
    }
    
    private Item getItem() {
        Item item = new Item(genJmeno(), genCena());
        if (genParentUid() > 0) {
            for (int i = 0; i < genChildrenCount(); i++) {
                Item child = new Item(genJmeno(), genCena());
                child.setParent(item);
                item.addChild(child);
            }
            
        }
        return item;
    }
    
    private int genParentUid() {
        return rnd.nextInt(5);
    }
    
    private int genChildrenCount() {
        return rnd.nextInt(5) + 1;
    }
    
    public List<Item> getListOfItems() {
        listOfItems = new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            listOfItems.add(getItem());
        }
        
        return listOfItems;
    }
    
    public Item getRoot() {
        Item root = new Item("root", 0);
        root.setChildren(listOfItems);
        return root;
    }
    
    private String genJmeno() {
        char znak;
        StringBuilder sb = new StringBuilder();
        znak = (char) (rnd.nextInt(26) + 65);
        sb.append(znak);
        sb.append(String.format("%s%02d", separator, rnd.nextInt(500)));
        return sb.toString();
    }
    
    private double genCena() {
        return rnd.nextDouble();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.treehouse.mvp.treetableexample;

import java.util.Comparator;

/**
 *
 * @author hanus
 */
public class ItemComparator implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getJmeno().compareTo(o2.getJmeno());
    }
    
}

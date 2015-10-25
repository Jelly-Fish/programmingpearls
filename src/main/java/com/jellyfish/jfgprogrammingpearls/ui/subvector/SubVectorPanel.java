/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jellyfish.jfgprogrammingpearls.ui.subvector;

import com.jellyfish.jfgprogrammingpearls.utils.ArrayUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;

/**
 *
 * @author thw
 */
public class SubVectorPanel extends javax.swing.JPanel {

    private final int w;
    private final int h;
    private final int[] v;
    private final int[] subv;
    
    /**
     * Ratio of this panel's height / ArrayUtils.MAX_RAND_VALUE used for
     * generating randon negative and positive inegers.
     */
    private final double r;
    
    /**
     * Value used for drawing the graph and incrementing x position by wI's value.
     */
    private static final int W_INCREMENT_VALUE = 10;
    
    /**
     * The graphical representation of vector's entries, for drawing.
     */
    private final int[] graph;
    
    /**
     * @param v
     * @param subv 
     */
    public SubVectorPanel(final int[] v, final int[] subv) {
        super();
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.w = v.length * SubVectorPanel.W_INCREMENT_VALUE;
        this.h = (int) screenSize.getHeight();
        this.setSize(this.w, this.h);
        this.setMaximumSize(new Dimension(this.w, this.h));
        this.setMinimumSize(new Dimension(this.w, this.h));
        this.setPreferredSize(new Dimension(this.w, this.h));
        this.r = screenSize.getHeight() / -ArrayUtils.MAX_RAND_VALUE_DOUBLE;
        this.v = v;
        this.subv = subv;
        this.setBackground(Color.BLACK);
        this.graph = initGraph();
    }
    
    @Override
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        int pW = 0;
        for (int i = 0; i < graph.length - 1; i++) {
            g.drawLine(pW, graph[i], pW + SubVectorPanel.W_INCREMENT_VALUE, graph[i + 1]);
            pW += SubVectorPanel.W_INCREMENT_VALUE;
        }
    }

    /**
     * Prepare vector for drawing it's graph.
     * @return 
     */
    private int[] initGraph() {
        
        final int[] g = new int[v.length];
        int y = 0;
        for (int i = 0; i < v.length - 1; i++) {
            y = (int) (r * v[i]);
            y = y < 0 ? y * -1 : y;
            g[i] = y;
        }
        
        return g;
    }
    
}

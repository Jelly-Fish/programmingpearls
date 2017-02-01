package fr.com.jfish.jfgprogrammingpearls.ui.subvector;

import fr.com.jfish.jfgprogrammingpearls.utils.ArrayUtils;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import javax.swing.BorderFactory;

/**
 *
 * @author thw
 */
public class SubVectorPanel extends javax.swing.JPanel {

    /**
     * This width.
     */
    private final int w;
    
    /**
     * This height.
     */
    private final int h;
    
    /**
     * Main vector.
     */
    private final int[] v;
    
    /**
     * The main vector's max sum sub vector.
     */
    private final int[] subv;
    
    /**
     * The sub vector's end index in main vector.
     */
    private final int subVectorEndIndex;
    
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
     * The graphical representation of sub vector's entries, for drawing.
     */
    private final int[] subGraph;
    
    /**
     * @param v
     * @param subv 
     * @param subVectorEndIndex 
     */
    public SubVectorPanel(final int[] v, final int[] subv, final int subVectorEndIndex) {
        super();
        final Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.w = (v.length * SubVectorPanel.W_INCREMENT_VALUE) + (SubVectorPanel.W_INCREMENT_VALUE * 2);
        this.h = (int) screenSize.getHeight();
        this.r = (screenSize.getHeight() / -ArrayUtils.MAX_RAND_VALUE_DOUBLE);
        this.v = v;
        this.subv = subv;
        this.subVectorEndIndex = subVectorEndIndex;
        this.graph = initGraph(this.v);
        this.subGraph = initGraph(this.subv);
        initComponents();
    }
    
    @Override
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);
        // Draw center horizontal line.
        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0, h / 2, w, h / 2);
        g.setColor(Color.DARK_GRAY);
        int pW = SubVectorPanel.W_INCREMENT_VALUE;
        // Draw main vector.
        for (int i = 0; i < graph.length - 1; i++) {
            g.drawLine(pW, graph[i], pW + SubVectorPanel.W_INCREMENT_VALUE, graph[i + 1]);
            pW += SubVectorPanel.W_INCREMENT_VALUE;
        }
        // Draw sub vector.
        g.setColor(Color.CYAN);
        pW = (subVectorEndIndex * SubVectorPanel.W_INCREMENT_VALUE) + SubVectorPanel.W_INCREMENT_VALUE;
        for (int i = subGraph.length - 1; i > 1; i--) {
            g.drawLine(pW, subGraph[i], pW - SubVectorPanel.W_INCREMENT_VALUE, subGraph[i - 1]);
            pW -= SubVectorPanel.W_INCREMENT_VALUE;
        }
    }

    /**
     * Prepare vector for drawing it's graph.
     * @return all integer entries of the vector redefined as graphical y positions
     * depending on the panel's (this) height that is used to define a ratio 
     * between lowest possible value in the vector and panel max height.
     * @see ArrayUtils
     */
    private int[] initGraph(final int[] vector) {
        
        final int[] g = new int[vector.length];
        int y = 0;
        for (int i = 0; i < vector.length; i++) {
            y = (int) (r * vector[i]);
            y = y < 0 ? y * -1 : y;
            g[i] = y;
        }
        
        return g;
    }
    
    private void initComponents() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setSize(this.w, this.h);
        this.setMaximumSize(new Dimension(this.w, this.h));
        this.setMinimumSize(new Dimension(this.w, this.h));
        this.setPreferredSize(new Dimension(this.w, this.h));
        this.setDoubleBuffered(true);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        this.setBackground(new Color(250, 250, 250));
    }
    
}

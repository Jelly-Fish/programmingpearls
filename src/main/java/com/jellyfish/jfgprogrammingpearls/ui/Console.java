package com.jellyfish.jfgprogrammingpearls.ui;

import com.jellyfish.jfgprogrammingpearls.ui.subvector.VectorGraphDialog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javafx.scene.input.KeyCode;
import javax.swing.text.BadLocationException;

/**
 *
 * @author thw
 */
public class Console extends javax.swing.JFrame implements Writable {
    
    /**
     * Creates new form Console
     */
    public Console() {
        
        initComponents();

        Image icon = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB_PRE);
        this.setIconImage(icon);
        this.setLocationRelativeTo(null);
        this.textArea.append(
                "Programming Pearls project 0.0.1:" +
                "\nImplement Jon Bentley's programming pearls in java" + 
                "\nand having fun twitching and timing the algoritmhs." +
                "\nhttps://github.com/Jelly-Fish/programmingpearls" +
                "\nDisplays below, that will refer to Bentley's Book.\n\n"
        );
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        containerPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        graphicsMenu = new javax.swing.JMenu();
        subVectorGraphMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Programming Pearls");

        scrollPane.setBorder(null);

        textArea.setEditable(false);
        textArea.setBackground(new java.awt.Color(51, 51, 51));
        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Consolas", 0, 20)); // NOI18N
        textArea.setForeground(new java.awt.Color(218, 240, 228));
        textArea.setRows(5);
        textArea.setBorder(null);
        textArea.setCaretColor(new java.awt.Color(255, 255, 255));
        textArea.setDoubleBuffered(true);
        textArea.setMargin(new java.awt.Insets(4, 4, 4, 4));
        textArea.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        textArea.setSelectionColor(new java.awt.Color(204, 204, 204));
        textArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textAreaKeyReleased(evt);
            }
        });
        scrollPane.setViewportView(textArea);

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        fileMenu.setText("File");
        jMenuBar1.add(fileMenu);

        graphicsMenu.setText("Graphics");

        subVectorGraphMenuItem.setText("Generate max sub vector graph");
        subVectorGraphMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subVectorGraphMenuItemActionPerformed(evt);
            }
        });
        graphicsMenu.add(subVectorGraphMenuItem);

        jMenuBar1.add(graphicsMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAreaKeyReleased
        
        if (evt.getKeyCode() == KeyCode.ENTER.ordinal()) { // == 10 for ENTER
            try {
                int offset = this.textArea.getLineOfOffset(this.textArea.getCaretPosition());
                int start = this.textArea.getLineStartOffset(offset);
                final String input = this.textArea.getText(start, 
                        (this.textArea.getLineEndOffset(offset) - start));                
            } catch (BadLocationException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_textAreaKeyReleased

    private void subVectorGraphMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subVectorGraphMenuItemActionPerformed
        new VectorGraphDialog(this, this);
    }//GEN-LAST:event_subVectorGraphMenuItemActionPerformed

    @Override
    public void print(final String e) {
        this.textArea.append(e);
    }
    
    @Override
    public void println(final String l) {
        this.textArea.append(l + '\n');
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel containerPanel;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu graphicsMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JMenuItem subVectorGraphMenuItem;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables

}

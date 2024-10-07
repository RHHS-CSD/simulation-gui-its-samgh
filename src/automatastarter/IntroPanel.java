/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import utils.CardSwitcher;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author michael.roy-diclemen
 */
public class IntroPanel extends javax.swing.JPanel {
    public static final String CARD_NAME = "intro";
    CardSwitcher switcher = null;
    
    //This is the parent panel
    Timer animTimer;
    // Keep track of the current rotation angle
    private double angle = 0; 
    //used for extraction of image from the jlabel
    private Image image;
    
    /**
     * Creates new form IntroPanel
     */
    public IntroPanel(CardSwitcher p) {
        initComponents();
        switcher = p;
        
        // extract the image from jLabel1 and hide the label
        image = ((ImageIcon) jLabel1.getIcon()).getImage();
        // hiding the Jlabel since it is painted twice
        jLabel1.setVisible(false);
        // create and start a Timer for animation
        animTimer = new Timer(20, new AnimTimerTick());
        animTimer.start();
    }
    
    public void paintComponent(Graphics g) {
        // ensuring the background and other components are painted correctly
        super.paintComponent(g); 

        // create a Java2D version of g.
        Graphics2D g2d = (Graphics2D) g.create();
        
        // cordinates of the image
        int x = jLabel1.getX();
        int y = jLabel1.getY();
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        // get the coordinates of the center of the label
        int cx = x + imageWidth / 2;
        int cy = y + imageHeight / 2;

        // apply rotation around the center of the image
        g2d.rotate(Math.toRadians(angle), cx, cy);

        // draw the image of Brian
        g2d.drawImage(image, x, y, this);
        // dispose of the Graphics2D object when done
        g2d.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GameButton = new javax.swing.JButton();
        infoButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        exitButton = new javax.swing.JButton();

        GameButton.setText("Brain's Brain");
        GameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GameButtonActionPerformed(evt);
            }
        });

        infoButton.setText("Info Panel");
        infoButton.setToolTipText("");
        infoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoButtonActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/automatastarter/Brian_Griffin.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Brian's Brain Simulation");

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(infoButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(GameButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(169, 169, 169)
                .addComponent(jLabel1)
                .addContainerGap(203, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(GameButton)
                        .addGap(18, 18, 18)
                        .addComponent(infoButton)
                        .addGap(34, 34, 34)
                        .addComponent(exitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel1)))
                .addContainerGap(147, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void GameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GameButtonActionPerformed
       // switch to game panel
        switcher.switchToCard(GamePanel.CARD_NAME);
    }//GEN-LAST:event_GameButtonActionPerformed

    private void infoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoButtonActionPerformed
        // switch to info panel
        switcher.switchToCard(InfoPanel.CARD_NAME);
    }//GEN-LAST:event_infoButtonActionPerformed

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // switch to end panel
        switcher.switchToCard(EndPanel.CARD_NAME);
    }//GEN-LAST:event_exitButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GameButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JButton infoButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
        private class AnimTimerTick implements ActionListener {
        //using timer
        public void actionPerformed(ActionEvent ae) {
            // update the angle for rotation
            angle += 1;
            if (angle >= 360) {
                // reset angle after a full rotation
                angle = 0;  
            }
            //force redraw
            repaint();
        }
    }
}

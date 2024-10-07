/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automatastarter;

import java.awt.Color;
import utils.CardSwitcher;
import utils.ImageUtil;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

/**
 *
 * @author michael.roy-diclemen
 */
public class GamePanel extends javax.swing.JPanel implements MouseListener {

    public static final String CARD_NAME = "game";

    CardSwitcher switcher; 
    //This is the parent panel
    Timer animTimer;
    //Constants for cell states
    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int DYING = 2;
    
    //Grid variables
    int[][] grid;
    int rows, columns;
    // Size of each cell in the grid
    private static int CELL_SIZE = 15; 
    //Remark: if the user resizes to a number that is not divisible by 600(the height of the panel) it will cause a gap
    
    /* old unused code
    // Image img1 = Toolkit.getDefaultToolkit().getImage("yourFile.jpg");
    BufferedImage img1;
    //variables to control your animation elements
    int x = 0;
    int y = 10;
    int xdir = 5;
    int lineX = 0;
    */
    /**
     * Creates new form GamePanel
     */
    public GamePanel(CardSwitcher p) {
        initComponents();
        //setting rows and columns
        this.rows = 40;
        this.columns = 40;

        //img1 = ImageUtil.loadAndResizeImage("yourFile.jpg", 300, 300);//, WIDTH, HEIGHT)//ImageIO.read(new File("yourFile.jpg"));

        this.setFocusable(true);

        // tell the program we want to listen to the mouse
        addMouseListener(this);
        //tells us the panel that controls this one
        switcher = p;
        //create and start a Timer for animation
        animTimer = new Timer(800, new AnimTimerTick());
        animTimer.start();
        
        //initializing the grid
        grid = SimulationEngine.initializeGrid(rows, columns);
        
        //setting the speed minimum(1) and maximum(20) for the slider
        speedSlider.setMinimum(20);
        speedSlider.setMaximum(1200);
        
        /* old code
        //set up the key bindings
        setupKeys();
        */

    }

    /*
    private void setupKeys() {
        //these lines map a physical key, to a name, and then a name to an 'action'.  You will change the key, name and action to suit your needs
        this.getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "leftKey");
        this.getActionMap().put("leftKey", new Move("LEFT"));

        this.getInputMap().put(KeyStroke.getKeyStroke("W"), "wKey");
        this.getActionMap().put("wKey", new Move("w"));

        this.getInputMap().put(KeyStroke.getKeyStroke("D"), "dKey");
        this.getActionMap().put("dKey", new Move("d"));

        this.getInputMap().put(KeyStroke.getKeyStroke("X"), "xKey");
        this.getActionMap().put("xKey", new Move("x"));
    }
    */

    public void paintComponent(Graphics g) {
        
            // Loop through the grid and draw each cell
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < columns; col++) {
                    int x = col * CELL_SIZE;
                    int y = row * CELL_SIZE;

                    // Set color based on cell state
                    switch (grid[row][col]) {
                        case ON:
                            g.setColor(Color.GREEN);
                            break;
                        case DYING:
                            g.setColor(Color.RED);
                            break;
                        case OFF:
                        default:
                            g.setColor(Color.WHITE);
                            break;
                    }

                    // Draw the cell as a filled rectangle
                    g.fillRect(x, y, CELL_SIZE, CELL_SIZE);

                    // Draw grid lines
                    g.setColor(Color.BLACK);
                    g.drawRect(x, y, CELL_SIZE, CELL_SIZE);
                }
            }
        /*
        super.paintComponent(g);
        if (img1 != null) {
            g.drawImage(img1, x, y, this);
        }
        g.drawLine(lineX, 0, 300, 300);
        */
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        NumberOfDeads = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        NumberOfDyings = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        NumberOfAlives = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        speedSlider = new javax.swing.JSlider();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jLabel4.setText("jLabel4");

        jLabel5.setText("jLabel5");

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jLabel1.setText("Number of Deads:");

        NumberOfDeads.setText("0");

        jLabel2.setText("Number of Dyings:");

        NumberOfDyings.setText("0");

        jLabel3.setText("Number of Alives:");

        NumberOfAlives.setText("0");

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        resetButton.setText("Reset");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Speed Delay");

        jLabel7.setText("Adding Common Patterns");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel8.setText("Add a Square in the Middle");

        jLabel9.setText("Add a Blinker");

        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setText("Add a Rhombus");

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Set New Side Length");

        jTextField1.setText("40");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(speedSlider, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(45, 45, 45))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(56, 56, 56))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addContainerGap()))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(NumberOfDyings))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(NumberOfAlives)
                                            .addComponent(NumberOfDeads))))
                                .addGap(17, 17, 17))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(59, 618, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pauseButton)
                            .addComponent(resetButton)
                            .addComponent(startButton))
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backButton))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(startButton)
                .addGap(18, 18, 18)
                .addComponent(pauseButton)
                .addGap(18, 18, 18)
                .addComponent(resetButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(NumberOfAlives))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NumberOfDyings))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(NumberOfDeads))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(speedSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(12, 12, 12)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(8, 8, 8)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backButton)
                .addContainerGap(11, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        //lineX = 0;
    }//GEN-LAST:event_formComponentShown

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        //unfreezing the timer
        animTimer.start();
    }//GEN-LAST:event_startButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        //unfreezing the timer
        animTimer.stop();
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        //reseting(making a blank grid)
        grid = new int[rows][columns];
    }//GEN-LAST:event_resetButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //adding a square starting at the middle e.g.(20,20) in a 40 by 40 grid
        //starting point is in the middle
        int startingPoint = (rows + 1)/2 - 1;
        for(int i = startingPoint; i <= (startingPoint + 1); i++){
            for(int j = startingPoint; j <= (startingPoint + 1); j++){
                grid[i][j] = ON;
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //adding a blinker at the middle x value - 1
        //starting point is in the middle
        int startingPoint = (rows + 1)/2 - 1;
        for(int i = startingPoint; i <= startingPoint + 2; i+=2){
            for(int j = startingPoint; j <= startingPoint + 2; j+=2){
                grid[i][j] = ON;
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //adding a rhombus at  the middle x - 1
        //starting point is in the middle
        int startingPoint = (rows + 1)/2 - 1;
        for(int i = startingPoint; i <= startingPoint + 1; i++){
            for(int j = startingPoint; j <= startingPoint + 2; j+=2){
                grid[i][j] = ON;
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //back to intro panel
        switcher.switchToCard(IntroPanel.CARD_NAME);
    }//GEN-LAST:event_backButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NumberOfAlives;
    private javax.swing.JLabel NumberOfDeads;
    private javax.swing.JLabel NumberOfDyings;
    private javax.swing.JButton backButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JSlider speedSlider;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    // Method to toggle the cell state between OFF and ON (you can modify to include DYING if needed)
    private void toggleCell(int row, int col) {
        //if dead, make it alive
        if (grid[row][col] == OFF) {
            grid[row][col] = ON;
        }
        //otherwise change its status to off
        else {
            grid[row][col] = OFF;
        }
    }
    
    //checcking if the string can be converted to integer, if it caceched an error it should return false
    private boolean isInteger( String input ) {
        // try to cast integer from string
        try {
        Integer.parseInt( input );
        return true;
    }
    //if it catched an error return false
    catch( Exception e ) {
        return false;
    }
}
    //updating grid
    private void update(){
        //checking if the string can be converted to intger, otherwise don't change the grid size
        if(isInteger(jTextField1.getText())){
            //if the user changed the size
            if(rows != Integer.parseInt(jTextField1.getText())){
                //checking grid size, by getting the value of text field
                grid = new int[Integer.parseInt(jTextField1.getText())][Integer.parseInt(jTextField1.getText())];
                //reseting rows and columns
                rows = Integer.parseInt(jTextField1.getText());
                columns = Integer.parseInt(jTextField1.getText());
                //updating the new cell size
                CELL_SIZE = getHeight() / rows;
            }
       }

       //applying rules
       grid = SimulationEngine.applyRules(rows,columns,grid);
       //getting the counts of On, Off or dying cells, the order: aliveCount, dyingCount, deadCount]
       int[] count = SimulationEngine.getCellCounts(grid);
       //setting them on screen
       NumberOfAlives.setText("" + count[0]);
       NumberOfDyings.setText("" + count[1]);
       NumberOfDeads.setText("" + count[2]);
       
       //updating the speed
        int newSpeed = speedSlider.getValue();
        animTimer.setDelay(newSpeed);
    }
    
    /**
     * This event captures a click which is defined as pressing and releasing in
     * the same area
     *
     * @param me
     */
    public void mouseClicked(MouseEvent me) {
          //getting the location with regards to the cell
        int x = me.getX() / CELL_SIZE;
        int y = me.getY() / CELL_SIZE;
        //if in the grid
        if (x >= 0 && x < columns && y >= 0 && y < rows) {
            toggleCell(y, x); // Toggle cell state
            repaint();  // Repaint the panel to reflect the change
       }
    }

    /**
     * When the mountain is pressed
     *
     * @param me
     */
    public void mousePressed(MouseEvent me) {
        System.out.println("Press: " + me.getX() + ":" + me.getY());
    }

    /**
     * When the mouse button is released
     *
     * @param me
     */
    public void mouseReleased(MouseEvent me) {
        System.out.println("Release: " + me.getX() + ":" + me.getY());
    }

    /**
     * When the mouse enters the area
     *
     * @param me
     */
    public void mouseEntered(MouseEvent me) {
        System.out.println("Enter: " + me.getX() + ":" + me.getY());
    }

    /**
     * When the mouse exits the panel
     *
     * @param me
     */
    public void mouseExited(MouseEvent me) {
        System.out.println("Exit: " + me.getX() + ":" + me.getY());
    }

    /**
     * Everything inside here happens when you click on a captured key.
     */
    /*
    private class Move extends AbstractAction {

        String key;

        public Move(String akey) {
            key = akey;
        }

        public void actionPerformed(ActionEvent ae) {
            // here you decide what you want to happen if a particular key is pressed
            System.out.println("llll" + key);
            switch(key){
                case "d": x+=2; break;
                case "x": animTimer.stop(); switcher.switchToCard(EndPanel.CARD_NAME); break;
            }
            if (key.equals("d")) {
                x = x + 2;
            }
            
        }

    }
    */

    /**
     * Everything inside this actionPerformed will happen every time the
     * animation timer clicks.
     */
    private class AnimTimerTick implements ActionListener {
        //using timer
        public void actionPerformed(ActionEvent ae) {
            //updating the grid
            update();
            //force redraw
            repaint();
        }
    }
}

import flanagan.io.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Gridder extends JFrame
                                        implements MouseListener, MouseMotionListener,
                                                            ActionListener {
     
    protected final int gridCount=100;  //how many squares wide our drawing area is
    protected int[][] grid = new int[gridCount][gridCount]; //create the matrix         
    private final int squareSize=5; //the size length of individual squares in pixels
    private final int gridSize=gridCount*squareSize;  //size of entire draw grid in pixels
    private final int offSet=50;  //how far from top/left edge do we draw the grid
    private int penColor = 1; //keeps track of current drawing color
    private Color[] colors; //our array of colors
    private Image ib;  //we do all drawing onto this image, it acts as an image buffer
    private Graphics ibg;  //will be set to our image buffer's graphic object
    private String filename;
    
    private Timer timmy;
    private boolean active=false;
    private int stepDelay = 500;
    private Color borderColor=new Color(20,20,20);
    
    
    //constructor for our GridderFrame
    public Gridder() {
        initComponents();
        addMouseListener(this);  //registers this frame to receive mouse clicks
        addMouseMotionListener(this); //register this frame to receive mouse motions
        setUpImageBuffer();
        takeCareOfResizing();
        setUpColors();
        clearGrid();
        draw();
    }

    
    //set our image (buffer) to a new image of the correct size
    public void setUpImageBuffer(){
        ib=this.createImage(gridSize+1,gridSize+1);
        ibg=ib.getGraphics();
    }

    
    //experimental code that redraws the grid after user resizes the window
    //works some of the time... still in progress
    public void takeCareOfResizing(){
         this.addComponentListener(new ComponentAdapter() {
           public void componentResized(ComponentEvent e) {
              draw(); 
           }  
           public void componentMoved(ComponentEvent e) {
              draw();
           }
         });
    }
    
    public void setUpColors(){
        colors=new Color[2];
        colors[0]=Color.darkGray;  colors[1]=Color.white; 
        
    }
    
    
    //fills the grid with 1's (represents white!)
    public void clearGrid(){
        for(int c=0; c<gridCount; c++)
            for(int r=0; r<gridCount; r++)
                grid[c][r]=0;

        draw();
    } 
    
     
    public void mousePressed(MouseEvent e) { }
    public void mouseReleased(MouseEvent e) { }
    public void mouseEntered(MouseEvent e) { }
    public void mouseExited(MouseEvent e) {  }
    
    
    //will use the mouse x and y coordinates and figure out which square in the
    //draw area was clicked and pass this information to the clickGrid method
    public void mouseClicked(MouseEvent e) { 
        int x = e.getX(); int y = e.getY(); 
        int row = (y-offSet)/squareSize;
        int col = (x-offSet)/squareSize;
        System.out.println("Click: " + col + ", " + row);
        //if inside our grid, call clickGrid passing it the col and row
        if ( (row>=0) && (row<gridCount) && (col>=0) && (col<gridCount) )
           clickGrid(col, row);
    }
  
    
    //will use the mouse x and y coordinates and figure out which square in the
    //draw area dragging is occurring and pass this information to the clickGrid method    
    public void mouseDragged(MouseEvent e) { 
      int x = e.getX(); int y = e.getY(); 
      int row = (y-offSet )/squareSize;
      int col = (x-offSet )/squareSize;
      System.out.println("Drag:  " + col + ", " + row);
      //if inside our grid, call dragGrid passint it the col and row
      if ( (row>=0) && (row<gridCount) && (col>=0) && (col<gridCount) )
         dragGrid(col, row);       
    }
    
    public void mouseMoved(MouseEvent e) { 
        //System.out.println("Moving at " + e.getX() + "," +  e.getY() );  
    }
    
    //set a square in the grid to the color value as long as the values are valid
    public void colorSquare(int col, int row, int colorValue){
        grid[col][row] = colorValue;
        draw();
    }
    
    
    //any mouse click is forwarded to this method with the col and row of the
    //square clicked provided as parameters.  Comes from public void mouseClicked.
    public void clickGrid( int col, int row ){
        colorSquare(col, row, penColor); 
    }
    
    
    //any mouse drag is forwarded to this method with the col and row of the
    //square dragged over provided as parameters.  Comes from public void mouseDragged.
    public void dragGrid( int col, int row) {
        colorSquare(col, row, penColor);   
    }
    
    
    //draws the image based on the values stored in the grid.
    //we will draw on the image buffer's graphics object and then when we are
    //all done we will copy the image buffer onto the Frame's graphic object.
    public void draw(){
        
        //clear the area, draw white background
        ibg.clearRect(0, 0, gridSize,gridSize);
        ibg.setColor(Color.white);
        ibg.fillRect(0, 0, gridSize, gridSize);
        
        //draws individual squares (pass this method the frames graphics object
        drawSquares(ibg);
        
        //draws a black border around edge of grid
        ibg.setColor(Color.black);
        ibg.drawRect(0,0,gridSize,gridSize);
        
        //all done drawing your stuff onto the image buffer?
        //get the frame's graphics object and draw our image buffer onto the frame
        Graphics g = this.getGraphics();
        g.drawImage(ib,offSet,offSet,this);
    }
    
    
    //draws the individual colored squares that make the grid using the values
    //stored in the grid matrix.
    public void drawSquares(Graphics g){
       //draw each square (remember that squareSize is size of each square...
       g.setColor(Color.black);
       for(int r=0; r<gridCount; r++){
           for(int c=0; c<gridCount; c++) {
               g.setColor(colors[ grid[c][r] ] );
               g.fillRect(c*squareSize, r*squareSize, squareSize, squareSize);      
               g.setColor(borderColor);
               g.drawRect(c*squareSize, r*squareSize, squareSize, squareSize);
           }
       }
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textInfo = new JTextField();
        jScrollPane1 = new JScrollPane();
        jPanel3 = new JPanel();
        buttonOpen = new JButton();
        buttonSave = new JButton();
        buttonRefresh = new JButton();
        buttonClear = new JButton();
        buttonBlack = new JButton();
        buttonWhite = new JButton();
        jButtonStep = new JButton();
        jButtonCopy = new JButton();
        jButtonPaste = new JButton();
        jButtonRun = new JButton();
        jSliderDelay = new JSlider();
        jPanel1 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton10 = new JButton();
        jButton11 = new JButton();
        jButton12 = new JButton();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 51));
        setMinimumSize(new java.awt.Dimension(950, 660));

        textInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textInfo.setText("give user info here...");

        buttonOpen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonOpen.setText("Open");
        buttonOpen.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonOpenActionPerformed(evt);
            }
        });

        buttonSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonSave.setText("Save");
        buttonSave.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        buttonRefresh.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonRefresh.setText("Refresh");
        buttonRefresh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonRefreshActionPerformed(evt);
            }
        });

        buttonClear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        buttonClear.setText("Clear");
        buttonClear.setPreferredSize(new java.awt.Dimension(100, 20));
        buttonClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonClearActionPerformed(evt);
            }
        });

        buttonBlack.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        buttonBlack.setText("BLACK");
        buttonBlack.setMaximumSize(new java.awt.Dimension(50, 30));
        buttonBlack.setMinimumSize(new java.awt.Dimension(75, 0));
        buttonBlack.setPreferredSize(new java.awt.Dimension(50, 20));
        buttonBlack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonBlackActionPerformed(evt);
            }
        });

        buttonWhite.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        buttonWhite.setText("WHITE");
        buttonWhite.setMaximumSize(new java.awt.Dimension(50, 30));
        buttonWhite.setMinimumSize(new java.awt.Dimension(75, 0));
        buttonWhite.setPreferredSize(new java.awt.Dimension(50, 20));
        buttonWhite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                buttonWhiteActionPerformed(evt);
            }
        });

        jButtonStep.setText("STEP");
        jButtonStep.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonStepActionPerformed(evt);
            }
        });

        jButtonCopy.setText("Copy");

        jButtonPaste.setText("Paste");

        jButtonRun.setText("Run");
        jButtonRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonRunActionPerformed(evt);
            }
        });

        jSliderDelay.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jSliderDelay.setMajorTickSpacing(500);
        jSliderDelay.setMaximum(2000);
        jSliderDelay.setMinorTickSpacing(500);
        jSliderDelay.setPaintLabels(true);
        jSliderDelay.setPaintTicks(true);
        jSliderDelay.setSnapToTicks(true);
        jSliderDelay.setValue(500);
        jSliderDelay.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSliderDelayStateChanged(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("jButton3");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("jButton4");
        jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("jButton5");
        jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("jButton6");
        jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jButton7.setText("jButton7");
        jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jButton8.setText("jButton8");
        jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("jButton9");
        jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("jButton10");
        jButton10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("jButton11");
        jButton11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("jButton12");
        jButton12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addComponent(jButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton10, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton10, jButton11, jButton12, jButton2, jButton3, jButton4, jButton5, jButton6, jButton7, jButton8, jButton9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton12)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel1.setText("set delay");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jSliderDelay, GroupLayout.PREFERRED_SIZE, 324, GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonRefresh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonBlack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonStep, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonWhite, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonCopy, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonPaste, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttonOpen, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonRun, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28)
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonBlack, buttonClear, buttonOpen, buttonRefresh, buttonSave, buttonWhite, jButtonCopy, jButtonPaste, jButtonRun, jButtonStep});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(buttonOpen, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSave, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(buttonClear, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCopy)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPaste)
                        .addGap(20, 20, 20)
                        .addComponent(buttonBlack, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonWhite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jButtonStep)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonRun)))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSliderDelay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(184, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {buttonBlack, buttonWhite});

        jPanel3Layout.linkSize(SwingConstants.VERTICAL, new java.awt.Component[] {buttonClear, buttonRefresh});

        jScrollPane1.setViewportView(jPanel3);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textInfo, GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 359, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 559, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textInfo, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
       
    //saves the current picture data in CS format
    private void buttonSaveActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
      //String curDir = System.getProperty("user.dir");
      //System.out.println("Your directory is " + curDir);
      FileChooser FC = new FileChooser();
      FC.selectFile();
      filename=FC.getDirPath() +"/"+ FC.getFileName();
      System.out.println("Filename: " + filename);
      FC.close();
      
      FileOutput FO = new FileOutput(filename,"w");
    
      for(int r=0; r<gridCount; r++) {
         for(int c=0; c<gridCount; c++) {
             int num = grid[c][r];
             if (num<10)
                 FO.print("0"+num);
             else
                 FO.print(num);
         }
         FO.println(""); //go to new line
      }
      FO.close();
        
    }//GEN-LAST:event_buttonSaveActionPerformed

    //opens a CS format file and loads the image data into the grid
    private void buttonOpenActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonOpenActionPerformed
      FileChooser FC = new FileChooser();
      FC.selectFile();
      filename=FC.getDirPath() +"/"+ FC.getFileName();
      System.out.println(filename);
      FC.close();
      
      FileInput FI = new FileInput(filename);
      int num=FI.numberOfLines();
      if (num!=gridCount){
          System.out.println("Not enough lines in file!");
          return;
      }
      
      //read each row.  go through row two characters at a time and convert to number
      for(int r=0; r<gridCount; r++) {
          String line = FI.readLine();                         //read the next line
          for(int c=0; c<gridCount; c++){                 //or (int c=0; c<gridCount*2; c=c+2)
              String temp=line.substring(c*2, c*2+2);   //0,2,4,6,8,...
              int value=Integer.parseInt(temp);           //convert to int
              grid[c][r]=value;                                  //put in grid
          }
      }
      FI.close();
      
      //lets see what you just read!
      draw();
      
    }//GEN-LAST:event_buttonOpenActionPerformed

    //redraws the canvas when the picture disappears
    private void buttonRefreshActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonRefreshActionPerformed
        draw();
    }//GEN-LAST:event_buttonRefreshActionPerformed

    private void buttonClearActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonClearActionPerformed
        clearGrid();
    }//GEN-LAST:event_buttonClearActionPerformed


    private void buttonBlackActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonBlackActionPerformed
        penColor=0;
    }//GEN-LAST:event_buttonBlackActionPerformed

    private void buttonWhiteActionPerformed(ActionEvent evt) {//GEN-FIRST:event_buttonWhiteActionPerformed
        penColor=1;
    }//GEN-LAST:event_buttonWhiteActionPerformed

    public boolean isAlive(int c, int r) {
        //if cell is in grid and alive, return true
        //outside grid or not alive, return false
        return(true);
    }
    
    private void jButtonStepActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonStepActionPerformed
        step();
    }//GEN-LAST:event_jButtonStepActionPerformed

    public int countNeighbors(int c, int r){
       return(0);
    }
    
    public void step() {
        //empty now
        //sample code, take this out!   randomly pick a spot to turn white
        int col = (int)(Math.random()*gridCount);
        int row = (int)(Math.random()*gridCount);
        grid[col][row] = 1;
        
        
        //leave this in here or you won't see anything happen!
        draw();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //this event is called by the timer...
        //System.out.println("Calling Step...");
        //System.out.println(e.getSource());
        step();
    }
    
    private void jButtonRunActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButtonRunActionPerformed
        //create timer if it doesn't exist.  If it does exist, turn it on!
        System.out.println("Run/Pause Button Pressed");
        if (active==false) {
            if (timmy==null) {
              timmy=new Timer(stepDelay,this);
              timmy.setInitialDelay(100); 
              timmy.setDelay(stepDelay);
            }
            
            timmy.start();
            active=true;
            jButtonRun.setText("Pause...");
        }
        else { //turn timer off
            active=false;
            timmy.stop();
            jButtonRun.setText("Run...");
        }
    }//GEN-LAST:event_jButtonRunActionPerformed

    private void jSliderDelayStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSliderDelayStateChanged
        // TODO add your handling code here:
        stepDelay=jSliderDelay.getValue();
        if (stepDelay==0) {
            stepDelay=1;
        }
        if (timmy!=null)
            timmy.setDelay(stepDelay);
    }//GEN-LAST:event_jSliderDelayStateChanged

    private void jButton1ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("1");
        for (int i = 0; i < 100; i++) {
            int col = (int)(Math.random()*gridCount);
            int row = (int)(Math.random()*gridCount);
            grid[col][row] = 1;
        }
        draw();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void jButton2ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.out.println("2");
        int col = (int)(Math.random()*gridCount);
        for (int i = 0; i < gridCount; i++) {
            grid[col][i] = 1;
        }
        draw();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.out.println("3");
        for (int i = 0; i < gridCount; i++) {
            for (int j = 0; j < gridCount; j++) {
                if (j < gridCount / 2) {
                    grid[i][j] = 1;
                } else {
                    grid[i][j] = 0;
                }
            }
        }
        draw();
    }//GEN-LAST:event_jButton1ActionPerformed



    private void jButton4ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("4");
        int count = 0;
        for (int i = 0; i < gridCount; i++) {
            for (int j = 0; j < gridCount; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        textInfo.setText( Integer.toString(count));
        draw();
    }//GEN-LAST:event_jButton11ActionPerformed
    private void jButton5ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("5");
        clearGrid();
        for (int i = 0; i < gridCount; i++) {
            grid[i][gridCount-1-i] = 1;
            grid[i][i] = 1;
        }
        draw();
    }//GEN-LAST:event_jButton11ActionPerformed
    private void jButton6ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("6");

        // reverse the color
        for (int i = 0; i < gridCount; i++) {
            for (int j = 0; j < gridCount; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = 1;
                }
            }
        }
        draw();


    }//GEN-LAST:event_jButton11ActionPerformed
    private void jButton7ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("7");
        // adding whites to the border
        int[][] temp = new int[gridCount][gridCount];

        // copy original grid;
        for (int row = 0; row < gridCount; row++) {
            for (int col = 0; col < gridCount; col++) {
                temp[col][row] = grid[col][row];
            }
        }

        for (int row=1; row<gridCount-1; row++)
            for (int col=1; col<gridCount-1; col++) {
                if (grid[col][row-1]==1)  //check above
                    temp[col][row]= 1;
                if (grid[col][row+1]==1)  //check below
                    temp[col][row] = 1;
                if (grid[col-1][row]==1 ) //check to the left
                    temp[col][row]=1;
                if (grid[col+1][row]==1) //check to the right
                    temp[col][row]=1;
            }

        for (int row=0; row< gridCount; row++) {
            for (int col = 0; col < gridCount; col++){
                grid[col][row] = temp[col][row];
            }
        }
        draw();
    }//GEN-LAST:event_jButton11ActionPerformed
    private void jButton8ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("8");

        draw();
    }//GEN-LAST:event_jButton11ActionPerformed
    private void jButton9ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("9");

        draw();
    }//GEN-LAST:event_jButton11ActionPerformed


    private void jButton10ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        System.out.println("10");
        draw();
    }//GEN-LAST:event_jButton10ActionPerformed
    private void jButton11ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        System.out.println("11");

        draw();
    }//GEN-LAST:event_jButton11ActionPerformed
    private void jButton12ActionPerformed(ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        System.out.println("12");
    }//GEN-LAST:event_jButton12ActionPerformed





    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gridder().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton buttonBlack;
    private JButton buttonClear;
    private JButton buttonOpen;
    private JButton buttonRefresh;
    private JButton buttonSave;
    private JButton buttonWhite;
    private JButton jButton1;
    private JButton jButton10;
    private JButton jButton11;
    private JButton jButton12;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButtonCopy;
    private JButton jButtonPaste;
    private JButton jButtonRun;
    private JButton jButtonStep;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JSlider jSliderDelay;
    private JTextField textInfo;
    // End of variables declaration//GEN-END:variables

} //end of class
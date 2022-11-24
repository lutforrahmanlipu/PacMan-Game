//lutfor rahman lipu 
//id 0344420

import com.sun.prism.paint.Color;
import javax.swing.*;          
import java.awt.event.*;
import java.io.File;
import javax.sound.sampled.*;
public class PacMinah extends JFrame implements ActionListener {

   private final int SWIDTH = 900;
   private final int SHEIGHT = 700;
   private JButton btnStart, btnExit;
   private JButton btnLeft, btnRight, btnUp, btnDown;
   private GamePanel1 gameP = new GamePanel1();

   public PacMinah() {
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setTitle("Pac Minah v1.0");
      setSize(SWIDTH, SHEIGHT);
      setLayout(null);
   }

   public void init() {
      gameP.setBounds(25, 25, 600, 630);
      add(gameP);
      // button left 
      btnLeft = new JButton("LEFT");
      btnLeft.setBounds(650, 400, 100, 25);
       
      btnLeft.addActionListener(this);
      add(btnLeft);
     // button right
      btnRight = new JButton("RIGHT");
      btnRight.setBounds(750, 400, 100, 25);
      btnRight.addActionListener(this);
      add(btnRight);
     // button up
      btnUp = new JButton("UP");
      btnUp.setBounds(700, 375, 100, 25);
      btnUp.addActionListener(this);
      add(btnUp);
      //button down
      btnDown = new JButton("DOWN");
      btnDown.setBounds(700, 425, 100, 25);
      btnDown.addActionListener(this);
      add(btnDown);
     // button start
      btnStart = new JButton("START");
      btnStart.setBounds(650, 500, 100, 25);
      btnStart.addActionListener(this);
      add(btnStart);
      //button exit
      btnExit = new JButton("EXIT");
      btnExit.setBounds(650, 625, 100, 25);
      btnExit.addActionListener(this);
      add(btnExit);
      setVisible(true);   
      
      File soundFile =  new File("src/lipu.wav").getAbsoluteFile();
      try {
         AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
         Clip myClip = AudioSystem.getClip();
         myClip.open(ais);
         myClip.start();
      }
      catch(Exception e) {
         System.out.println(e);
      }
   }
   
// button action
   public void actionPerformed(ActionEvent e) {
      if (e.getSource() == btnExit) {
         System.exit(0);
      } 
      else if (e.getSource() == btnStart) {
         gameP.startTimer();
      }     
      else if (e.getSource() == btnLeft) {
         gameP.moveLeft();
      } 
      else if (e.getSource() == btnUp) {
         gameP.moveUp();
      } 
      else if (e.getSource() == btnRight) {
         gameP.moveRight();
      } 
      else if (e.getSource() == btnDown) {
         gameP.moveDown();
      }
   }
              //main
   public static void main(String args[]) {
      PacMinah pm = new PacMinah();
      pm.init();
   }
}
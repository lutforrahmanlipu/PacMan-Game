import java.awt.*;    //litfor rahman lipu
                          //0344420
import java.awt.event.*;
import javax.swing.*;

public class GamePanel1 extends JPanel implements ActionListener, KeyListener {

    private Timer aTimer;
    private int gameStatus = 0;
    private Lipu lipuu;
   
    private Monster mons, mons1, mons2, mons3;

    private int score = 0;

    public GamePanel1() {
        aTimer = new Timer(60, this);
        reset();
        addKeyListener(this);
    }

    public void reset() {
        lipuu = new Lipu(200, 300, 5);
        mons = new Monster(200, 100, 5);
        mons1 = new Monster(200, 100, 5);
        mons2 = new Monster(200, 100, 5);
        
        mons3 = new Monster(200, 100, 5);

        score = 0;
    }
    
    public int getGameStatus(){
        return gameStatus;
    }
    
    public void setGameStatus(int status){
        gameStatus = status;
    }
    
    public void startTimer() {
        if (gameStatus == 0) {
            aTimer.start();
            gameStatus = 1;
        }
    }

    public void paint(Graphics g) {

        if (gameStatus == 1) {
            score++;
            if (lipuu.collideBorder()) {
                gameStatus = 2;
            }
            if (lipuu.collideWithMonster(mons))
                gameStatus = 2;
            if (lipuu.collideWithMonster(mons1))
                gameStatus = 2;
            if (lipuu.collideWithMonster(mons2))
                gameStatus = 2;
            if (lipuu.collideWithMonster(mons3))
                gameStatus = 2;

                
            if (gameStatus != 2) {
                mons.hunting(lipuu);
                mons1.hunting(lipuu);
                mons2.hunting(lipuu);
                mons3.hunting(lipuu);
                lipuu.updatePosition();
                mons.updatePosition();
                mons.handleBorderCollision();
                mons1.updatePosition();
                mons1.handleBorderCollision();
                mons2.updatePosition();
                mons2.handleBorderCollision();
                mons3.updatePosition();
                mons3.handleBorderCollision();         
            }
        }
        g.setColor(Color.white);
        g.fillRect(0, 0, 600, 600);
        g.setColor(Color.black);
        g.fillRect(0, 600, 600, 30);
        lipuu.draw(g);
        mons.draw(g);
        mons1.draw(g);
        mons2.draw(g);
        mons3.draw(g);
        if (gameStatus == 0) {
            g.setColor(Color.black);
            g.drawString("PRESS START TO BEGIN..", 200, 200);
        }
        if (gameStatus == 2) {
            g.setColor(Color.ORANGE);
            g.drawString("The game is over", 200, 200);
        }
        g.setColor(Color.red);
        g.drawString("S C O R E : " + score, 15, 500);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == aTimer) {
            repaint(0, 0, 500, 600);
            requestFocus();
        }
    }

    public void moveLeft() {
        lipuu.moveLeft();
    }

    public void moveRight() {
        lipuu.moveRight();
    }

    public void moveUp() {
        lipuu.moveUp();
    }

    public void moveDown() {
        lipuu.moveDown();
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == 37) {
            moveLeft();
        } else if (keyCode == 38) {
            moveUp();
        } else if (keyCode == 39) {
            moveRight();
        } else if (keyCode == 40) {
            moveDown();
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}

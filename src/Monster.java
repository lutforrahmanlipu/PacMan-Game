import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Monster extends Item {

    private Random rdm = new Random();

    public Monster(int sx, int sy, int sp) {
        super(sx, sy, sp);
    }


public void draw(Graphics g) {
      int x = super.getX();
      int y = super.getY();
      g.setColor(Color.red);
      g.fillRect(x, y, 30, 30);
   }        

   public void handleBorderCollision() {  
      int x = super.getX();
      int y = super.getY();
      if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
              super.reverseDirection();
    } 
      updatePosition();
}
   
   public void hunting(Lipu S) {
      int mx = super.getX();
      int my = super.getY();
      int lipuX = S.getX();
      int LipuY = S.getY();
      int dir = rdm.nextInt(4);
      if (dir == 0) 
         moveLeft();
      else if (dir == 1) 
         moveUp();
      else if (dir == 2) 
         moveRight();
      else if (dir == 3) 
         moveDown();
         else if (dir == 4){
                 if (mx < lipuX)
                     super.moveRight();
                 else
                     super.moveLeft();
      }  else if (dir == 5) {
                 if (my < LipuY)
                     super.moveDown();
                 else
                     super.moveUp();
                 }
      }
}    




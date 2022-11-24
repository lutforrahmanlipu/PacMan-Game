

import java.awt.Color;
import java.awt.Graphics;

public class Lipu extends Item {

    public Lipu(int sx, int sy, int sp) {
        super(sx, sy, sp);
    }

    public void draw(Graphics g) {
        int x = super.getX();
        int y = super.getY();
        g.setColor(Color.black);
        int x1 = x;
        int y1 = y;
        int x2 = x + 15;
        int y2 = y;
        int x3 = x + 30;
        int y3 = y;
        int x4 = x;
        int y4 = y + 15;
        int x5 = x + 15;
        int y5 = y + 15;
        int x6 = x + 30;
        int y6 = y + 15;
        int x7 = x;
        int y7 = y + 30;
        int x8 = x + 15;
        int y8 = y + 30;
        int x9 = x + 30;
        int y9 = y + 30;
        int xpt[] = {x2, x9, x5, x7};
        int ypt[] = {y2, y9, y5, y7};
        g.fillPolygon(xpt, ypt, 4);
    }

    public boolean collideBorder() {
        boolean collide = false;
        int x = super.getX();
        int y = super.getY();
        if ((x <= 0) | (x >= 570) | (y <= 0) | (y >= 570)) {
            collide = true;
        }
        return collide;
    }

    public boolean collideWithMonster(Monster m) {
        boolean collide = false;
        int lipux = super.getX();
        int lipuy= super.getY();
        int monx = m.getX();
        int mony = m.getY();
        int monz = 30;
        if ((monx >= (lipux - monz)) & (monx <= (lipuy + monz)) & (mony >= (lipuy - monz)) & (mony <= (lipuy + monz)))
            collide = true;
        return collide;
    }
}
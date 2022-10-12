package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements Runnable{
    
    static private final int GAME_WIDTH = PanelContainer.PANEL_WIDTH;
    static private final int GAME_HEIGHT = PanelContainer.PANEL_HEIGHT;
    static private Dimension SCREEN_SIZE = PanelContainer.SCREEN_SIZE;
    static private final int PADDLE_HEIGHT = 100;
    static private final int PADDLE_WIDTH = 25;
    static private final int BALL_DIAMETER = 20;

    Thread gameThread;
    Image img;
    Graphics graphics;
    Paddle paddle;
    Ball ball;
    Score score;

    public GamePanel() {
        newPaddle();
        newBall();
        score = new Score(GAME_WIDTH, GAME_WIDTH);
        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(this.SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2) - (BALL_DIAMETER / 2), BALL_DIAMETER, BALL_DIAMETER);
    }

    public void newPaddle() {
        paddle = new Paddle(0, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
    }

    public void paint(Graphics g) {
        img = createImage(getWidth(), getHeight());
        graphics = img.getGraphics();
        draw(graphics);
        g.drawImage(img, 0, 0, this);
    }

    public void draw(Graphics g) {
        this.paddle.draw(g);
        this.ball.draw(g);
        this.score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }
    
    public void move() {
        this.paddle.move();
        this.ball.move();
    }

    public void checkCollisions() {
        // Playercollsions
        if(paddle.y <= 0 ){
            paddle.y = 0;
        }
        if(paddle.y >= GAME_HEIGHT - PADDLE_HEIGHT){
            paddle.y = GAME_HEIGHT - PADDLE_HEIGHT;

        }

        // Ballcollisions

        if(ball.y <= 0 || ball.y >= GAME_HEIGHT - BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }

        if(ball.x >= GAME_WIDTH - BALL_DIAMETER){
            ball.setXDirection(-ball.xVelocity);
        }

        // Playercollision

        if(ball.intersects(paddle)){
            ball.setXDirection(-ball.xVelocity);
            ball.speed++;
            score.playerscore++;
        }

        // Ball out of bound

        if(ball.x <= 0){
            newBall();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double clockTime = 120.0;
        double ns = (1 * Math.pow(10, 9)) / clockTime;
        double delta = 0;

        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1) {
                move();
                checkCollisions();
                repaint();
                delta--;
            }
        }
    }

    public class ActionListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }
    }

}
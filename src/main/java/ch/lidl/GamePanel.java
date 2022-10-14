package ch.lidl;

// Dependencies
import java.util.*;
import javax.swing.*;

import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;

import java.awt.*;
import java.awt.event.*;

import net.java.games.input.Component;
import net.java.games.input.Controller;
import net.java.games.input.ControllerEnvironment;
import net.java.games.input.Event;
import net.java.games.input.EventQueue;

public class GamePanel extends JPanel implements Runnable {

    static private final int GAME_WIDTH = PanelContainer.PANEL_WIDTH;
    static private final int GAME_HEIGHT = PanelContainer.PANEL_HEIGHT;
    static private Dimension SCREEN_SIZE = PanelContainer.SCREEN_SIZE;
    static private final int PADDLE_HEIGHT = 120;
    static private final int PADDLE_WIDTH = 18;
    static private final int BALL_DIAMETER = 20;

    Thread gameThread;
    Image img;
    Graphics graphics;
    Paddle paddle;
    Ball ball;
    GameHUD gameHUD;
    SaveScoreFile saveScoreFile;
    private String playerName;

    // Controller mVars
    Thread controllerThread;
    Controller controller;
    EventQueue eventQueue;
    Event event;

    public GamePanel(String playerName) {
        newPaddle();
        newBall();
        this.saveScoreFile = SaveScoreFile.getSaveScoreFileInstance();
        this.playerName = playerName;
        this.gameHUD = new GameHUD(GAME_WIDTH, GAME_HEIGHT, this.playerName);
        this.setFocusable(true);
        this.setPreferredSize(this.SCREEN_SIZE);

        this.controller = getController(ControllerEnvironment.getDefaultEnvironment().getControllers());
        this.eventQueue = controller.getEventQueue();
        this.event = new Event();
        
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newBall() {
        ball = new Ball((GAME_WIDTH / 2) - (BALL_DIAMETER / 2), (GAME_HEIGHT / 2) - (BALL_DIAMETER / 2), BALL_DIAMETER,
                BALL_DIAMETER);
    }

    public void newPaddle() {
        paddle = new Paddle(10, (GAME_HEIGHT / 2) - (PADDLE_HEIGHT / 2), PADDLE_WIDTH, PADDLE_HEIGHT, 1);
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
        this.gameHUD.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    public void move() {
        this.paddle.move();
        this.ball.move();
    }

    public void checkCollisions() {
        // Playercollsions
        if (paddle.y <= 0) {
            paddle.y = 0;
        }
        if (paddle.y >= GAME_HEIGHT - PADDLE_HEIGHT) {
            paddle.y = GAME_HEIGHT - PADDLE_HEIGHT;
        }

        // Ballcollisions

        if (ball.y <= 0 || ball.y >= GAME_HEIGHT - BALL_DIAMETER) {
            ball.setYDirection(-ball.yVelocity);
        }

        if (ball.x >= GAME_WIDTH - BALL_DIAMETER) {
            ball.setXDirection(-ball.xVelocity);
        }

        // Playercollision

        if (ball.intersects(paddle)) {
            ball.setXDirection(-ball.xVelocity);
            ball.increaseSpeed();
            gameHUD.playerscore++;
        }

        // Ball out of bound / Game Over

        if (ball.x <= 0) {
            this.saveScoreFile.addPlayerScore(playerName, gameHUD.playerscore);
            Frame frame = Frame.getInstance();
            frame.remove(this);
            frame.add(PanelContainer.getRestartMenuPanelInstance(this.playerName, gameHUD.playerscore));
            frame.repaint();
            frame.validate();
            this.gameThread.stop();
        }
    }

    private Controller getController(Controller[] controllers) {
        for (int i = 0; i < controllers.length; i++) {
            if (controllers[i].getType() == Controller.Type.STICK) {
                return controllers[i];
            }
        }
        return null;
    }

    public void run() {
        long lastTime = System.nanoTime();
        double clockTime = 120.0;
        double ns = (1 * Math.pow(10, 9)) / clockTime;
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta = (now - lastTime) / ns;

            if (delta >= 1) {
                lastTime = now;

                controller.poll();
                eventQueue.getNextEvent(event);

                Component component = event.getComponent();

                if (component != null) {
                    Component.Identifier identifier = component.getIdentifier();
                    float data = component.getPollData();
                    if (identifier == Component.Identifier.Button._0) {
                        this.paddle.controllerInput(identifier, data);
                    } else if (identifier == Component.Identifier.Button._2) {
                        this.paddle.controllerInput(identifier, data);
                    }
                }

                move();
                checkCollisions();
                repaint();
                delta--;
            }
        }
    }

}

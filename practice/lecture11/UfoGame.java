/*
* File: UfoGame.java
* ------------------
* This program plays a game where the user tries to
* shoot a UFO before the UFO "lands".
*/

import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;

public class UfoGame extends GraphicsProgram {
    
    // Size and speed of UFO
    private static final int UFO_WIDTH = 40;
    private static final int UFO_HEIGHT = UFO_WIDTH / 2;
    private static final int UFO_SPEED = 5;

    // Size and speed of bullets
    private static final int BULLET_SPEED = 10;
    private static final int BULLET_DIAM = 5;

    // Animation cycle delay
    private static final int DELAY = 10;

    public void run() {

        setup();
        while (!gameOver()) {
            moveUFO();
            moveBullet();
            checkForCollisions();
            pause(DELAY);
        }

    }

    // setup UFO and mouse listeners
    public void setup() {

        ufo = new GRect(UFO_WIDTH, UFO_HEIGHT);
        ufo.setFilled(true);
        add(ufo, getWidth(), 0); // Ufo starts at the top right
        ufoToLeft = true;
        addMouseListeners();
    }

    private void printLabel(String text) {
        label = new GLabel("");
        label.setLabel(text);
        label.setColor(Color.BLUE);
        label.setFont("Times New Roman-36");
        add(label, (getWidth() - label.getWidth()) / 2., (getHeight() - label.getAscent()) / 2.);
    }

    // determine if game is over -- ture if either the UFO is destroyed or if the UFO lands
    private boolean gameOver() {

        boolean flag = false;

        if (ufo == null) {
            flag = true;
            printLabel("Congrats, You WON!");
        } else if (ufo.getY() >= (getHeight() - ufo.getHeight())) {
            flag = true;
            printLabel("Game over, good luck next time");
        }

        return flag;
    

        // return (ufo == null) 
        //     || (ufo.getY() >= (getHeight() - ufo.getHeight()));
    }

    // When mouse is clicked create a bullet, unless bullet already exists
    public void mouseClicked(MouseEvent e) {
        if (bullet == null) {
            bullet = new GOval(BULLET_DIAM, BULLET_DIAM);
            bullet.setFilled(true);
            bullet.setColor(Color.RED);
            add(bullet, (getWidth() - BULLET_DIAM) / 2, getHeight() - BULLET_DIAM);
        }
    }

    // move UFO, if UFO is moved to edge of the screen, move UFO down and change it direction
    private void moveUFO() {
        if (ufoToLeft) {
            ufo.move(-UFO_SPEED, 0);
            if (ufo.getX() <= 0) {
                ufoToLeft = false;
                ufo.move(0, UFO_HEIGHT);
            }
        } else {
            ufo.move(UFO_SPEED, 0);
            if (ufo.getX() >= getWidth() - UFO_WIDTH) {
                ufoToLeft = true;
                ufo.move(0, UFO_HEIGHT);
            }
        }
    }

    // moves bullet
    private void moveBullet() {

        if (bullet != null) {
            bullet.move(0, -BULLET_SPEED);
        }
    }

    // check with bullet interaction with the world
    private void checkForCollisions() {
        collideWithUFO();
        moveOffScreen();
    }

    private void collideWithUFO() {
        if (bullet != null) {
            GObject collObj = getElementAt(bullet.getX(), bullet.getY());
            if (collObj == ufo) {
                remove(ufo);
                remove(bullet);
                ufo = null;
                bullet = null;
            }
        }
    }

    // determine if bullet has moved of screen
    private void moveOffScreen() {
        if (bullet != null) {
            if (bullet.getY() <= -BULLET_DIAM) {
                remove(bullet);
                bullet = null;
            }
        }
    }

    // private instance variables
    private GRect ufo;
    private GOval bullet;
    private boolean ufoToLeft; // when true, UFO is moving to left
    private GLabel label;

}

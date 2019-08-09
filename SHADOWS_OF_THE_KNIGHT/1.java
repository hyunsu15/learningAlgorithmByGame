import java.util.*;

import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse the standard input
 * according to the problem statement.
 **/
class Player {

    static Scanner in = new Scanner(System.in);
    static int x;
    static int y;
    static int minX = 0;
    static int minY = 0;

    static int maxX;
    static int maxY;

    static int maximumTurn;

    public static void main(String args[]) {
        initialize();
        gameStart();
    }

    static void initialize() {
        int buildingWidth = in.nextInt(); // width of the building.
        int buildingHeight = in.nextInt(); // height of the building.
        maximumTurn = in.nextInt(); // maximum number of turns before game over.
        maxX = buildingWidth - 1;
        maxY = buildingHeight - 1;
        x= in.nextInt();
         y= in.nextInt();
    
    }

    static void gameStart() {
        while (true) {
            String bombDir = in.next();
            bombDirection(bombDir);
            
            System.out.println(x+" "+y);
        }
    }

    static void bombDirection(String bombDirection) {
        if (bombDirection.length() == 2)
            twoVector(bombDirection);
        if (bombDirection.length() == 1)
            oneVector(bombDirection);
    }

    static void twoVector(String bombDirection) {
        if (bombDirection.charAt(0) == 'U')
            upVector();
        else
            downVector();
        
        if (bombDirection.charAt(1) == 'R')
            rightVector();
        else
            leftVector();
    }

    static void oneVector(String bombDirection) {
        if (bombDirection.equals("U"))
            upVector();
        if (bombDirection.equals("D"))
            downVector();
        if (bombDirection.equals("R"))
            rightVector();
        if (bombDirection.equals("L"))
            leftVector();
    }

    static void downVector() {
        minY=y;
    	y = y + (maxY - minY+1) / 2;
    }

    static void upVector() {
    	maxY=y;
        y= minY+(maxY- minY) / 2;
    }

    static void leftVector() {
        maxX=x;
    	x = minX+(maxX-minX) / 2;
    }

    static void rightVector() {
        minX=x;
    	x = x + (maxX - minX + 1) / 2;
    }

}

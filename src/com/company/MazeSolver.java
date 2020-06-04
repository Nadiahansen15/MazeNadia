package com.company;

import java.util.LinkedList;

public class MazeSolver {

    int [][] maze = { // we see the maze from up, so left is always left
            {2,1,1,1},
            {1,0,1,1},
            {0,0,0,1}
    };

    // LinkedList<Positionxy> path = new LinkedList<Positionxy>(); // keeps track

    //0 = wall
    //1 = path
    //2 = destination (gold)



    public void Mazeposition () {

        LinkedList<Positionxy> path = new LinkedList<Positionxy>(); // keeps track

        Positionxy p = new Positionxy(0, 3); //starts position
        path.push(p); //Push  - adds to begining af the list


        while (true) {
            // Peek gives the first element in the list
            int y = path.peek().y;
            int x = path.peek().x;
            maze[y][x] = 0;
            //keeps track of place we visit an sets to 0
            // y(row) first, x(colum) second.

            //Down
            if (isValid(y+1, x)){
                if (maze[y + 1][x] == 2) {
                    System.out.println("Moved down. You won!");
                    break;
                } else if (maze[y + 1][x] == 1) {
                    System.out.println("Moved down");
                    path.push(new Positionxy(y + 1, x));
                    continue;
                }
            }

            //left
            if (isValid(y, x-1)) {
                if (maze[y][x - 1] == 2) {
                    System.out.println("Moved left. You won!");
                    break;
                } else if (maze[y][x - 1] == 1) {
                    System.out.println("Moved left");
                    path.push(new Positionxy(y, x - 1));
                    continue;
                }
            }

            //up
            if(isValid(y-1, x)){
                if (maze[y - 1][x] == 2) {
                    System.out.println(" Moved up. You won!");
                    break;
                } else if (maze[y - 1][x] == 1) {
                    System.out.println("Moved up");
                    path.push(new Positionxy(y - 1, x));
                    continue;
                }
            }

            //right
            if(isValid(y,x+1)) {
                if (maze[y][x + 1] == 2) {
                    System.out.println("Moved right. You won!");
                    break;
                } else if (maze[y][x + 1] == 1) {
                    System.out.println("Moved right");
                    path.push(new Positionxy(y, x + 1));
                    continue;
                }
            }
            //picks the first element in a stack and removes
            path.pop();
            System.out.println("Moved back");
            if (path.size() <= 0) {
                System.out.println("No Path");
                return;
            }
        }

    }
    public boolean isValid(int y, int x) {
        if(y< 0 || y >= maze.length || x < 0 || x>= maze[y].length)
        {
            return false;
        }
        return true;
    }
}

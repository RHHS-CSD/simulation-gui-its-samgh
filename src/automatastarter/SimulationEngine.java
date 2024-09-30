/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package automatastarter;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author sam
 */
public class SimulationEngine {
        //Constants for cell states
    private static final int OFF = 0;
    private static final int ON = 1;
    private static final int DYING = 2;
    
    public static void main(String[] args) {
        //variable of user ansewrs to go to the next stage 
        String answer = "";
        //Scanner
        Scanner sc = new Scanner(System.in);
        
        //Grid variables
        int[][] grid;
        int rows, columns;
        
        //setting rows and columns
        rows = setRows();
        columns = setColumns();
        
        //initializing the grid
        grid = initializeGrid(rows, columns);
        
        
        //looping untill the user quits
        while(!answer.equals("n")){
            //asking if the user wants to continue or not
            System.out.println("Do you want to continue? y/n");
            answer = sc.nextLine();
            //showing the grid
            printGrid(grid);
            grid = applyRules(rows,columns,grid);
        }
        //exiting the program
        System.out.println("See you soon!");
    }
    
    
   /**
    * This method applies the rules of Brian's Brain for one stage or iteration:
    * ON cells become DYING, DYING cells become OFF, and OFF cells with exactly two ON neighbors become ON.
    * @param rows the number of rows in the grid
    * @param columns the number of columns in the grid
    * @param grid the current grid representing the simulation state
    * @return the new grid after the rules are applied
    */
    public static int[][] applyRules(int rows, int columns, int[][]grid){
        //doing the operations on a new grid
        int[][] newGrid = new int[rows][columns];
        
        //looping through each cell
        for(int row = 0; row < rows; row++){
            for(int column = 0; column < columns; column++){
                //Apply the rules to each cell: ON -> DYING, DYING -> OFF, OFF -> ON (if 2 neighbors are ON not more or less)
                //On cells become dying cells
                if(grid[row][column] == ON){
                    newGrid[row][column] = DYING;
                }
                //Dying cells become off cells
                else if(grid[row][column] == DYING){
                    newGrid[row][column] = OFF;
                }
                //Off cells become on cells if exactly two neighboring cells are on.
                else if(grid[row][column] == OFF){
                    int aliveNEighbors = countOnNeighbors(row,column,grid);
                    if(aliveNEighbors == 2){
                        newGrid[row][column] = ON;
                    }
                }
            }
        }
        return newGrid;
    }
    /**
     * This method counts the ON neighbors
     * @param row the specific row in the grid which we want to know the ON neighbors
     * @param column the specific column in the grid which we want to know the ON neighbors
     * @param grid this is the grid in the simulation
     * @return it returns the number on ON neighbors
     */
    public static int countOnNeighbors(int row, int column, int[][]grid){
        //variable count
        int count = 0;
        
        //going through the 8 neighbours
        for(int i = -1; i <= 1; i++){
            /* old logic, now the program wraps around the cell
            //not looping through negatives or out of the array
            if((row == 0 && i == -1) || (row == grid.length && i == 1)){
                continue;
            }
            */
            for(int j = -1; j <= 1; j ++){
                /* old logic, now the program wraps around the cell
                //not looping through negatives or out of the array
                if((column == 0 && j == -1) || (column == grid[0].length && j == 1)){
                    continue;
                }
                */
                //not checking the cell itself
                if(i == 0 && j == 0){
                    continue;
                }
                //wrapping the grid to ensure the grid edges connect
                //adding grid length ensures no negative values
                int neighborRow = (row + i + grid.length) % grid.length;
                //thank you Mr RD :)
                int neighborColumn = (column + j + grid[0].length ) % grid[0].length;
                //if the cell is on add to count
                if(grid[neighborRow][neighborColumn] == ON){
                    count++;
                }
            }
        }
        
        return count;
    }
    
    /**
     * This method fills the grid with random variables from 0-2(or states of ON OFF or DYING)
     * @param rows  the number of rows in the grid
     * @param columns  the number of columns in the grid
     * @return the grid initialized with random states of cells
     */
    public static int[][] initializeGrid(int rows, int columns) {
        //making the grid
        int[][] grid = new int[rows][columns];
        Random random = new Random();
        
        //looping through the array and assigning cell stages randomly
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // Randomly assign OFF, ON, or DYING
                grid[i][j] = random.nextInt(3); 
            }
        }
        
        return grid;
    }
    /**
     * This method gets input from the user and returns the value of rows needed for the grid
     * @return the number of rows that the user wants
     */
    public static int setRows(){
        Scanner sc = new Scanner(System.in);
        System.out.println("how many rows do you want? ");
        int rows = sc.nextInt();
        //Flush the input to handle the newline character after using nextInt()
        String flush = sc.nextLine();
        
        return rows;
    }
    
    /**
     * This method gets input from the user and returns the value of columns needed for the grid
     * @return the number of columns that the user wants
     */
    public static int setColumns(){
        Scanner sc = new Scanner(System.in);
        System.out.println("how many columns do you want? ");
        int columns = sc.nextInt();
        //Flush the input to handle the newline character after using nextInt()
        String flush = sc.nextLine();
        
        return columns;
    }
    
    /**
     * This method .prints the current grid. 
     * It uses a nested loops and a switch statement.
     * We assume the grid is not a jagged array.
     * Each cell's state is represented visually as the following:
     * ON cells as 'O'
     * OFF cells as '.'
     * DYING cells as 'X'
     * 
     * @param grid this is the current 2D array grid in the simulation
     */
    public static void printGrid(int grid[][]){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                //System.out.print(grid[i][j] + " ");
                //Printing the numbers is insuffitient so it will be visualized using a java switch
                switch (grid[i][j]){
                    case ON:
                        System.out.print("O ");
                        break;
                    case OFF:
                        System.out.print(". ");
                        break;
                    case DYING:
                        System.out.print("X ");
                        break;
                }
            }
            //printing next line
            System.out.println("");
        }
        //seperating grids
        for(int i = 0; i < grid.length; i++){
            System.out.print("* ");
        }
        System.out.println("");
    }
    
        /**
     * Static method to count the number of alive, dying, and dead cells in the grid.
     * This method traverses the given grid and counts how many cells are in each of the 
     * three states: alive, dying, and dead. It assumes that cells are represented as integers, 
     * (0 for dead, 1 for alive, 2 for dying).
     * 
     * @param grid A 2D array of integers representing the grid of cells, where each cell holds (0 for dead, 1 for alive, 2 for dying).
     * @return An array of three integers, where the first element is the number of alive cells, 
     *         the second element is the number of dying cells, and the third element is the 
     *         number of dead cells.
     */
    public static int[] getCellCounts(int[][] grid) {
        int aliveCount = 0;
        int dyingCount = 0;
        int deadCount = 0;

        // Traverse through the grid to count the cell states
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                switch (grid[i][j]) {
                    case ON:
                        aliveCount++;
                        break;
                    case DYING:
                        dyingCount++;
                        break;
                    case OFF:
                        deadCount++;
                        break;
                }
            }
        }

        // Return the counts in an array [aliveCount, dyingCount, deadCount]
        return new int[]{aliveCount, dyingCount, deadCount};
    }
}

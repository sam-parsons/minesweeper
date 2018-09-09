import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


/**
 * This class is a representation of a Minesweeper-type game board.
 * Generate, update(add), and print methods are include with 
 * the two dimensional array as a global variable.
 */

public class Minefield {

    int[][] mineCounts;

    int[][] revealArr;

    public void generate(int dim, int diff) {
        int probSplit = diff;
        int rand;
        
        mineCounts = new int[dim][dim];

        for (int i = 0; i < dim; i ++) {
            for (int j = 0; j < dim; j++) {
                rand = randomNum();
                if (rand <= probSplit) {
                    mineCounts[i][j] = -1;
                } else {
                    mineCounts[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if (mineCounts[i][j] == -1) {
                    if ((i>0&&i<dim-1) && (j>0&&j<dim-1)) {
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    } else if (i==0 && j==0) {
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    } else if (i==dim-1 && j==0) {
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                    } else if (i==dim-1 && j==dim-1) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                    } else if (i==0 && j==dim-1) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                    } else if ((i > 0 && i < dim-1) && j==0) {
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    } else if ((i > 0 && i < dim-1) && j==dim-1) {
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                    } else if ((j > 0 && j < dim-1) && i==dim-1) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                    } else if ((j > 0 && j < dim-1) && i==0) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    }
                }
            }
        }

    }

    private static int randomNum() {
        return (int)(Math.random() * 100) + 1;
    }


    /**
     * Takes info from text file and forms game board accordingly
     */
    public void generateFromFile() {
        
        // obtain dimensions of input
        int dim = 0;
        try {
            Scanner scan = new Scanner(new BufferedReader(new FileReader("input.txt")));
            dim = scan.nextInt();
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        //populate empty arrays with 0 values
        mineCounts = new int[dim][dim];
        for (int[] row: mineCounts) {
            Arrays.fill(row, 0);
        }

        // parse strings into an int array
        try { 
            Scanner scan = new Scanner(new BufferedReader(new FileReader("input.txt")));
            scan.nextLine();
            for (int i = 0; i < dim; i++) {
                String[] line = scan.nextLine().split("");
                for (int j = 0; j < dim; j++) {
                    if (line[j].equals("X")) {

                        mineCounts[i][j] = -1;

                        if ((i>0&&i<dim-1) && (j>0&&j<dim-1)) {
                            mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                            mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                            mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                            mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                            mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                            mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                            mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                            mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                        } else if (i==0 && j==0) {
                            mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                            mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                            mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                        } else if (i==dim-1 && j==0) {
                            mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                            mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                            mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        } else if (i==dim-1 && j==dim-1) {
                            mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                            mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                            mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        } else if (i==0 && j==dim-1) {
                            mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                            mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                            mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        } else if ((i > 0 && i < dim-1) && j==0) {
                            mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                            mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                            mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                            mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                            mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                        } else if ((i > 0 && i < dim-1) && j==dim-1) {
                            mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                            mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                            mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                            mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                            mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        } else if ((j > 0 && j < dim-1) && i==dim-1) {
                            mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                            mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                            mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                            mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                            mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                        } else if ((j > 0 && j < dim-1) && i==0) {
                            mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                            mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                            mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                            mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                            mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                        }
                    }
                    
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method adds a mine to the board and updates border numbers.
     * 
     * @param k x-dimension of mine
     * @param l y-dimension of mine
     */
    public void addMine(int k, int l) {
        int dim = mineCounts[0].length;

        System.out.println("Adding mine at " + k + ", " + l);
        
        mineCounts[k][l] = -1;

        // reset board except for mines
        for (int i = 0; i < dim; i++) {

            for (int j = 0; j < dim; j++) {
                if (mineCounts[i][j] != -1) {
                    mineCounts[i][j] = 0;
                }
            }

        }

        // calculate boarder numbers
        for (int i = 0; i < dim; i++) {

            for (int j = 0; j < dim; j++) {
                if (mineCounts[i][j] == -1) {

                    if ((i>0&&i<dim-1) && (j>0&&j<dim-1)) {
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    } else if (i==0 && j==0) {
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    } else if (i==dim-1 && j==0) {
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                    } else if (i==dim-1 && j==dim-1) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                    } else if (i==0 && j==dim-1) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                    } else if ((i > 0 && i < dim-1) && j==0) {
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    } else if ((i > 0 && i < dim-1) && j==dim-1) {
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                    } else if ((j > 0 && j < dim-1) && i==dim-1) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i-1][j-1] = mineCounts[i-1][j-1] == -1 ? -1 : mineCounts[i-1][j-1] + 1;
                        mineCounts[i-1][j] = mineCounts[i-1][j] == -1 ? -1 : mineCounts[i-1][j] + 1;
                        mineCounts[i-1][j+1] = mineCounts[i-1][j+1] == -1 ? -1 : mineCounts[i-1][j+1] + 1;
                    } else if ((j > 0 && j < dim-1) && i==0) {
                        mineCounts[i][j-1] = mineCounts[i][j-1] == -1 ? -1 : mineCounts[i][j-1] + 1;
                        mineCounts[i][j+1] = mineCounts[i][j+1] == -1 ? -1 : mineCounts[i][j+1] + 1;
                        mineCounts[i+1][j-1] = mineCounts[i+1][j-1] == -1 ? -1 : mineCounts[i+1][j-1] + 1;
                        mineCounts[i+1][j] = mineCounts[i+1][j] == -1 ? -1 : mineCounts[i+1][j] + 1;
                        mineCounts[i+1][j+1] = mineCounts[i+1][j+1] == -1 ? -1 : mineCounts[i+1][j+1] + 1;
                    }
                }
            }

        }
        System.out.println("====================");
    }

    /**
     * This method prints a translation of the board to the console
     */
    public void printField() {
        int len = mineCounts[0].length;
        System.out.println();

        if (len > 15) {
            System.out.printf("\t\t              ");
        } else if (len < 16 && len > 10) {
            System.out.printf("\t\t\t           ");
        } else {
            System.out.printf("\t\t\t\t        ");
        }
        
        for (int i = 1; i <= mineCounts[0].length; i++) {
            System.out.printf("%d ", i % 10);
        }
        for (int i = 1; i <= mineCounts[0].length; i++) {
            System.out.println();
            if (i < 10) {

                if (len > 15) {
                    System.out.printf("\t\t            %d ", i);
                } else if (len < 16 && len > 10) {
                    System.out.printf("\t\t\t         %d ", i);
                } else {
                    System.out.printf("\t\t\t\t      %d ", i);
                }
                
            } else {

                if (len > 15) {
                    System.out.printf("\t\t            %d ", i);
                } else if (len < 16 && len > 10) {
                    System.out.printf("\t\t\t        %d ", i);
                } else {
                    System.out.printf("\t\t\t\t      %d ", i);
                }

            }
            
            for (int j = 0; j < mineCounts[0].length; j++) {
                if (mineCounts[i-1][j] == -1) {
                    System.out.print("@ ");
                } else if (mineCounts[i-1][j] == 0) {
                    System.out.print(". ");
                } else {
                    System.out.print(mineCounts[i-1][j] + " ");
                }
            }
        }

        if (len < 10) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        } else {
            System.out.println();
            System.out.println();
            System.out.println();
        }

        System.out.println("\t\t\t            ====================");
    }

    public void reveal(int row, int column) {
        int len = mineCounts[0].length;
        
        // if (revealArr[0][0] != 0 && revealArr[0][0] != 1) {
        //     genRevealArr();
        // }

        //print out existing revealArr and user's choice

        if (row < 0 || column < 0 || row >= len || column >= len) {
            System.out.println("Please enter a valid position on the field");
        } else if (mineCounts[row][column] == 0) {
            revealArr[row][column] = 1;

            if (row == 0 && column == 0) {
                if (revealArr[row+1][column] == 0) {
                    reveal(row+1, column);
                }
                if (revealArr[row][column+1] == 0) {
                    reveal(row, column+1);
                }
                if (revealArr[row+1][column+1] == 0) {
                    reveal(row+1, column+1);
                }
            } else if (row == 0 && column == len-1) {
                if (revealArr[row][column-1] == 0) {
                    reveal(row, column-1);
                }
                if (revealArr[row+1][column-1] == 0) {
                    reveal(row+1, column-1);
                }
                if (revealArr[row+1][column] == 0) {
                    reveal(row+1, column);
                }
            } else if (row == len-1 && column == 0) {
                if (revealArr[row-1][column] == 0) {
                    reveal(row-1, column);
                }
                if (revealArr[row-1][column+1] == 0) {
                    reveal(row-1, column+1);
                }
                if (revealArr[row][column+1] == 0) {
                    reveal(row, column+1);
                }
            } else if (row == len-1 && column == len-1) {
                if (revealArr[row][column-1] == 0) {
                    reveal(row, column-1);
                }
                if (revealArr[row-1][column-1] == 0) {
                    reveal(row-1, column-1);
                }
                if (revealArr[row-1][column] == 0) {
                    reveal(row-1, column);
                }
            } else if (row == 0 && (column > 0 && column < len-1)) {
                if (revealArr[row][column-1] == 0) {
                    reveal(row, column-1);
                }
                if (revealArr[row][column+1] == 0) {
                    reveal(row, column+1);
                }
                if (revealArr[row+1][column-1] == 0) {
                    reveal(row+1, column-1);
                }
                if (revealArr[row+1][column] == 0) {
                    reveal(row+1, column);
                }
                if (revealArr[row+1][column+1] == 0) {
                    reveal(row+1, column+1);
                }
            } else if (row == len-1 && (column > 0 && column < len-1)) {
                if (revealArr[row][column-1] == 0) {
                    reveal(row, column-1);
                }
                if (revealArr[row][column+1] == 0) {
                    reveal(row, column+1);
                }
                if (revealArr[row-1][column-1] == 0) {
                    reveal(row-1, column-1);
                }
                if (revealArr[row-1][column] == 0) {
                    reveal(row-1, column);
                }
                if (revealArr[row-1][column+1] == 0) {
                    reveal(row-1, column+1);
                }
            } else if ((row > 0 && row < len-1) && column == 0) {
                if (revealArr[row-1][column] == 0) {
                    reveal(row-1, column);
                }
                if (revealArr[row-1][column+1] == 0) {
                    reveal(row-1, column+1);
                }
                if (revealArr[row][column+1] == 0) {
                    reveal(row, column+1);
                }
                if (revealArr[row+1][column] == 0) {
                    reveal(row+1, column);
                }
                if (revealArr[row+1][column+1] == 0) {
                    reveal(row+1, column+1);
                }
            } else if ((row > 0 && row < len-1) && column == len-1) {
                if (revealArr[row-1][column] == 0) {
                    reveal(row-1, column);
                }
                if (revealArr[row-1][column-1] == 0) {
                    reveal(row-1, column-1);
                }
                if (revealArr[row][column-1] == 0) {
                    reveal(row, column-1);
                }
                if (revealArr[row+1][column] == 0) {
                    reveal(row+1, column);
                }
                if (revealArr[row+1][column-1] == 0) {
                    reveal(row+1, column-1);
                }
            } else {
                if (revealArr[row-1][column-1] == 0) {
                    reveal(row-1, column-1);
                }
                if (revealArr[row-1][column] == 0) {
                    reveal(row-1, column);
                }
                if (revealArr[row-1][column+1] == 0) {
                    reveal(row-1, column+1);
                }
                if (revealArr[row][column-1] == 0) {
                    reveal(row, column-1);
                }
                if (revealArr[row][column+1] == 0) {
                    reveal(row, column+1);
                }
                if (revealArr[row+1][column-1] == 0) {
                    reveal(row+1, column-1);
                }
                if (revealArr[row+1][column] == 0) {
                    reveal(row+1, column);
                }
                if (revealArr[row+1][column+1] == 0) {
                    reveal(row+1, column+1);
                }
            }

        } else if (mineCounts[row][column] > 0) {
            revealArr[row][column] = 1;
        } else if (mineCounts[row][column] == -1) {

        }

    }

    public void genRevealArr() {
        int len = mineCounts[0].length;
        revealArr = new int[len][len];
        for (int[] row: revealArr) {
            Arrays.fill(row, 0);
        }
    }

    public void printRevealArr() {
        int len = mineCounts[0].length;
        
        System.out.println();

        if (len > 15) {
            System.out.print("\t\t             ");
        } else if (len < 16 && len > 10) {
            System.out.print("\t\t\t           ");
        } else {
            System.out.print("\t\t\t\t         ");
        } 
        
        for (int i = 1; i <= mineCounts[0].length; i++) {
            System.out.printf("%d ", i % 10);
        }
        for (int i = 1; i <= mineCounts[0].length; i++) {
            System.out.println();
            if (i < 10) {

                if (len > 15) {
                    System.out.printf("\t\t           %d ", i);
                } else if (len < 16 && len > 10) {
                    System.out.printf("\t\t\t         %d ", i);
                } else {
                    System.out.printf("\t\t\t\t       %d ", i);
                }

            } else {

                if (len > 15) {
                    System.out.printf("\t\t          %d ", i);
                } else if (len < 16 && len > 10) {
                    System.out.printf("\t\t\t        %d ", i);
                } else {
                    System.out.printf("\t\t\t\t      %d ", i);
                }

            }
            for (int j = 0; j < mineCounts[0].length; j++) {
                if (revealArr[i-1][j] == 1) {
                    if (mineCounts[i-1][j] == -1) {
                        System.out.print("@ ");
                    } else if (mineCounts[i-1][j] == 0) {
                        System.out.print(". ");
                    } else {
                        System.out.print(mineCounts[i-1][j] + " ");
                    }
                } else if (revealArr[i-1][j] == 0) {
                    System.out.print("[]");
                } else if (revealArr[i-1][j] == -1) {
                    System.out.print("m ");
                }
            }
        }
        // possible conditional linked to dimensions to control space
        

        if (len < 10) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        } else {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }

    public boolean isMine(int row, int column) {
        boolean isMine = false;
        if (mineCounts[row][column] == -1) {
            isMine = true;
        }
        return isMine;
    }

    public boolean isNumber(int row, int column) {
        boolean isNumber = false;
        if (mineCounts[row][column] >= 0) {
            isNumber = true;
        }
        return isNumber;
    }

    public boolean isHidden(int row, int column) {
        boolean isHidden;
        if (revealArr[row][column] == 0) {
            isHidden = true;
        } else {
            isHidden = false;
        }
        return isHidden;
    }

    public boolean isNotComplete() {
        boolean notComplete = false;
        int len = mineCounts[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (revealArr[i][j] == 0) {
                    notComplete = true;
                } else if (revealArr[i][j] == -1) {
                    if (mineCounts[i][j] != -1) {
                        notComplete = true;
                    }
                }
            }
        }
        return notComplete;
    }

    public void markMine(int row, int column) {
        if (revealArr[row][column] == -1) {
            revealArr[row][column] = 0;
        } else {
            revealArr[row][column] = -1;
        }
    }

    public boolean isEmpty() {
        boolean empty = true;
        int len = mineCounts[0].length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (mineCounts[i][j] != 0) {
                    empty = false;
                }
            }
        }
        return empty;
    }

}
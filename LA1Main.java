import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


/**
 * This program generates a minefield from a given input source,
 * adds two mines, and prints the field.
 * 
 * Useful future additions: 
 * - You Win/Lose banner at end of game with genText1
 */

public class LA1Main {

    public static void main(String[] args) {
        
        boolean playGame = true;
        
        while (playGame) {

            for (int i = 0; i < 50; ++i) System.out.println();

            String endGame;    
            boolean addMine = true;
            boolean revealMine = true;
            String addMineYN;
            int addMineX = -1;
            int addMineY = -1;
            int revealX = -1;
            int revealY = -1;
            int fieldDim = 0;
            String fieldDimStr = "";
            int fieldDiff = 0;
            String fieldDiffStr = "";

            Minefield mf = new Minefield();
            // mf.generateFromFile();
            Scanner scan = new Scanner(System.in);

            try {
                BufferedReader br = new BufferedReader(new FileReader("banner.txt"));
                String line = null;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            

            System.out.println();
            System.out.println();
            System.out.println("========================");
            System.out.println("Welcome to Mineseeper");
            System.out.println("========================");
            System.out.println();
            System.out.println();


            
            genText1 gt = new genText1();

            

            gt.generateText();
            try {
                BufferedReader br = new BufferedReader(new FileReader("bannerName.txt"));
                String line = null;
                for (int i = 0; i < 50; i++) System.out.println();
                System.out.println("Welcome");
                System.out.println();
                System.out.println();
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println();

            // Print out full game directions
            System.out.println("\t\t\tRULES OF THE GAME");
            System.out.println("\t\t\tThe goal of MineSeeper is eliminate all unrevealed spaces - []");
            System.out.println("\t\t\tand mark all mines without revealing them.");
            System.out.println("\t\t\tHave a partner enter more mines on a field for added difficulty!");

            System.out.println();
            System.out.println();

            System.out.println("==========DIMENSIONS OF THE FIELD==========");
            do {
                System.out.print("Please enter an integer between 2 and 20: ");
                fieldDimStr = scan.next(); 
                try {
                    fieldDim = Integer.parseInt(fieldDimStr);
                } catch (NumberFormatException e) {

                }
            } while (fieldDim < 2 || fieldDim > 20);


            System.out.println("=====================================");
            do {
                System.out.print("Pick a degree of diffculty (1-15): ");
                fieldDiffStr = scan.next();
                try {
                    fieldDiff = Integer.parseInt(fieldDiffStr);
                } catch (NumberFormatException e) {

                }
            } while (fieldDiff < 1 || fieldDiff > 15);

            mf.generate(fieldDim, fieldDiff);
            while (mf.isEmpty()) {
                mf.generate(fieldDim, fieldDiff);
            }
            // mf.printField();

            mf.genRevealArr();
            mf.printRevealArr();
            System.out.println();

            String addMineXStr = "";
            String addMineYStr = "";
            
            while (addMine) {
                System.out.print("Would you like to add a mine to the field? (Y/n): ");
                addMineYN = scan.next();
                if (addMineYN.equals("N") || addMineYN.equals("n")) {
                    addMine = false;
                } else if (addMineYN.equals("Y") || addMineYN.equals("y")) {
                    
                    do {
                        System.out.print("Enter row of mine to be added between 0 and " + (fieldDim-1) + " (integer): "); 
                        addMineXStr = scan.next();
                        try {
                            addMineX = Integer.parseInt(addMineXStr);
                        } catch (NumberFormatException e) {
        
                        }
                    } while (addMineX < 1 || addMineX > fieldDim-1);
                   
                    do {
                        System.out.print("Enter column of mine to be added between 0 and " + (fieldDim-1) + " (integer): "); 
                        addMineYStr = scan.next();
                        try {
                            addMineY = Integer.parseInt(addMineYStr);
                        } catch (NumberFormatException e) {
        
                        }
                    } while (addMineY < 1 || addMineY > fieldDim-1);
                    mf.addMine(addMineX, addMineY);
                }

                if(addMine == true && (addMineYN.equals("N") || addMineYN.equals("n") || addMineYN.equals("Y") || addMineYN.equals("y"))) {
                    System.out.print("Would you like to add another mine to the field? (Y/n): ");
                }
            }

            for (int i = 0; i < 50; i++) System.out.println();

            System.out.println("==================================");
            System.out.println("Minefield assembled, ready to play");
            System.out.println("==================================");

            String revealXStr = "";
            String revealYStr = "";
            while (revealMine) {
                mf.printRevealArr();
                System.out.println();
                System.out.println();
                    
                if (mf.isNotComplete()) {
                    do {
                        System.out.print("Enter row of space to be revealed between 0 and " + (fieldDim-1) + " (integer): ");
                        revealXStr = scan.next();
                        try {
                            revealX = Integer.parseInt(revealXStr);
                        } catch (NumberFormatException e) {
        
                        }
                    } while (revealX < 0 || revealX > fieldDim-1);

                    do {
                        System.out.print("Enter column of space to be revealed between 0 and " + (fieldDim-1) + " (integer): ");
                        revealYStr = scan.next();
                        try {
                            revealY = Integer.parseInt(revealYStr);
                        } catch (NumberFormatException e) {
        
                        }
                    } while (revealY < 0 || revealY > fieldDim-1);

                    mf.reveal(revealX, revealY);
                }


                mf.printRevealArr();
                System.out.println();
                if (mf.isMine(revealX, revealY)) {
                    System.out.println("=================");
                    System.out.println("You picked a mine, you lose!");
                    System.out.println("=================");
                    revealMine = false;
                } else if (!mf.isNotComplete()) {
                    System.out.println("==================================");
                    System.out.println("All open spaces revealed and mines marked, you win!");
                    System.out.println("==================================");
                    revealMine = false;
                } else {  
                    System.out.println("=============");
                    boolean markMine = false;

                    // do while to coerce user input for "would you like to mark a mine?"
                    String markYN = "";
                    do {
                        System.out.print("Would you like to mark a mine? (Y/n): ");                        
                        
                        try {
                            markYN = scan.next();
                        } catch (NumberFormatException e) {
        
                        }
                    } while (!markYN.equals("y") && !markYN.equals("Y") && !markYN.equals("n") && !markYN.equals("N"));

                    if (markYN.equals("Y") || markYN.equals("y")) {
                        markMine = true;
                    }
                    while (markMine && mf.isNotComplete()) {
                        System.out.println("Enter the coordinates of the mine to be marked.");
                        System.out.println("If you wish to unmark a mine, enter those coordinates.");
                        System.out.println("=============");
                        int markRow = -1;
                        int markCol = -1;
                        String markRowStr = "";
                        String markColStr = "";

                        do {
                            System.out.print("Enter the row to be (un)marked (integer between 0 and " + (fieldDim-1) + "): ");
                            markRowStr = scan.next();
                            try {
                                markRow = Integer.parseInt(markRowStr);
                            } catch (NumberFormatException e) {
            
                            }
                        } while (markRow < 0 || markRow > fieldDim-1);

                        do {
                            System.out.print("Enter the column to be (un)marked (integer between 0 and " + (fieldDim-1) + "): ");
                            markColStr = scan.next();
                            try {
                                markCol = Integer.parseInt(markColStr);
                            } catch (NumberFormatException e) {
            
                            }
                        } while (markCol < 0 || markCol > fieldDim-1);

                        mf.markMine(markRow, markCol);

                        if (!mf.isNotComplete()) {
                            for (int i = 0; i < 50; i++) System.out.println();
                            System.out.println("===================================================");
                            System.out.println("All open spaces revealed and mines marked, you win!");
                            System.out.println("===================================================");
                            revealMine = false;
                            markMine = false;
                        } 

                        // mf.printRevealArr();
                        System.out.println();

                        if (markMine) {

                            String markAgainYN = "";
                            do {
                                System.out.print("Would you like to mark a mine? (Y/n): ");                        
                                
                                try {
                                    markAgainYN = scan.next();
                                } catch (NumberFormatException e) {
                
                                }
                            } while (!markAgainYN.equals("y") && !markAgainYN.equals("Y") && !markAgainYN.equals("n") && !markAgainYN.equals("N"));
        
                            if (markAgainYN.equals("N") || markAgainYN.equals("n")) {
                                markMine = false;
                            }

                        }
                    }

                    if (mf.isMine(revealX, revealY)) {
                        for (int i = 0; i < 50; i++) System.out.println();
                        System.out.println("============================");
                        System.out.println("You picked a mine, you lose!");
                        System.out.println("============================");
                        revealMine = false;
                    } else if (!mf.isNotComplete()) {
                        for (int i = 0; i < 50; i++) System.out.println();
                        System.out.println("===================================================");
                        System.out.println("All open spaces revealed and mines marked, you win!");
                        System.out.println("===================================================");
                        revealMine = false;
                    } 
                }    
            }

            mf.printField();
            do {
                System.out.print("Play again? (Y/n): ");
                endGame = scan.next();
                if (endGame.equals("N") || endGame.equals("n")) {
                    playGame = false;
                }
            } while (!endGame.equals("N") && !endGame.equals("n") && !endGame.equals("Y") && !endGame.equals("y"));
        }
       
    }
}
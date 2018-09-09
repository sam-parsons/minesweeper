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
 * - research scanner's handling of return key with empty string
 * - make diffculty scale with field size
 * - give visible error messages for marking an unrevealed space
 */

public class LA1Main {

    public static void main(String[] args) {
        
        for (int i = 0; i < 50; i++) System.out.println();

        boolean playGame = true;

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
        System.out.println("\t\t\t\t=====================");
        System.out.println("\t\t\t\tWelcome to Mineseeper");
        System.out.println("\t\t\t\t=====================");
        System.out.println();
        System.out.println();
        
        genText1 gt = new genText1();
        gt.generateText();

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
                BufferedReader br = new BufferedReader(new FileReader("bannerName.txt"));
                String line = null;
                for (int i = 0; i < 50; i++) System.out.println();
                System.out.println("Welcome");
                System.out.println();
                System.out.println();
                while ((line = br.readLine()) != null) {
                    System.out.print("\t");
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
            System.out.println("\t\t\tHave a partner enter more mines on a field for added difficulty");

            System.out.println();
            System.out.println();

            System.out.println("\t\t======SQUARE DIMENSIONS OF THE FIELD=======");
            do {
                System.out.print("\t\tPlease enter an integer between 2 and 20: ");
                fieldDimStr = scan.next(); 
                try {
                    fieldDim = Integer.parseInt(fieldDimStr);
                } catch (NumberFormatException e) {

                }
            } while (fieldDim < 2 || fieldDim > 20);

            System.out.println();

            System.out.println("\t\t       =====================================");
            do {
                System.out.print("\t\t       Pick a degree of diffculty (1-15): ");
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

            for (int i = 0; i < 50; i++) System.out.println();
            mf.genRevealArr();
            mf.printRevealArr();
            System.out.println();

            String addMineXStr = "";
            String addMineYStr = "";
            
            while (addMine) {
                System.out.print("\t\tWould you like to add a mine to the field? (Y/n): ");
                addMineYN = scan.next();
                if (addMineYN.equals("N") || addMineYN.equals("n")) {
                    addMine = false;
                } else if (addMineYN.equals("Y") || addMineYN.equals("y")) {
                    
                    do {
                        System.out.print("\t\tEnter row of mine to be added between 1 and " + (fieldDim) + " (integer): "); 
                        addMineXStr = scan.next();
                        try {
                            addMineX = Integer.parseInt(addMineXStr) - 1;
                        } catch (NumberFormatException e) {
        
                        }
                    } while (addMineX < 1 || addMineX > fieldDim-1);
                   
                    do {
                        System.out.print("\t\t\t\tEnter column of mine to be added between 1 and " + (fieldDim) + " (integer): "); 
                        addMineYStr = scan.next();
                        try {
                            addMineY = Integer.parseInt(addMineYStr) - 1;
                        } catch (NumberFormatException e) {
        
                        }
                    } while (addMineY < 1 || addMineY > fieldDim-1);
                    mf.addMine(addMineX, addMineY);
                }

                if(addMine == true && (addMineYN.equals("N") || addMineYN.equals("n") || addMineYN.equals("Y") || addMineYN.equals("y"))) {
                    System.out.print("\t\tWould you like to add another mine to the field? (Y/n): ");
                }
            }

            for (int i = 0; i < 50; i++) System.out.println();

            // System.out.println("\t\t==================================");
            // System.out.println("\t\tMinefield assembled, ready to play");
            // System.out.println("\t\t==================================");

            String revealXStr = "";
            String revealYStr = "";
            while (revealMine) {
                for (int i = 0; i < 50; i++) System.out.println();
                mf.printRevealArr();
                System.out.println();
                    
                if (mf.isNotComplete()) {
                    do {
                        revealX = -1;
                        System.out.print("\t\tEnter row of space to be revealed between 1 and " + (fieldDim) + " (integer): ");
                        revealXStr = scan.next();
                        try {
                            revealX = Integer.parseInt(revealXStr) - 1;
                        } catch (NumberFormatException e) {
        
                        }
                    } while (revealX < 0 || revealX > fieldDim-1);

                    do {
                        revealY = -1;
                        System.out.print("\t\tEnter column of space to be revealed between 1 and " + (fieldDim) + " (integer): ");
                        revealYStr = scan.next();
                        try {
                            revealY = Integer.parseInt(revealYStr) - 1;
                        } catch (NumberFormatException e) {
        
                        }
                    } while (revealY < 0 || revealY > fieldDim-1);

                    mf.reveal(revealX, revealY);
                }

                for (int i = 0; i < 50; i++) System.out.println();
                mf.printRevealArr();
                System.out.println();
                if (mf.isMine(revealX, revealY)) {
                    for (int i = 0; i < 50; i++) System.out.println();
                    System.out.println("\t\t\t\t============================");
                    System.out.println("\t\t\t\tYou picked a mine, you lose!");
                    System.out.println("\t\t\t\t============================");
                    revealMine = false;
                } else if (!mf.isNotComplete()) {
                    for (int i = 0; i < 50; i++) System.out.println();
                    System.out.println("\t\t\t===================================================");
                    System.out.println("\t\t\tAll open spaces revealed and mines marked, you win!");
                    System.out.println("\t\t\t===================================================");
                    revealMine = false;
                } else {  
                    System.out.println("\t\t\t     =======================================");
                    boolean markMine = false;

                    // do while to coerce user input for "would you like to mark a mine?"
                    String markYN = "";
                    do {
                                             
                        try {
                            System.out.print("\t\t\t     Would you like to mark a mine? (Y/n): ");   
                            markYN = scan.next();
                        } catch (NumberFormatException e) {
        
                        }
                    } while ((!markYN.equals("y") && !markYN.equals("Y") && !markYN.equals("n") && !markYN.equals("N")) || markYN.equals("") || markYN.equals(" "));

                    if (markYN.equals("Y") || markYN.equals("y")) {
                        markMine = true;
                    }
                    while (markMine && mf.isNotComplete()) {
                        for (int i = 0; i < 50; i++) System.out.println();
                        mf.printRevealArr();
                        System.out.println();
                        System.out.println("\t\t    Enter the coordinates of the mine to be marked.");
                        System.out.println("\t\t    If you wish to unmark a mine, enter those coordinates.");
                        System.out.println("\t\t    ======================================================");
                        System.out.println();
                        int markRow = -1;
                        int markCol = -1;
                        String markRowStr = "";
                        String markColStr = "";

                        do {
                            System.out.print("\t\t  Enter the row to be (un)marked (integer between 1 and " + (fieldDim) + "): ");
                            markRowStr = scan.next();
                            try {
                                markRow = Integer.parseInt(markRowStr) - 1;
                            } catch (NumberFormatException e) {
            
                            }
                        } while (markRow < 0 || markRow > fieldDim-1);

                        do {
                            System.out.print("\t\tEnter the column to be (un)marked (integer between 1 and " + (fieldDim) + "): ");
                            markColStr = scan.next();
                            try {
                                markCol = Integer.parseInt(markColStr) - 1;
                            } catch (NumberFormatException e) {
            
                            }
                        } while (markCol < 0 || markCol > fieldDim-1);

                        if (mf.isMine(markRow, markCol)) {
                            mf.markMine(markRow, markCol);
                        } else {
                            System.out.println();
                            System.out.println("\t\t===================================================");
                            System.out.println("\t\tPlease enter to coordinates of an unrevealed point.");
                            System.out.println("\t\t===================================================");
                        }
                        
                        if (!mf.isNotComplete()) {
                            for (int i = 0; i < 50; i++) System.out.println();
                            System.out.println("\t\t\t===================================================");
                            System.out.println("\t\t\tAll open spaces revealed and mines marked, you win!");
                            System.out.println("\t\t\t===================================================");
                            revealMine = false;
                            markMine = false;
                        } 

                        for (int i = 0; i < 50; i++) System.out.println();
                        mf.printRevealArr();
                        System.out.println();

                        if (markMine) {

                            String markAgainYN = "";
                            do {
                                System.out.println();
                                try {
                                    System.out.print("\t\t\tWould you like to mark another mine? (Y/n): ");                        
                                    markAgainYN = scan.next();
                                } catch (NumberFormatException e) {
                
                                }
                            } while ((!markAgainYN.equals("y") && !markAgainYN.equals("Y") && !markAgainYN.equals("n") && !markAgainYN.equals("N")) || markAgainYN.equals("") || markAgainYN.equals(" "));
        
                            if (markAgainYN.equals("N") || markAgainYN.equals("n")) {
                                markMine = false;
                            }

                        }
                    }

                    if (!mf.isNotComplete()) {
                        for (int i = 0; i < 50; i++) System.out.println();
                        System.out.println("\t\t\t===================================================");
                        System.out.println("\t\t\tAll open spaces revealed and mines marked, you win!");
                        System.out.println("\t\t\t===================================================");
                        revealMine = false;
                    } 
                }    
            }

            mf.printField();
            do {
                System.out.print("\t\t\t            Play again? (Y/n): ");
                endGame = scan.next();
                if (endGame.equals("N") || endGame.equals("n")) {
                    for (int i = 0; i < 50; i++) System.out.println();
                    playGame = false;
                }
            } while (!endGame.equals("N") && !endGame.equals("n") && !endGame.equals("Y") && !endGame.equals("y"));
        }
       
    }
}
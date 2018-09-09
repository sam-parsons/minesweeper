import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Letters remaining: Q, W
 * 
 * This program, which consists of a large main method, takes a message and a size
 * from the user and transforms it into a banner of according size.  The banner is printed
 * to an external text file.
 */

public class genText1 {

    public void generateText() {
        Scanner scan = new Scanner(System.in);
        int height = 3;
        String message = "";
        String[] messageArr;
        int realDim;
        int midPoint;
        String outputName = "bannerName.txt";;

        // Get size variable from user
        // System.out.print("Enter the size 'n' (height = (n*2) + 1): ");
        // height = scan.nextInt();
        // while (height <= 0 || height > 9) {
        //     System.out.print("Please enter an integer between 2 and 9: ");
        //     height = scan.nextInt();
        // }

        // Get message from user
        System.out.print("\t\t\t  Please enter your first name: ");
        message = scan.nextLine();

        messageArr = message.split("");

        // Dimension calculations
        realDim = (int)(height*2)+1;
        midPoint = (int)(Math.ceil(((height*2)+1)/2));

        // Every character in message to upper case
        for (int i = 0; i < message.length(); i++) {
            messageArr[i] = messageArr[i].toUpperCase();
        }

        try {
            PrintWriter outputStream = new PrintWriter(outputName);
            // outer loop keeps track of rows and print the ENTIRE row (every character) before
            // moving onto the next row
            for (int j = 0; j < realDim; j++) {  
                for (int i = 0; i < messageArr.length; i++) {
                    
                    // conditional routing for characters
                    if (messageArr[i].equals(" ")) {
                        for (int k = 0; k < 6; k++) {
                            outputStream.print(" ");
                        }
                    }
                    
                    if (messageArr[i].equals("A")) {

                        if (j == 0 || j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("A");
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("A");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                    }

                    if (messageArr[i].equals("B")) {

                        if (j == 0 || j == midPoint || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("B");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("B");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                        
                    }

                    if (messageArr[i].equals("C")) {
                        
                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("C");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == 1 || j == realDim-2) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("C");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0) {
                                    outputStream.print("C");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                        
                    }

                    if (messageArr[i].equals("D")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("D");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("D");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                        
                    }

                    if (messageArr[i].equals("E")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("E");
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == 1 || k == 2 || k ==3) {
                                    outputStream.print("E");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0) {
                                    outputStream.print("E");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                        
                    }

                    if (messageArr[i].equals("F")) {

                        if (j == 0) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("F");
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == 1 || k == 2 || k ==3) {
                                    outputStream.print("F");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0) {
                                    outputStream.print("F");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                        
                    }

                    if (messageArr[i].equals("G")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("G");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-3 || k == realDim-2 || k == realDim-1) {
                                    outputStream.print("G");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0) {
                                    outputStream.print("G");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("G");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                        
                    }

                    if (messageArr[i].equals("H")) {

                        if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("H");
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("H");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                    }

                    if (messageArr[i].equals("I")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("I");
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint) {
                                    outputStream.print("I");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                    }

                    if (messageArr[i].equals("J")) {

                        if (j == 0) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("J");
                            }
                            outputStream.print("   ");
                        } else if (j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k <= midPoint) {
                                    outputStream.print("J");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == realDim-2) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == midPoint) {
                                    outputStream.print("J");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint) {
                                    outputStream.print("J");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                        
                    }

                    if (messageArr[i].equals("K")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("K");
                                } else {
                                    outputStream.print(" ");
                                }
                                
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k <= midPoint) {
                                    outputStream.print("K");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == Math.abs(midPoint-j)+midPoint) {
                                    outputStream.print("K");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }  
                    }

                    if (messageArr[i].equals("L")) {

                        if (j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("L");
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0) {
                                    outputStream.print("L");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                    }

                    if (messageArr[i].equals("M")) {

                        if (j == 0 || j > midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("M");
                                } else {
                                    outputStream.print(" ");
                                }
                                
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint || k == 0 || k == realDim-1) {
                                    outputStream.print("M");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1 || k == (midPoint-j)+midPoint || k == midPoint-(midPoint-j)) {
                                    outputStream.print("M");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }  
                    }

                    if (messageArr[i].equals("N")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("N");
                                } else {
                                    outputStream.print(" ");
                                }
                                
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint || k == 0 || k == realDim-1) {
                                    outputStream.print("N");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1 || k == j) {
                                    outputStream.print("N");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }  
                    }

                    if (messageArr[i].equals("O")) {
                        
                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("O");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("O");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } 
                    }

                    if (messageArr[i].equals("P")) {
                        
                        if (j == 0 || j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("P");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j < midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("P");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0) {
                                    outputStream.print("P");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }  
                    }

                    if (messageArr[i].equals("R")) {
                        
                        if (j == 0 || j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("R");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j < midPoint || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("R");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == j) {
                                    outputStream.print("R");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }  
                    }

                    if (messageArr[i].equals("S")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == j) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("S");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("S");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (j < midPoint && k == 0) {
                                    outputStream.print("S");
                                } else if (j > midPoint && k == realDim-1) {
                                    outputStream.print("S");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } 
                    }

                    if (messageArr[i].equals("T")) {

                        if (j == 0) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("T");
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint) {
                                    outputStream.print("T");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                    }

                    if (messageArr[i].equals("U")) {
                        
                        if (j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print(" ");
                                } else {
                                    outputStream.print("U");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("U");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } 
                    }

                    if (messageArr[i].equals("V")) {
                        int counter = 0;
                        if (j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint) {
                                    outputStream.print("V");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == 0 || j == 1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("V");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            
                            if ((j%2) == 0) {
                                counter = j/2;
                            } else {
                                counter = (j-1)/2;
                            }

                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 + counter || k == realDim-1 - counter) {
                                    outputStream.print("V");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } 
                    }

                    if (messageArr[i].equals("X")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == 0 || k == realDim-1) {
                                    outputStream.print("X");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint) {
                                    outputStream.print("X");
                                } else {
                                    outputStream.print(" ");
                                }
                            } 
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint-(Math.abs(midPoint-j)) || k == midPoint+(Math.abs(midPoint-j))) {
                                    outputStream.print("X");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                    }

                    if (messageArr[i].equals("Y")) {
                        
                        if (j <  midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == j || k == realDim-j-1) {
                                    outputStream.print("Y");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else if (j == midPoint) {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint) {
                                    outputStream.print("Y");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == midPoint-(Math.abs(midPoint-j))) {
                                    outputStream.print("Y");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        } 
                    }

                    if (messageArr[i].equals("Z")) {

                        if (j == 0 || j == realDim-1) {
                            for (int k = 0; k < realDim; k++) {
                                outputStream.print("Z");
                            }
                            outputStream.print("   ");
                        } else {
                            for (int k = 0; k < realDim; k++) {
                                if (k == realDim-1-j) {
                                    outputStream.print("Z");
                                } else {
                                    outputStream.print(" ");
                                }
                            }
                            outputStream.print("   ");
                        }
                    }
                }
                outputStream.println();
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
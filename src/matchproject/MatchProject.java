/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matchproject;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Богдан
 */
public class MatchProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int matchSize = 11;
        System.out.println("Matches on start: " + matchSize);

        Random player = new Random();
        int player1 = player.nextInt(2);

        switch (player1) {
            case 0:
                humanPlayer(matchSize);
            case 1:
                compPlayer(matchSize);

        }

    }

    public static int humanPlayer(int matchSize) {

        if (matchSize <= 3) {
            System.out.println("Good job u win!");
            System.exit(0);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many matches you want to remove? ");
        int matchUp = scanner.nextInt();

        while (matchUp < 1 || matchUp > 3) {
            System.out.println("Plz try again. Choose from one to three matches");
            Scanner scannerHuman = new Scanner(System.in);
            matchUp = scannerHuman.nextInt();
        }

        matchSize = matchSize - matchUp;
        System.out.println("Now we have = " + matchSize + " matches.");

        System.out.println("-----------------------");
        compPlayer(matchSize);
        return matchSize;
    }

    public static int compPlayer(int matchSize) {

        if (matchSize <= 3) {
            System.out.println("Loser! Computer win!!!!!");
            System.exit(0);
        }

        if ((matchSize % 2) == 0) {
            matchSize = matchSize - 2;
            System.out.println("Computer removes 2 matches");
            System.out.println("Now we have " + matchSize + " matches.");

        } else if (matchSize == 5) {
            matchSize = matchSize - 1;
            System.out.println("Computer removes 1 matches");
            System.out.println("Now we have " + matchSize + " matches.");

        } else if ((matchSize % 1) == 0) {
            Random compMatch = new Random();
            int matches[] = {1, 3};
            int match = matches[compMatch.nextInt(matches.length)];
            matchSize = matchSize - match;
            System.out.println("Computer removes " + match + " match(es).");
            System.out.println("Now we have " + matchSize + " matches.");
        }

        System.out.println("-----------------------");
        humanPlayer(matchSize);
        return matchSize;
    }

}

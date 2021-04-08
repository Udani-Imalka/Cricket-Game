package com.cricket.controller.implementation;

import com.cricket.controller.GameController;
import com.cricket.model.Player;
import com.cricket.model.Team;

import java.util.Random;
import java.util.Scanner;

public class FiveOverGameController extends GameController {

    public static final String BOWLED = "BOWLED";
    private final static int NO_OF_OVERS = 5;
    private final static int NO_OF_BALLS = 3;
    public static final String OUT = "OUT";
    public static final String CAUGHT = "CAUGHT";

    @Override
    protected int bat(Team battingTeam, int targetScore, Scanner scanner) {
        System.out.println("Team " + battingTeam.getName() + " is batting.");

        int testNoOfBalls = NO_OF_OVERS * NO_OF_BALLS;
        Random random = new Random();

        Player player = battingTeam.getNextPlayer();
        for (int ball = 0; ball < testNoOfBalls; ball++) {
            getUserInputAndValidate(scanner);
            int result = player.bat(random);

            if (result == 5 || result == 7) {
                System.out.println("Player" + player.getName() + " is out.");
                player.setStatus(OUT);
                player.setGotOutBy(result == 5 ? BOWLED : CAUGHT);

                player = battingTeam.getNextPlayer();

                result=0; //Because the player got out,runs should be zero.

                if (player == null) {
                    System.out.println("All out for team " + battingTeam.getName());
                    break;
                }
            } else {
                System.out.println(
                        result == 0 ? "Got Ball " : (result + " runs were scored by players " + player.getName()));
                player.updateScore(result);
            }

            battingTeam.updateScore(result);
            String overs = "(" + ((ball+1 / 3) + "/" + ((ball+1 % 3) + ")" + "\n"));
            String teamSummary = battingTeam.getSummary();

            System.out.println("Score Summary " + teamSummary + " " + overs);

            if (ball % 3 == 0 && ball !=0) {
                System.out.println("End of over.");
            }
            if (targetScore > -1 && battingTeam.getTotalScore() > targetScore) {
                break;
            }
        }
        return battingTeam.getTotalScore();
    }

}

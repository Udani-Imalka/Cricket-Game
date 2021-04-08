package com.cricket.model;

import java.util.ArrayList;
import java.util.List;

public class Team {
    public static final String BATTING = "BATTING";
    public static final String MIN_SCORE = "MIN_SCORE";
    public static final int MIN_SCORE1 = 4;

    private String name;
    private List<Player> players;
    private int totalScore;
    private int totalWickets;
    private int currentBatman;
    public boolean hasWonToss;

    public Team(String name,int noOfPlayers) {
        this.name = name;
        this.totalScore = 0;
        this.totalWickets = -1;
        this.currentBatman = -1;
        this.hasWonToss = false;
        setPlayers(noOfPlayers);
    }

    private void setPlayers(int noOfPlayers){

        this.players= new ArrayList<>();

        for (int i=0; i<(noOfPlayers / 2) ; i++){
            Player player=new Player(String.valueOf(i));
            players.add(player);
        }

        for (int i=(noOfPlayers / 2); i < noOfPlayers ; i++){
            Player player=new SuperPlayer(String.valueOf(i), MIN_SCORE1);
            players.add(player);
        }
    }

    public int getTotalScore() { return this.totalScore; }

    public void setTotalScore(int totalScore) { this.totalScore = totalScore; }

    public int getTotalWickets() { return this.totalWickets; }

    public void setTotalWickets(int totalWickets) {
        this.totalWickets = totalWickets;
    }

    public boolean getHasWonToss() {
        return this.hasWonToss;
    }

    public void setHasWonToss(Boolean wonToss) {
        this.hasWonToss = wonToss;
    }

    public String getName(){
        return this.name;
    }

    public Player getNextPlayer() {
        this.currentBatman=0;
        if(this.currentBatman >= this.players.size()){
            return null;
        }
        this.totalWickets++;

        Player nextPlayer=this.players.get(this.currentBatman);
        nextPlayer.setStatus(BATTING);

        return nextPlayer;
    }

    public void updateScore(int result) {
        this.totalScore += result;
    }

    public String getSummary() {
        return "" + this.totalScore + "/" + this.totalWickets;
    }


}

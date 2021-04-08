package com.cricket.model;

import java.util.Random;

public class Player {
    private String name;
    private int score;
    private String gotOutBy;
    private String WicketType;
    private String Status;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.gotOutBy = "";
        WicketType = "";
        Status = "NOT_YET_BAT";
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    public String getGotOutBy() { return gotOutBy; }

    public void setGotOutBy(String gotOutBy) { this.gotOutBy = gotOutBy; }

    public String getWicketType() { return WicketType; }

    public void setWicketType(String wicketType) { WicketType = wicketType; }

    public String getStatus() { return Status; }

    public void setStatus(String status) { Status = status; }

    public void updateScore(int result) {
        this.score += result;
    }

    public int bat(Random random){
        return random.nextInt(8);
    }
}

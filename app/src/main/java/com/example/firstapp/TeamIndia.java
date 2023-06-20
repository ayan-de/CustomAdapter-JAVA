package com.example.firstapp;

public class TeamIndia {
    private String playerName;
    private String playerRole;

    public TeamIndia(String pName, String pRole) {
        playerName = pName;
        playerRole = pRole;
    }

    public String getName() {
        return playerName;
    }

    public String getRole() {
        return playerRole;
    }
}

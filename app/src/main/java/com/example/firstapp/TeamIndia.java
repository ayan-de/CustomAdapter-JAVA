package com.example.firstapp;

public class TeamIndia {
    private String playerName;
    private String playerRole;

    private int imageResource;

    public TeamIndia(String pName, String pRole) {
        playerName = pName;
        playerRole = pRole;
    }

    public TeamIndia(String pName, String pRole, int iResource) {
        playerName = pName;
        playerRole = pRole;
        imageResource = iResource;
    }

    public String getName() {
        return playerName;
    }

    public String getRole() {
        return playerRole;
    }

    public int getImage() {
        return imageResource;
    }
}

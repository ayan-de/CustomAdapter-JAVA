package com.example.firstapp;

public class TeamIndia {
    private String playerName;
    private String playerRole;

    private int imageResource = NO_IMAGE_PROVIDED;

    public static final int NO_IMAGE_PROVIDED = -1;

    private int audioResourceId;

    public TeamIndia(String pName, String pRole, int audioresourceid) {
        playerName = pName;
        playerRole = pRole;
        audioResourceId = audioresourceid;
    }

    public TeamIndia(String pName, String pRole, int iResource,int audioresourceid) {
        playerName = pName;
        playerRole = pRole;
        imageResource = iResource;
        audioResourceId = audioresourceid;
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

    public boolean hasImage(){
        return imageResource != NO_IMAGE_PROVIDED;
    }
    public int getAudioResourceId(){
        return audioResourceId;
    }
}

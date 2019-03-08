package com.example.geoguesswipe;

public class StreetImage {
    private String country;
    private int image;
    private boolean isInEurope;

    public StreetImage(String country, int image, boolean isInEurope) {
        this.country = country;
        this.image = image;
        this.isInEurope = isInEurope;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isInEurope() {
        return isInEurope;
    }

    public void setInEurope(boolean inEurope) {
        isInEurope = inEurope;
    }
}

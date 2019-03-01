package com.example.geoguesswipe;

public class StreetImage {
    private String country;
    private String image;
    private boolean isInEurope;

    public StreetImage(String country, String image, boolean isInEurope) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isInEurope() {
        return isInEurope;
    }

    public void setInEurope(boolean inEurope) {
        isInEurope = inEurope;
    }
}

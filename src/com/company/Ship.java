package com.company;

public class Ship {
    private String coordinates;
    private String nearbyCoordinates;

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates,String nearbyCoordinates) {
        this.coordinates = coordinates;
        this.nearbyCoordinates=nearbyCoordinates;
    }
    public boolean contains(String coord){
        if(coordinates.contains(coord)){
            cut(coord);
            return true;
        }
        return false;
    }
    public boolean shipExists(){
        if(coordinates.equals("")){
            GameConfig.MY_SHIPS--;
            return false;
        }
        return true;
    }
    public void cut(String coord){
        coordinates=coordinates.substring(0,coordinates.indexOf(coord))
                + coordinates.substring(coordinates.indexOf(coord)+2);
        }


    public String getNearbyCoordinates() {
        return nearbyCoordinates;
    }
}

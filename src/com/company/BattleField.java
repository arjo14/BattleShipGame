package com.company;

import java.util.Arrays;

public class BattleField{
    private Character [][]myBattlefield;
    private Character [][]hisBattlefield;
    private Ship[] ship=new Ship[5];
    private int shipIndex=0;


    public BattleField(GameConfig gc) {
        for(int i=0;i<ship.length;i++)
            ship[i]=new Ship();
        myBattlefield=new Character[gc.length][gc.width];
        hisBattlefield=new Character[gc.length][gc.width];
    }
    public void setBattleFields(){
        for(int i=0;i<myBattlefield.length;i++) {
            Arrays.fill(myBattlefield[i], '~');
            Arrays.fill(hisBattlefield[i], '*');
        }
    }
    public void getBattleFields(){
        char temp='a';
        System.out.println("        my battlefield                      his battlefield");
        System.out.println("   1  2  3  4  5  6  7  8  9  10       1  2  3  4  5  6  7  8  9  10");
        for(int i=0;i<myBattlefield.length;i++){
            System.out.print(temp+" ");
            for(int j=0;j<myBattlefield[i].length;j++){
                System.out.print( "|"+myBattlefield[i][j] + "|");
            }
            System.out.print("    "+temp++ +" ");
            for(int k=0;k<hisBattlefield[i].length;k++){
                System.out.print( "|"+hisBattlefield[i][k] + "|");
            }
            System.out.println();
        }
    }
    public void setHisBattlefield(String coord,char symbol){
        hisBattlefield[coord.charAt(0)][coord.charAt(1)]=symbol;
    }


    public boolean setShipToBottom(int[] places,int size) {
        String place="";
        String nearPlaces="";
        if(places[2]-places[0]!=size-1)
            return false;

        for(int i = 0;i < size;i++) {
            if (myBattlefield[places[0] + i][places[1]] != '~') {
                return false;
            }
        }
        for(int i = 0;i < size;i++) {
                myBattlefield[places[0] + i][places[1]] = '+';
                if (places[1] > 0) {
                    if(myBattlefield[places[0] + i][places[1] - 1] != '+')
                        myBattlefield[places[0] + i][places[1] - 1] = 'O';
                        nearPlaces+=(places[0]+i)+""+(places[1]-1);
                    if (places[0] > 0) {
                        if(myBattlefield[places[0] + i - 1][places[1] - 1] != '+')
                            myBattlefield[places[0] + i - 1][places[1] - 1] = 'O';
                            nearPlaces+=(places[0]+i-1)+""+(places[1]-1);
                    }
                }
                if (places[0] > 0) {
                    if(myBattlefield[places[0] + i-1][places[1] ] != '+')
                        myBattlefield[places[0] + i - 1][places[1]] = 'O';
                        nearPlaces+=(places[0]+i-1)+""+(places[1]);
                }


            if (places[1] < 9) {
                if(myBattlefield[places[0] + i][places[1] + 1] != '+')
                    myBattlefield[places[0] + i][places[1] + 1] = 'O';
                    nearPlaces+=(places[0]+i)+""+(places[1]+1);
                if (places[0] > 0) {
                    if(myBattlefield[places[0] + i-1][places[1] + 1] != '+')
                        myBattlefield[places[0] + i - 1][places[1] + 1] = 'O';
                        nearPlaces+=(places[0]+i-1)+""+(places[1]+1);
                }
            }
            if(i == (size - 1)){
                if(places[2] < 9){
                        nearPlaces+=(places[0]+i+1)+""+(places[1]);
                    if(myBattlefield[places[0] + i + 1][places[1] ] != '+')
                        myBattlefield[places[0] + i + 1 ][places[1]] = 'O';
                    if(places[1]>0) {
                        if(myBattlefield[places[0] + i+1][places[1] - 1] != '+')
                        myBattlefield[places[0] + i + 1][places[1] - 1] = 'O';
                        nearPlaces+=(places[0]+i+1)+""+(places[1]-1);
                    }
                }
                if(places[1]>0) {
                    if(myBattlefield[places[0] + i][places[1] - 1] != '+')
                        myBattlefield[places[0] + i][places[1] - 1] = 'O';
                        nearPlaces+=(places[0]+i)+""+(places[1]-1);
                }
                 if(places[1]<9){
                        nearPlaces+=(places[0]+i)+""+(places[1]+1);
                     if(myBattlefield[places[0] + i][places[1] + 1] != '+')
                         myBattlefield[places[0] + i ][places[1] + 1] = 'O';

                    if(places[2]<9){
                            nearPlaces+=(places[0]+i+1)+""+(places[1]+1);
                        if(myBattlefield[places[0] + i+1][places[1] + 1] != '+')
                            myBattlefield[places[0] + i + 1][places[1] + 1] = 'O';
                    }
                 }
            }
            place += (places[0] + i);
            place += places[1];
        }
        ship[shipIndex].setCoordinates(place,nearPlaces);
        shipIndex++;
        return true;
    }

    public boolean setShipToRight(int[] places,int size) {
        String place="";
        String nearPlaces="";
        if(places[3]-places[1]!=size-1)
            return false;

        for(int i = 0;i < size;i++) {
            if( myBattlefield[places[0]][places[1] + i]!='~') {
            return false;
            }
        }
            for(int i = 0;i < size;i++){
                myBattlefield[places[0]][places[1] + i] = '+';
                    if(places[0]>0) {
                        if(myBattlefield[places[0] - 1][places[1] + i] != '+')
                            myBattlefield[places[0] - 1][places[1] + i] = 'O';
                            nearPlaces+=(places[0]-1)+""+(places[1]+i);
                    }
                    if(places[1]>0){
                        if(myBattlefield[places[0]][places[1] + i -1] != '+')
                            myBattlefield[places[0]][places[1] + i - 1] = 'O';
                                nearPlaces+=places[0]+""+(places[1]+i-1);
                    }
                    if(places[1]>0 && places[0]>0){
                        if(myBattlefield[places[0] - 1][places[1] + i -1] != '+')
                            myBattlefield[places[0] - 1][places[1] + i - 1] = 'O';
                            nearPlaces+=(places[0]-1)+""+(places[1]+i-1);
                    }
                    if(places[0]<9){
                        if(myBattlefield[places[0] + 1][places[1] + i] != '+') {
                            myBattlefield[places[0] + 1][places[1] + i] = 'O';
                            nearPlaces += (places[0] + 1) + "" + (places[1] + i);
                        }

                        if(places[1]>0){
                            if(myBattlefield[places[0] + 1][places[1] + i-1] != '+') {
                                myBattlefield[places[0] + 1][places[1] + i - 1] = 'O';
                                nearPlaces += (places[0] + 1) + "" + (places[1] + i - 1);
                            }
                        }
                    }
                    if(i==(size-1)) {
                        if (places[1]+i < 9) {
                            if(myBattlefield[places[0]][places[1] + i +1] != '+') {
                                myBattlefield[places[0]][places[1] + i + 1] = 'O';
                                nearPlaces += (places[0]) + "" + (places[1] + i + 1);
                            }

                            if (places[0] < 9) {
                                if(myBattlefield[places[0] + 1][places[1] + i +1] != '+') {
                                    myBattlefield[places[0] + 1][places[1] + i + 1] = 'O';
                                    nearPlaces += (places[0] + 1) + "" + (places[1] + i + 1);
                                }

                            }
                            if(places[0]>0){
                                if(myBattlefield[places[0] - 1][places[1] + i + 1] != '+') {
                                    myBattlefield[places[0] - 1][places[1] + i + 1] = 'O';
                                    nearPlaces += (places[0] - 1) + "" + (places[1] + i + 1);
                                }
                            }
                        }
                    }
                place+=places[0];
                place+=(places[1]+i);
        }
        ship[shipIndex].setCoordinates(place,nearPlaces);
        shipIndex++;
        return true;
    }

    public  void refillMyBattlefield() {
        for(int i=0;i<myBattlefield.length;i++){
            for(int j=0;j<myBattlefield[i].length;j++){
                if(myBattlefield[i][j]=='O')
                    myBattlefield[i][j]='~';
            }
        }
    }

    public String checkCoordinate(String shot) {
        for (int i = 0; i < ship.length; i++) {
            if(ship[i].contains(shot)){
                if(ship[i].shipExists())
                    return "1";
                else {
                    fillNearCoordinates(ship[i].getNearbyCoordinates());
                    return "11";
                }
            }
        }
        return "";
    }

    private void fillNearCoordinates(String nearbyCoordinates) {
        for(int i=0;i<nearbyCoordinates.length();i=i+2){
            myBattlefield[nearbyCoordinates.charAt(i)][nearbyCoordinates.charAt(i+1)]='O';
        }

    }

    public void myShotResult(String shot,boolean flag){
        if(flag){
            hisBattlefield[shot.charAt(0)][shot.charAt(1)]='X';
        }
        else
            hisBattlefield[shot.charAt(0)][shot.charAt(1)]='O';
    }


}

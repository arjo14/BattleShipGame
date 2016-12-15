package com.company;

import java.util.Scanner;

public class Game {
    private BattleField battlefield;
    private int fiveLength;
    private int fourLength;
    private int threeLength;
    private int twoLength;
    private int oneLength;
    public GameConfig gc;
    Scanner in = new Scanner(System.in);

    public Game(GameConfig gc) {
        this.gc = gc;
        battlefield = new BattleField(gc);
        fiveLength = 1;
        fourLength = 1;
        threeLength = 1;
        twoLength = 1;
        oneLength = 1;
        battlefield.setBattleFields();
    }

    public void start() {
        setMyBattlefield();

    }

    public void myShot(String coord, boolean kpav) {
        if (kpav) {
            battlefield.setHisBattlefield(coord, 'X');
        } else
            battlefield.setHisBattlefield(coord, 'O');
    }

    public void getBattlefields() {
        battlefield.getBattleFields();
    }

    private void setMyBattlefield() {
        setFiveLengthShip();
        setFourLengthShip();
        setThreeLengthShip();
        setTwoLengthShip();
        setOneLengthShip();
        battlefield.refillMyBattlefield();
    }


    private void setOneLengthShip() {
        while (oneLength != 0) {
            getBattlefields();
            int[] places = new int[4];
            String firstPlace;
            while (true) {
                System.out.println("Enter the  first coordinates for oneLength ship(Example : a1) : ");
                firstPlace=in.next();
                System.out.println();
                if (firstPlace.charAt(0) >='a' && firstPlace.charAt(0) <= 'j' && Integer.parseInt(firstPlace.substring(1)) > 0 && Integer.parseInt(firstPlace.substring(1)) < 11) {
                    firstPlace=firstPlace.charAt(0)+""+ (Integer.parseInt(firstPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }

            convertStringToInt(places,firstPlace+firstPlace);

            boolean flag;
                flag = battlefield.setShipToBottom(places,1);

            if (flag) {
                oneLength--;
            }
            else
                System.out.println("////////////////////////////////////////\nEntered coordinates were wrong\n////////////////////////////////////////");

        }
    }

    private void setTwoLengthShip() {
        while (twoLength != 0) {
            getBattlefields();
            int[] places = new int[4];
            String firstPlace;
            String secondPlace;
            while (true) {
                System.out.println("Enter the  first coordinates for twoLength ship(Example : a1) : ");
                firstPlace=in.next();
                System.out.println();
                if (firstPlace.charAt(0) >='a' && firstPlace.charAt(0) <= 'j' && Integer.parseInt(firstPlace.substring(1)) > 0 && Integer.parseInt(firstPlace.substring(1)) < 11) {
                    firstPlace=firstPlace.charAt(0)+""+ (Integer.parseInt(firstPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while (true) {
                System.out.print("Enter the  second coordinates for twoLength ship (Example : a1) : ");
                secondPlace=in.next();
                System.out.println();
                if (secondPlace.charAt(0) >='a' && secondPlace.charAt(0) <= 'j' && Integer.parseInt(secondPlace.substring(1)) > 0 && Integer.parseInt(secondPlace.substring(1)) < 11) {
                    secondPlace=secondPlace.charAt(0)+""+ (Integer.parseInt(secondPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            convertStringToInt(places,firstPlace+secondPlace);
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            if (places[0] == places[2])
                flag = battlefield.setShipToRight(places, 2);
            else
                flag = battlefield.setShipToBottom(places, 2);
            if (flag) {
                twoLength--;
            }
            else
                System.out.println("////////////////////////////////////////\nEntered coordinates were wrong\n////////////////////////////////////////");

        }
    }

    private void setThreeLengthShip() {
        while (threeLength != 0) {
            getBattlefields();
            int[] places = new int[4];
            String firstPlace;
            String secondPlace;
            while (true) {
                System.out.println("Enter the  first coordinates for threeLength ship(Example : a1) : ");
                firstPlace=in.next();
                System.out.println();
                if (firstPlace.charAt(0) >='a' && firstPlace.charAt(0) <= 'j' && Integer.parseInt(firstPlace.substring(1)) > 0 && Integer.parseInt(firstPlace.substring(1)) < 11) {
                    firstPlace=firstPlace.charAt(0)+""+ (Integer.parseInt(firstPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while (true) {
                System.out.print("Enter the  second coordinates for threeLength ship (Example : a1) : ");
                secondPlace=in.next();
                System.out.println();
                if (secondPlace.charAt(0) >='a' && secondPlace.charAt(0) <= 'j' && Integer.parseInt(secondPlace.substring(1)) > 0 && Integer.parseInt(secondPlace.substring(1)) < 11) {
                    secondPlace=secondPlace.charAt(0)+""+ (Integer.parseInt(secondPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            convertStringToInt(places,firstPlace+secondPlace);
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            if (places[0] == places[2])
                flag = battlefield.setShipToRight(places, 3);
            else
                flag = battlefield.setShipToBottom(places, 3);
            if (flag) {
                threeLength--;
            } else
                System.out.println("////////////////////////////////////////\nEntered coordinates were wrong\n////////////////////////////////////////");
        }
    }

    private void setFourLengthShip() {
        while(fourLength!=0) {
            getBattlefields();
            int[] places = new int[4];
            String firstPlace;
            String secondPlace;
            while (true) {
                System.out.println("Enter the  first coordinates for fourLength ship(Example : a1) : ");
                firstPlace=in.next();
                System.out.println();
                if (firstPlace.charAt(0) >='a' && firstPlace.charAt(0) <= 'j' && Integer.parseInt(firstPlace.substring(1)) > 0 && Integer.parseInt(firstPlace.substring(1)) < 11) {
                    firstPlace=firstPlace.charAt(0)+""+ (Integer.parseInt(firstPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while (true) {
                System.out.print("Enter the  second coordinates for fourLength ship (Example : a1) : ");
                secondPlace=in.next();
                System.out.println();
                if (secondPlace.charAt(0) >='a' && secondPlace.charAt(0) <= 'j' && Integer.parseInt(secondPlace.substring(1)) > 0 && Integer.parseInt(secondPlace.substring(1)) < 11) {
                    secondPlace=secondPlace.charAt(0)+""+ (Integer.parseInt(secondPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            convertStringToInt(places,firstPlace+secondPlace);
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            if(places[0]==places[2])
                flag=battlefield.setShipToRight(places,4);
            else
                flag=battlefield.setShipToBottom(places,4);
            if(flag){
                fourLength--;
            }
            else
                System.out.println("////////////////////////////////////////\nEntered coordinates were wrong\n////////////////////////////////////////");


        }
    }

    private void setFiveLengthShip() {
        while(fiveLength!=0) {
            getBattlefields();
            int[] places = new int[4];
            String firstPlace;
            String secondPlace;
            while (true) {
                System.out.println("Enter the  first coordinates for fiveLength ship(Example : a1) : ");
                firstPlace=in.next();
                System.out.println();
                if (firstPlace.charAt(0) >='a' && firstPlace.charAt(0) <= 'j' && Integer.parseInt(firstPlace.substring(1)) > 0 && Integer.parseInt(firstPlace.substring(1)) < 11) {
                    firstPlace=firstPlace.charAt(0)+""+ (Integer.parseInt(firstPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while (true) {
                System.out.print("Enter the  second coordinates for fiveLength ship (Example : a1) : ");
                secondPlace=in.next();
                System.out.println();
                if (secondPlace.charAt(0) >='a' && secondPlace.charAt(0) <= 'j' && Integer.parseInt(secondPlace.substring(1)) > 0 && Integer.parseInt(secondPlace.substring(1)) < 11) {
                    secondPlace=secondPlace.charAt(0)+""+ (Integer.parseInt(secondPlace.substring(1))-1)+"";
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            convertStringToInt(places,firstPlace+secondPlace);
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            if(places[0]==places[2])
                flag=battlefield.setShipToRight(places,5);
            else
                flag=battlefield.setShipToBottom(places,5);
            if(flag){
                fiveLength--;
            }
            else
                System.out.println("////////////////////////////////////////\nEntered coordinates were wrong\n////////////////////////////////////////");
        }
    }

    private int[] swap1(int[] places) {
            int temp = places[0];
        places[0]=places[2];
        places[2]=temp;
        return places;
    }
    private int[] swap2(int[] places) {
        int temp=places[1];
        places[1]=places[3];
        places[3]=temp;
        return places;
    }


    public String opponentShot(String shot) {
        String temp=battlefield.checkCoordinate(convert(shot));
        return shot+temp;
    }
    public void myShotResult(String shot,boolean flag){
        battlefield.myShotResult(shot,flag);
    }

    private String convert(String shot){
        switch(shot.charAt(0)){
            case('a'):return (0+shot.charAt(1)+"");
            case('b'):return (1+shot.charAt(1)+"");
            case('c'):return (2+shot.charAt(1)+"");
            case('d'):return (3+shot.charAt(1)+"");
            case('e'):return (4+shot.charAt(1)+"");
            case('f'):return (5+shot.charAt(1)+"");
            case('g'):return (6+shot.charAt(1)+"");
            case('h'):return (7+shot.charAt(1)+"");
            case('i'):return (8+shot.charAt(1)+"");
            default:return (9+shot.charAt(1)+"");
        }
    }

    private void convertStringToInt(int[] places, String s) {
        switch(s.charAt(0)){
            case('a'):places[0]=0;
                break;
            case('b'):places[0]=1;
                break;
            case('c'):places[0]=2;
                break;
            case('d'):places[0]=3;
                break;
            case('e'):places[0]=4;
                break;
            case('f'):places[0]=5;
                break;
            case('g'):places[0]=6;
                break;
            case('h'):places[0]=7;
                break;
            case('i'):places[0]=8;
                break;
            default:places[0]=9;
                break;
        }
        places[1]=Integer.parseInt(s.substring(1,2));
        switch(s.charAt(2)){
            case('a'):places[2]=0;
                break;
            case('b'):places[2]=1;
                break;
            case('c'):places[2]=2;
                break;
            case('d'):places[2]=3;
                break;
            case('e'):places[2]=4;
                break;
            case('f'):places[2]=5;
                break;
            case('g'):places[2]=6;
                break;
            case('h'):places[2]=7;
                break;
            case('i'):places[2]=8;
                break;
            default:places[2]=9;
                break;
        }
        places[3]=Integer.parseInt(s.substring(3,4));
    }

}

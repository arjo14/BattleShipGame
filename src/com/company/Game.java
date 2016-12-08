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
    Scanner in= new Scanner(System.in);

    public Game(GameConfig gc){
        this.gc=gc;
        battlefield=new BattleField(gc);
        fiveLength=1;
        fourLength=2;
        threeLength=3;
        twoLength=4;
        oneLength=5;
        battlefield.setBattleFields();
    }

    public void start(){
        setMyBattlefield();

    }
    public void myShot(String coord,boolean kpav){
        if(kpav){
            battlefield.setHisBattlefield(coord,'X');
        }
        else
            battlefield.setHisBattlefield(coord,'O');
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
        while(oneLength==0) {
            getBattlefields();
            int[] places = new int[4];
            while(true){
                System.out.println("Enter the  first coordinates for oneLength ship : ");
                places[0]=in.nextInt();
                places[1]=in.nextInt();
                System.out.println();
                if(places[0] > 0 && places[0] < 11 && places[1] > 0 && places[1] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while(true){
                System.out.print("Enter the  second coordinates for oneLength ship : ");
                places[2]=in.nextInt();
                places[3]=in.nextInt();
                System.out.println();
                if(places[2] > 0 && places[2] < 11 && places[3] > 0 && places[3] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            for(int i=0;i<4;i++){
                places[i]--;
            }
            if(places[0]==places[2])
                flag=battlefield.setShipToRight(places,1);
            else
                flag=battlefield.setShipToBottom(places,1);
            if(flag){
                oneLength--;
                System.out.println("Entered coordinates were wrong");
            }
        }
    }

    private void setTwoLengthShip() {
        while(twoLength==0) {
            getBattlefields();
            int[] places = new int[4];
            while(true){
                System.out.print("Enter the  first coordinates for twoLength ship : ");
                places[0]=in.nextInt();
                places[1]=in.nextInt();
                System.out.println();
                if(places[0] > 0 && places[0] < 11 && places[1] > 0 && places[1] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while(true){
                System.out.print("Enter the  second coordinates for twoLength ship : ");
                places[2]=in.nextInt();
                places[3]=in.nextInt();
                System.out.println();
                if(places[2] > 0 && places[2] < 11 && places[3] > 0 && places[3] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            for(int i=0;i<4;i++){
                places[i]--;
            }
            if(places[0]==places[2])
                flag=battlefield.setShipToRight(places,2);
            else
                flag=battlefield.setShipToBottom(places,2);
            if(flag){
                twoLength--;
                System.out.println("Entered coordinates were wrong");
            }
        }
    }

    private void setThreeLengthShip() {
        while(threeLength==0) {
            getBattlefields();
            int[] places = new int[4];
            while(true){
                System.out.print("Enter the  first coordinates for threeLength ship : ");
                places[0]=in.nextInt();
                places[1]=in.nextInt();
                System.out.println();
                if(places[0] > 0 && places[0] < 11 && places[1] > 0 && places[1] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while(true){
                System.out.print("Enter the  second coordinates for threeLength ship : ");
                places[2]=in.nextInt();
                places[3]=in.nextInt();
                System.out.println();
                if(places[2] > 0 && places[2] < 11 && places[3] > 0 && places[3] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            for(int i=0;i<4;i++){
                places[i]--;
            }
            if(places[0]==places[2])
                flag=battlefield.setShipToRight(places,3);
            else
                flag=battlefield.setShipToBottom(places,3);
            if(flag){
                threeLength--;
                System.out.println("Entered coordinates were wrong");
            }
        }
    }

    private void setFourLengthShip() {
        while(fourLength==0) {
            getBattlefields();
            int[] places = new int[4];
            while(true){
                System.out.print("Enter the  first coordinates for fourLength ship : ");
                places[0]=in.nextInt();
                places[1]=in.nextInt();
                System.out.println();
                if(places[0] > 0 && places[0] < 11 && places[1] > 0 && places[1] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while(true){
                System.out.print("Enter the  last coordinates for fourLength ship : ");
                places[2]=in.nextInt();
                places[3]=in.nextInt();
                System.out.println();
                if(places[2] > 0 && places[2] < 11 && places[3] > 0 && places[3] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            for(int i=0;i<4;i++){
                places[i]--;
            }
            if(places[0]==places[2])
                flag=battlefield.setShipToRight(places,4);
            else
                flag=battlefield.setShipToBottom(places,4);
            if(flag){
                fourLength--;
                System.out.println("Entered coordinates were wrong");
            }
        }
    }

    private void setFiveLengthShip() {
        while(fiveLength==0) {
            getBattlefields();
            int[] places = new int[4];
            while(true){
                System.out.print("Enter the  first coordinates for fiveLength ship : ");
                places[0]=in.nextInt();
                places[1]=in.nextInt();
                System.out.println();
                if(places[0] > 0 && places[0] < 11 && places[1] > 0 && places[1] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            while(true){
                System.out.print("Enter the  second coordinates for fiveLength ship : ");
                places[2]=in.nextInt();
                places[3]=in.nextInt();
                System.out.println();
                if(places[2] > 0 && places[2] < 11 && places[3] > 0 && places[3] < 11 ){
                    break;
                }
                System.out.println("Your entered numbers were wrong.");
            }
            if (places[0] > places[2]) {
                places = swap1(places);
            }
            if (places[1] > places[3]) {
                places = swap2(places);
            }
            boolean flag;
            for(int i=0;i<4;i++){
                places[i]--;
            }
            if(places[0]==places[2])
                flag=battlefield.setShipToRight(places,5);
            else
                flag=battlefield.setShipToBottom(places,5);
            if(flag){
                fiveLength--;
                System.out.println("Entered coordinates were wrong");
            }
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
}

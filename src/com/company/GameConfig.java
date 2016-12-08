package com.company;


public class GameConfig {
    public static int MY_SHIPS =15;
    public static int OPPONENTS_SHIPS =15;
    public static boolean MY_TURN=true;
    protected int length;
    protected int width;
    protected Mode mode;
    public boolean flag;

    public GameConfig(int mode){
        this.mode=new Mode(mode);
        length=10;
        width=10;
        flag=true;
    }
    public GameConfig(){
        this.mode=new Mode(0);
        length=10;
        width=10;
        flag=true;
    }
}

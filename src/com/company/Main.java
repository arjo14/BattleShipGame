package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Main {
        private static Socket socket;
    private static ServerSocket serverSocket;
    public static void main(String[] args) throws IOException {

        Scanner in= new Scanner(System.in);
        boolean flag;
     /*   int num;
        do {
            System.out.print("Enter game mode : (0 - Easy , 1 - Normal , 2 - Hard)");
            num = in.nextInt();
        }while(num >= 0 && num <= 2);
        System.out.println("\n inchel yntreyr nuyn banner linelu :)"); */
        Game game=new Game(new GameConfig());
        game.start();
        String myShot="";
        String hisShot="";
        String hisShotResult="";
        while(GameConfig.OPPONENTS_SHIPS != 0 && GameConfig.MY_SHIPS != 0){

            if(GameConfig.MY_TURN) {
                game.getBattlefields();
                String first;
                int second;
                serverSocket=new ServerSocket(8081);
                do{
                    System.out.println("Enter coordinates that you want to shot (example: a 1 )(a-j,1-10): ");
                    first=in.next();
                    second=in.nextInt();
                    System.out.println();
                }
                while(Character.toLowerCase(first.charAt(0))>='a' && Character.toLowerCase(first.charAt(0))<='j' && second>0 && second<=10);
                socket=serverSocket.accept();
                PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
                second--;
                socket=new Socket("10.100.25.211",8081);
                BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));

                out.write(first+second+hisShotResult);
                while(!socket.isConnected()){}
                socket.close();
                serverSocket.close();
                GameConfig.MY_TURN=false;
            }
            else{
                game.getBattlefields();
                while(true){
                    try{
                        socket=new Socket("10.100.25.211",8081);
                        break;
                    }
                    catch(Exception e){

                    }
                }
//                while(!socket.isConnected()){}
                BufferedReader input=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while((hisShot=input.readLine())==null){}
                hisShotResult=game.opponentShot(hisShot.substring(0,2));
                myShot=hisShot.substring(2);
                switch (myShot.length()) {
                    case (2):
                        game.myShotResult(myShot.substring(0, 2), false);
                        break;
                    case (3):
                        game.myShotResult(myShot.substring(0, 2), true);
                        break;
                    case (4):
                        game.myShotResult(myShot.substring(0, 2), true);
                        GameConfig.OPPONENTS_SHIPS--;
                        break;
                }
                GameConfig.MY_TURN=true;
            }
        }
    }


}


package com.github.GSPersonalRefrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GSPersonalRefrigerator {

    public static void main(String[] args) {
        Menu m = new Menu();
        System.out.println("----시작----");
        boolean check = true;

        while(check){
            try{
                m.printMenu();
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                check = m.menuChoose(input);

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}

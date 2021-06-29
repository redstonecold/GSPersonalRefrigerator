package com.github.GSPersonalRefrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GSPersonalRefrigerator {

    public static void main(String[] args) {
        MenuService m = new MenuService();
        System.out.println("----시작----");
        boolean check = true;

        CRUDService crud = new CRUDService();
        crud.setProductList(FileService.readFile());

        while(check){
            try{
                m.printMenu();
                System.out.print("메뉴를 선택하세요 : ");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String input = br.readLine();
                check = m.menuChoose(input);

            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}

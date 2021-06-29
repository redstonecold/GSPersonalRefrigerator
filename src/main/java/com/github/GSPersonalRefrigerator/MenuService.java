package com.github.GSPersonalRefrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuService {
    BufferedReader br;
    CRUDService crud = new CRUDService();

    public void printMenu(){
        System.out.println("--menu--");
        System.out.println("1. 조회");
        System.out.println("2. 추가");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 제품명 검색");
        System.out.println("6. 파일 저장");
        System.out.println("0. 종료");
        System.out.println("--------");
    }


    public boolean menuChoose(String input){
        switch (input){
            case "1" :
                crud.readData();
                break;
            case "2" :
                crud.createData();
                break;
            case "3" :
                crud.updateData();
                break;
            case "4" :
                crud.deleteData();
                break;
            case "5" :
                searchByProductName();
                break;
            case "6" :
                FileService.saveFile(crud.getProductList());
                break;
            case "0" :
                System.out.println("시스템이 종료됩니다.");
                return false;
            default:
                System.out.println("잘못된 메뉴를 선택하셨습니다.");
        }
        return true;
    }

    public void searchByProductName(){
        try {
            if (crud.getProductList().size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }
            System.out.println("검색할 제품명 입력 : ");
            String productName = br.readLine();
            boolean check = false;
            for (Product p : crud.getProductList()){
                if(p.getProductName().equals(productName)) {
                    if (!check) {
                        System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 기한 | 연장 횟수 |");
                        System.out.println("===========================================");
                        check = true;
                    }
                    System.out.println(p.tolist());
                }
            }
            if(!check)
                System.out.println("검색 결과가 없습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

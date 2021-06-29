package com.github.GSPersonalRefrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchService {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    CRUDService crud = new CRUDService();

    public void searchByProductName() {
        try {
            if (crud.getProductList().size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }
            System.out.print("검색할 제품명 입력 : ");
            String productName = br.readLine();
            boolean check = false;
            for (Product p : crud.getProductList()) {
                if (p.getProductName().contains(productName)) {
                    if (!check) {
                        System.out.println();
                        System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 기간 | 연장 횟수 |");
                        System.out.println("===========================================");
                        check = true;
                    }
                    System.out.println(p.tolist());
                }
            }
            if (!check) {
                System.out.println("검색 결과가 없습니다.");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}

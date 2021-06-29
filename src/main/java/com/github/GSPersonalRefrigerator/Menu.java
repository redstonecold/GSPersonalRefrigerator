package com.github.GSPersonalRefrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Menu implements CRUD{
    BufferedReader br;
    private final ArrayList<Product> productList;

    public Menu(){
        this.productList = new ArrayList<>();
    }

    public void printMenu(){
        System.out.println("--menu--");
        System.out.println("1. 조회");
        System.out.println("2. 추가");
        System.out.println("3. 수정");
        System.out.println("4. 삭제");
        System.out.println("5. 제품명 검색");
        System.out.println("0. 종료");
        System.out.println("--------");
    }

    public boolean menuChoose(String input){
        switch (input){
            case "1" :
                readData();
                break;
            case "2" :
                createData();
                break;
            case "3" :
                updateData();
                break;
            case "4" :
                deleteData();
                break;
            case "5" :
                searchByProductName();
                break;
            case "0" :
                System.out.println("시스템이 종료됩니다.");
                return false;
            default:
                System.out.println("잘못된 메뉴를 선택하셨습니다.");
        }
        return true;
    }

    @Override
    public void createData() {
        Product p = new Product();
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("제품명 입력 : ");
            p.setProductName(br.readLine());
            System.out.println("가격 입력 : ");
            p.setProductPrice(Integer.parseInt(br.readLine()));
            System.out.println("이용 가능 기한 입력 : ");
            p.setEnableDate(br.readLine());
            System.out.println("연장 횟수 입력 : ");
            p.setProductPrice(Integer.parseInt(br.readLine()));
        } catch (IOException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
        }
        p.setNum(this.productList.size()+1);
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDate = date.format(formatter);
        p.setPurchaseDate(regDate);

        this.productList.add(p);
        System.out.println("추가 되었습니다 :)");
    }

    @Override
    public void readData() {
        if(productList.size() == 0){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        System.out.println("No 제품명 | 가격 | 구매날짜 | 이용 가능 횟수 | 연장 횟수 |");
        System.out.println("==============================================");
        for (Product p : this.productList) {
            System.out.println(p.tolist());
        }
    }

    @Override
    public void updateData() {
        try {
            if (productList.size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }

            for (Product p : this.productList) {
                System.out.println(p.tolist());
            }

            System.out.println("수정할 번호 입력 : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            if (valid(num)) {
                System.out.println("제품명 입력 : ");
                this.productList.get(num).setProductName(br.readLine());
                System.out.println("가격 입력 : ");
                this.productList.get(num).setProductPrice(Integer.parseInt(br.readLine()));
                System.out.println("이용 가능 기한 입력 : ");
                this.productList.get(num).setEnableDate(br.readLine());
                System.out.println("연장 횟수 입력 : ");
                this.productList.get(num).setProductPrice(Integer.parseInt(br.readLine()));
                System.out.println("수정되었습니다.");
            } else {
                updateData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
        }

    }

    @Override
    public void deleteData() {
        try {
            if (productList.size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }

            for (Product p : this.productList) {
                System.out.println(p.tolist());
            }

            System.out.println("삭제할 번호 입력 : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine());
            if (valid(num)) {
               this.productList.remove(num-1);
               for (int i=0; i<productList.size(); i++){
                   this.productList.get(i).setNum(i+1);
               }
               System.out.println("삭제되었습니다.");
            } else {
                deleteData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
        }

    }

    public void searchByProductName(){
        try {
            if (productList.size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }
            System.out.println("검색할 제품명 입력 : ");
            br = new BufferedReader(new InputStreamReader(System.in));
            String productName = br.readLine();
            boolean check = false;
            for (Product p : productList){
                if(p.getProductName().equals(productName)) {
                    if (!check) {
                        System.out.println("No 제품명 | 가격 | 구매날짜 | 이용 가능 횟수 | 연장 횟수 |");
                        System.out.println("==============================================");
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

    public boolean valid (int num){
        if(this.productList.size() > num || num <= 0){
            System.out.println("없는 번호 입니다.");
            return false;
        }
        return true;
    }
}

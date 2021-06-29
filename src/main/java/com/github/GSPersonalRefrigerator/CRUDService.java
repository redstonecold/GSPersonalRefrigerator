package com.github.GSPersonalRefrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class CRUDService {

    private final ArrayList<Product> productList = new ArrayList<>();
    private final ArrayList<Product> productNameList = new ArrayList<>();
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void createData() {
        Product p = new Product();
        try {
            System.out.println("제품명 입력 : ");
            p.setProductName(br.readLine());
            System.out.println("가격 입력 : ");
            p.setProductPrice(Integer.parseInt(br.readLine()));
            System.out.println("이용 가능 기한 입력 : ");
            p.setEnableDate(br.readLine());
            System.out.println("연장 횟수 입력 : ");
            p.setExtendNum(Integer.parseInt(br.readLine()));
        } catch (IOException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
        }
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDate = date.format(formatter);
        p.setPurchaseDate(regDate);

        String uuid = UUID.randomUUID().toString();
        p.setProductRegNum(uuid);

        this.productList.add(p);
        System.out.println("추가 되었습니다 :)");
    }

    public void readData() {
        if(productList.size() == 0){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 횟수 | 연장 횟수 | 등록번호 ");
        System.out.println("===========================================");
        for (Product p : this.productList) {
            System.out.println(p.tolist());
        }
    }

    public void updateData() {
        try {
            if (productList.size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }

            System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 횟수 | 연장 횟수 | 등록번호 ");
            System.out.println("===========================================");
            for (Product p : this.productList) {
                System.out.println(p.tolist());
            }

            System.out.println("수정할 제품명 입력 : ");
            int index = valid();


            if (index != -1) {
                System.out.println("제품명 입력 : ");
                this.productList.get(index).setProductName(br.readLine());
                System.out.println("가격 입력 : ");
                this.productList.get(index).setProductPrice(Integer.parseInt(br.readLine()));
                System.out.println("이용 가능 기한 입력 : ");
                this.productList.get(index).setEnableDate(br.readLine());
                System.out.println("연장 횟수 입력 : ");
                this.productList.get(index).setProductPrice(Integer.parseInt(br.readLine()));
                System.out.println("수정되었습니다.");
            } else {
                updateData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){
        }

    }


    public void deleteData() {
        try {
            if (productList.size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }

            System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 횟수 | 연장 횟수 | 등록번호 ");
            System.out.println("===========================================");
            for (Product p : this.productList) {
                System.out.println(p.tolist());
            }

            System.out.println("삭제할 제품명 입력 : ");
            int index = valid();

            if (index != -1) {
                this.productList.remove(index);
                System.out.println("삭제되었습니다.");
            } else {
                deleteData();
            }
        } catch (NumberFormatException e){
        }
    }

    public int valid (){
        String productRegNum = null;
        int index = -1;
        try {
            String productName = br.readLine();
            for (Product p : this.productList) {
                if(p.getProductName().equals(productName))
                    productNameList.add(p);
            }

            if (productNameList.size() > 1) {
                System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 횟수 | 연장 횟수 | 등록번호 ");
                System.out.println("===========================================");
                for (Product p : this.productNameList) {
                    System.out.println(p.tolist());
                }
                System.out.println("제품의 등록번호 입력 : ");
                productRegNum = br.readLine();
            }
            else if (productNameList.size() == 1){
                for (Product p : this.productNameList) {
                    productRegNum = p.getProductRegNum();
                }
            }
            else {
                System.out.println("제품을 찾을 수 없습니다!");
            }

            if(!productRegNum.equals(null)) {
                for (Product p : productList) {
                    if (p.getProductRegNum().equals(productRegNum)) {
                        index = productList.indexOf(p);
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
        return index;
    }


    public ArrayList<Product> getProductList() {
        return productList;
    }
}

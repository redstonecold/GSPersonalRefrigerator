package com.github.GSPersonalRefrigerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.UUID;

public class CRUDService {

    private static ArrayList<Product> productList = new ArrayList<>();
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void createData() {
        Product p = new Product();
        long enableDate = -1;

        try {
            System.out.println();
            System.out.print("제품명 입력 : ");
            p.setProductName(br.readLine());
            System.out.print("가격 입력 : ");
            p.setProductPrice(Integer.parseInt(br.readLine()));

            System.out.print("이용 가능 기한 입력 : ");
            p.setEnableDate(br.readLine());
//            String strEnableDate = br.readLine();
//            if(strEnableDate.length()>0)
//                enableDate = Integer.parseInt(strEnableDate);

        } catch (IOException e){
            e.printStackTrace();
        } catch (NumberFormatException e){
            e.printStackTrace();
        }
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String regDate = date.format(formatter);
        p.setPurchaseDate(regDate);

//        if(enableDate != -1){
//            LocalDate oneYearAfter = LocalDate.now().plusYears(1);
//            String oneYearRegDate = oneYearAfter.format(formatter);
//            p.setPurchaseDate(oneYearRegDate);
//        }
//        else{
//            LocalDate enableDateAfter = LocalDate.now().plusDays(enableDate);
//            String enableDateRegDate = enableDateAfter.format(formatter);
//            p.setPurchaseDate(enableDateRegDate);
//        }

        p.setExtendNum(0);

        String uuid = UUID.randomUUID().toString();
        p.setProductRegNum(uuid);

        productList.add(p);
        System.out.println("추가 되었습니다 :)");
        System.out.println();
    }

    public static void readData() {
        if(productList.size() == 0){
            System.out.println("데이터가 존재하지 않습니다.");
            return;
        }
        System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 기한 | 연장 횟수 | 등록번호 ");
        System.out.println("===========================================");
        for (Product p : productList) {
            System.out.println(p.tolist());
        }
        System.out.println();
    }

    public static void updateData() {
        try {
            if (productList.size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }

            System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 기한 | 연장 횟수 | 등록번호 ");
            System.out.println("===========================================");
            for (Product p : productList) {
                System.out.println(p.tolist());
            }

            System.out.println();
            System.out.print("수정할 제품명 입력 : ");
            int index = valid();


            if (index != -1) {
                System.out.println();
                System.out.print("제품명 입력 : ");
                productList.get(index).setProductName(br.readLine());
                System.out.print("가격 입력 : ");
                productList.get(index).setProductPrice(Integer.parseInt(br.readLine()));
                System.out.print("이용 가능 기한 입력 : ");
                productList.get(index).setEnableDate(br.readLine());
                System.out.print("연장 횟수 입력 : ");
                productList.get(index).setExtendNum(Integer.parseInt(br.readLine()));
                System.out.println("수정되었습니다.");
                System.out.println();
            } else {
                updateData();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e){

        } catch (NullPointerException e) {

        }

    }


    public static void deleteData() {
        try {
            if (productList.size() == 0) {
                System.out.println("데이터가 존재하지 않습니다.");
                return;
            }

            System.out.println("제품명 | 가격 | 구매날짜 | 이용 가능 기한 | 연장 횟수 | 등록번호 ");
            System.out.println("===========================================");
            for (Product p : productList) {
                System.out.println(p.tolist());
            }

            System.out.println();
            System.out.print("삭제할 제품명 입력 : ");
            int index = valid();

            if (index != -1) {
                productList.remove(index);
                System.out.println("삭제되었습니다.");
                System.out.println();
            } else {
                deleteData();
            }
        } catch (NumberFormatException e){

        } catch (NullPointerException e){

        }
    }

    public static int valid (){
        String productRegNum = null;
        ArrayList<Product> productNameList = new ArrayList<>();

        int index = -1;
        try {
            String productName = br.readLine();
            for (Product p : productList) {
                if(p.getProductName().equals(productName))
                    productNameList.add(p);
            }

            if (productNameList.size() > 1) {
                System.out.print("제품의 등록번호 입력 : ");
                productRegNum = br.readLine();
            }
            else if (productNameList.size() == 1){
                for (Product p : productNameList) {
                    productRegNum = p.getProductRegNum();
                }
            }
            else {
                System.out.println("제품을 찾을 수 없습니다!");
                System.out.println();
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

    public static void setProductList(ArrayList<Product> inputproductList) {
        productList = inputproductList;
    }
}

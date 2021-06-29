package com.github.GSPersonalRefrigerator;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class FileService {
    private static String path = Paths.get(".").toAbsolutePath().toString();

    public static void saveFile(ArrayList<Product> productList){
        try {
            String filename = path + "/MyPersonalRefrigerator.txt";

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (Product product : productList) {
                bw.write(product.toListInFile());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Product> readFile(){

        ArrayList<Product> list = new ArrayList<>();

        try{
            String fileName = path + "/MyPersonalRefrigerator.txt";

            File file = new File(fileName);

            if(file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line = "";
                while ((line = br.readLine()) != null) {
                    StringTokenizer st = new StringTokenizer(line, "$");

                    String productName = st.nextToken().trim();
                    int productPrice = Integer.parseInt(st.nextToken().trim());
                    String purchaseDate = st.nextToken().trim();
                    String enableDate = st.nextToken().trim();
                    int extendNum = Integer.parseInt(st.nextToken().trim());
                    String productRegNum = st.nextToken().trim();

                    list.add(new Product(productName, productPrice, purchaseDate, enableDate, extendNum, productRegNum));
                }
                System.out.println("파일 로딩 완료!");
                System.out.println();
                br.close();
            }
            else {
                System.out.println("파일 없음");
                System.out.println();
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }
        return list;
    }

}

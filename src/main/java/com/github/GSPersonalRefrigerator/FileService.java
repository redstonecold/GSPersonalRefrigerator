package com.github.GSPersonalRefrigerator;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileService {
    private static String path = Paths.get(".").toAbsolutePath().toString();

    public static void saveFile(ArrayList<Product> productList){
        try {
            String filename = path + "/MyPersonalRefrigerator.txt";

            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (Product product : productList) {
                bw.write(product.tolist());
                bw.newLine();
            }
            bw.flush();
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readFile(String fileName){
        try{
            String filePath = path + fileName;
            File file = new File(filePath);

            BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println("----파일 내용 출력 ----");
            String line = null;
            while((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("-------------------");
            br.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

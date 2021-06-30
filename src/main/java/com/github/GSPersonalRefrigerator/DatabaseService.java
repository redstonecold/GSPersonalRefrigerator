package com.github.GSPersonalRefrigerator;

import java.sql.*;

public class DatabaseService {

    final String CREATETBL = "create table if not exists product (" +
            "id integer primary key autoincrement, " +
            "productName text not null, " +
            "productPrice integer default 0," +
            "purchaseDate datetime DEFAULT (datetime('now','localtime')), " +
            "enableDate text not null, " +
            "extendNum integer default 0," +
            "productRegNum text primary key" +
            ")";

    void sqliteFunc(){
        Connection conn = null; //db와 연결할 때 필요한 class
        Statement stmt = null; //sql문을 실행할 때 필요한 class
        PreparedStatement pstmt = null;

        // sqlite jdbc 클래스 확인 (java와 database
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            //test.db 데이터베이스 연결(없으면 생성)
            conn = DriverManager.getConnection("jdbc:sqlite:test.db"); //괄호안에 저 포멧이 정해져 있음, 데이터 베이스가 없으면 test.db이름으로 만들어라

            //테이블 생성 : SQL문 실행
            stmt = conn.createStatement(); //요렇게 statment를 항상 만들어라
            stmt.execute(CREATETBL); // 이 쿼리를 실행해

            //데이터 추가 : Statment 사용
            String sql = "insert into product (productName, productPrice, purchaseDate, enableDate, extendNum, productRegNum) values ('홍길동', 100, 80, 90)";
            stmt.execute(sql);
            //문자열 만든후 이 문자열을 실행해! (문자열이 command line)

            //데이터 추가 : PreparedStatement 사용 (PreparedStatement 클래스)
            String sql2 = "insert into product (productName, productPrice, purchaseDate, enableDate, extendNum, productRegNum) values(?,?,?,?,?,?)";//물음표 자리에 값만 바꾸는 기능
            pstmt = conn.prepareStatement(sql2);
            pstmt.setString(1, "김한동"); // 숫자 : 몇 번째 물음표
            pstmt.setInt(2, 0);
            pstmt.setString(3, "");
            pstmt.setString(4, "");
            pstmt.setInt(5, 0);
            pstmt.setString(6, "");
            pstmt.executeUpdate();

            //데이터 조회 : SQL문 실행
            ResultSet rs = stmt.executeQuery("select * from product"); //ResultSet 객체의 변수에 데이타를 자동으로 배열로 저장
            while(rs.next()) {
                String productName = rs.getString("productName");
                int productPrice = rs.getInt("productPrice");
                String purchaseDate = rs.getString("purchaseDate");
                String enableDate = rs.getString("enableDate");
                int extendNum = rs.getInt("extendNum");
                String productRegNum = rs.getString("productRegNum");
                System.out.println(productName + " " + productPrice + " " + purchaseDate + " " + enableDate + " " + extendNum + " " + productRegNum);
            }
            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

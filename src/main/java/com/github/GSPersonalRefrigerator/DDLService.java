package com.github.GSPersonalRefrigerator;
import java.sql.*;

public class DDLService {
    final static String CREATETBL = "create table if not exists product (" +
            "id integer primary key autoincrement, " +
            "productName text not null, " +
            "productPrice integer default 0," +
            "purchaseDate datetime DEFAULT (datetime('now','localtime')), " +
            "enableDate text not null, " +
            "extendNum integer default 0," +
            "productRegNum text primary key" +
            ")";

    Connection conn = null; //db와 연결할 때 필요한 class

    public DDLService() {

    }

    public boolean executeSQL(final String SQL) throws SQLException {

        Statement stmt = null;
        //   - 결과 변수
        boolean result = false;

        try {
            // Statement 객체  생성
            stmt = conn.createStatement();

            // SQL 실행
            stmt.execute(SQL);

            // 트랜잭션 COMMIT
            conn.commit();

            // 성공
            result = true;

        } catch (SQLException e) {
            // 오류출력
            System.out.println(e.getMessage());
            // 트랜잭션 ROLLBACK
            if( conn != null ) {
                conn.rollback();
            }
            // 오류
            result = false;

        } finally {
            // Statement 종료
            if( stmt != null ) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 결과 반환
        return result;
    }

    // 테이블 생성 함수
    public boolean createTable() throws SQLException {
        // SQL 실행 및 반환
        return executeSQL(CREATETBL);
    }

}

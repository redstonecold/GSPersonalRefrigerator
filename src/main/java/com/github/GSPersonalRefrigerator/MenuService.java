package com.github.GSPersonalRefrigerator;


public class MenuService {
    CRUDService crud = new CRUDService();
    SearchService search = new SearchService();

    public void printMenu() {
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


    public boolean menuChoose(String input) {
        switch (input) {
            case "1":
                crud.readData();
                break;
            case "2":
                crud.createData();
                break;
            case "3":
                crud.updateData();
                break;
            case "4":
                crud.deleteData();
                break;
            case "5":
                search.searchByProductName();
                break;
            case "6":
                FileService.saveFile(crud.getProductList());
                break;
            case "0":
                System.out.println("시스템이 종료됩니다.");
                return false;
            default:
                System.out.println("잘못된 메뉴를 선택하셨습니다.");
        }
        return true;
    }
}

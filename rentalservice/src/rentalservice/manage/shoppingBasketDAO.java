package rentalservice.manage;

import java.sql.ResultSet;
import java.util.Arrays;
import java.sql.Statement;
import java.util.ArrayList;


import rentalservice.user.DBConn;

public class shoppingBasketDAO extends DBConn {

   public shoppingBasketDAO() {
   }

   public static String[] getData2() {
//      ArrayList<String []> lst = new ArrayList<String[]>();
      String [] lst2 = new String[8];

      try {
         getConn();
         sql = "select * from tbl_orderuser";

         Statement pstmt = conn.createStatement();
         ResultSet rs = pstmt.executeQuery(sql);

         while (rs.next()) {
            String name = rs.getString(1);
            String ename = rs.getString(2);
            String zipcode = rs.getString(3);
            String address = rs.getString(4);
            String birth = rs.getString(5);
            String tel = rs.getString(6);
            String email = rs.getString(7);
            String gender = rs.getString(8);

            //각 항목 변수 대입


            lst2[0] = name;
            lst2[1] = ename;
            lst2[2] = zipcode;
            lst2[3] = address;
            lst2[4] = birth;
            lst2[5] = tel;
            lst2[6] = email;
            lst2[7] = gender;

            // 1차원 배열 만들기




         }
         return lst2;


      } catch (Exception e) {

         e.printStackTrace();
         return null;
      } finally {
         dbClose();
      }

   }
   public static String[] getData1() {
//     ArrayList<String []> lst = new ArrayList<String[]>();
     String [] lst1 = new String[5];

     try {
        getConn();
        sql = "select * from tbl_product";
        System.out.println("d데이터선택되나 ?");

        Statement pstmt = conn.createStatement();
        ResultSet rs = pstmt.executeQuery(sql);

        while (rs.next()) {
           String id = rs.getString(1);
           String name = rs.getString(2);
           String size = rs.getString(3);
           String price = rs.getString(4);
           String quantity = rs.getString(5);



           //각 항목 변수 대입


           lst1[0] = id;
           lst1[1] = name;
           lst1[2] = size;
           lst1[3] = price;
           lst1[4] = quantity;


           // 1차원 배열 만들기




        }
        return lst1;


     } catch (Exception e) {

        e.printStackTrace();
        return null;
     } finally {
        dbClose();
     }

  }
   public static String[] getData3() {
	   int sum;
	   String [] lst3 = new String[1];

	     try {
	        getConn();
	        sql = "select product_price, product_quantity from tbl_product";
	        System.out.println("d데이터선택되나 ?");

	        Statement pstmt = conn.createStatement();
	        ResultSet rs = pstmt.executeQuery(sql);

	        while (rs.next()) {

	            String price = rs.getString(1);


	            lst3[0] = price;


	            }


	        return lst3;
   }catch (Exception e) {

       e.printStackTrace();
       return null;
    } finally {
       dbClose();
    }

   }

}
package JdbcPractice;

import java.sql.*;

public class Query1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

      Class.forName("org.postgresql.Driver");//1-Driver Olustur

      Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","Prarhsjn469822");
        //Bağlantı sağla
      System.out.println("Bağlantı sağlandı...");

        Statement st = con.createStatement(); //Sorgu yapmak için Statement oluştur


        ResultSet veri = st.executeQuery("select * from film"); // Yaptığımız sorgu sonucunda gelen veriyi ResultSet içine at

        while(veri.next()){
            System.out.println(
            veri.getInt(1)
            );
        }

        con.close();
        st.close();

    }

}

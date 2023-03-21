import pojos.Doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query08 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Prarhsjn469822");

        Statement st = con.createStatement();

        //Doctor tablosu olusturalım
        String sql01 = "create table doctors(id int, isim varchar(30), bolum varchar(20), ucret int)";
        st.execute(sql01);

        //POJO class kullanarak tabloya veri ekleyelim

        List<Doctor> kayitlar = new ArrayList<>();
        kayitlar.add(new Doctor(20, "Ali Can", "Cildiye", 500));
        kayitlar.add(new Doctor(21, "Sibel Bilen", "Psikiyatri", 800));
        kayitlar.add(new Doctor(22, "Serhat Guler", "Ruh Sagligi", 700));
        kayitlar.add(new Doctor(23, "Hediye Keskin", "Noroloji", 100));
        kayitlar.add(new Doctor(24, "Veli Han", "Kbb", 400));
        kayitlar.add(new Doctor(25, "Ali Han", "Dermotoloji", 500));
        kayitlar.add(new Doctor(26, "Hakan Bal", "Ortodonti", 500));
        kayitlar.add(new Doctor(27, "Ali Can", "Cildiye", 500));
        kayitlar.add(new Doctor(28, "Ali Can", "Cildiye", 500));

        PreparedStatement data = con.prepareStatement("insert into doctors values (?, ?, ?, ?)");

        for (Doctor each : kayitlar) {
            data.setInt(1,each.getId());
            data.setString(2,each.getIsim());
            data.setString(3,each.getBolum());
            data.setDouble(4,each.getUcret());
            data.addBatch();  //Bütün dataları çektikten sonra bir konteynıra toplar
        }

            data.executeBatch();
            con.close();
            data.close();

    }
}

import pojos.Urun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Query07 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Prarhsjn469822");

        Statement st = con.createStatement();

        //SORU: Urunler adında bir tablo olusturalım (id int, isim varchar(10), fiyat int)
        st.execute("Create Table Urunler(id int, isim varchar(10),fiyat int)");



        List<Urun> kayitlar = new ArrayList<>();

        kayitlar.add(new Urun(100,"Laptop",35000));
        kayitlar.add(new Urun(101,"Mouse",750));
        kayitlar.add(new Urun(102,"MacBookPro",95000));
        kayitlar.add(new Urun(103,"Anakart",5000));
        kayitlar.add(new Urun(104,"Klavye",1500));
        kayitlar.add(new Urun(105,"IPad",45000));


        //Çok miktarda kayıt eklemek için PreparedStatement methodu kullanılır.
        //Bunun haricinde POJO Class kullanarak da bunu yapabiliriz.


        PreparedStatement tablo = con.prepareStatement("insert into urunler values (?, ?, ?)");//Burada şablonu oluşturuyoruz

        for(Urun each:kayitlar){       //Bu kısmı while ile de yapabiliriz.
            tablo.setInt(1, each.getId());      //Loop ile List'e eklenen obje halindeki verileri List'den çekiyor
            tablo.setString(2, each.getIsim()); // ve tablo.addBatch(); bu çekilen verileri, database'e göndermek için
            tablo.setDouble(3, each.getFiyat());// topluyor.
            tablo.addBatch(); // bu method tek tek çekilen bu verileri topluyor
        }
        tablo.executeBatch(); //Daha sonra tek tek toplanan bu verileri bu komut ile toplu şekilde database'e gönderiyoruz.

        con.close();
        st.close();
        tablo.close();


    }
}

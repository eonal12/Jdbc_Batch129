import java.sql.*;

public class Query01 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        //1.Adım Driver tanımla

        Class.forName("org.postgresql.Driver");

        //2.Adım Database'e Bağlanıyoruz
        //Bu adımda gerekli bilgileri girerek driverımızı projemize eklemiş oluyoruz.

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Prarhsjn469822");

        //3.Adım Statement objesi olusturuyoruz
        //Statement = ifade demektir.Biz statement objesi oluşturarak sorgularımızı bu statement üzerinden yapıyoruz.
        //Statement'i yukarıda olusturduğumuz con isminde oluşturduğumuz bağlantı üzerinden oluşturuyoruz.
        Statement st = con.createStatement();

        //4.Adım ResultSet dataları çekip veri isimli konteynıra yüklüyoruz.
        /*
        Burada biz executeQuery kullandık. Farklı kullanımlar olabilir.Yaptığımız sorgunun mahiyetine göre değişir:

        executeQuery();  :Tablo üzerinde herhangi bir update işlemi yapmayacaksak, sadece data çekeceksek kullanıyoruz.(Select gibi).
        Bu method bize ResultSet data tipinde bir veri dönüyor.Yani bu methodla yaptığımız sorgu sonucunca gelecek datayı biz
        ResultSet data tipinde bir değişkene atamamız gerekiyor.Bunun mantığı da şudur: Biz sorgu yaptığımız zaman ne kadar veri döneceğini
        bilmiyoruz. Dolayısı ile biz bu veriyi ResultSet data tipine atamamız gerekiyor. Zaten ResultSet = SonuçKümesi demektir.
        Ayrıca dönen veriye işlem yapabilmemiz için bir döngü kullanmamız gerekiyor.(Genellikle while ile next(); methodu kullanılır).
        Eğer dönen veri çoklu veri olarak dönüyor ise o verilerin içerisinden birine işlem yapmak isteyebiliriz.
        Bu durumda ise getInt(); getString(); gibi methodları kullanarak istediğimiz verileri çekebiliriz.(Getter method gibi düşünebiliriz).

        executeUpdate(); :Tablo üzerinde update işlemi yapacağımız durumlarda kullanıyoruz.(insert,delete,update gibi).
        Bu method ise bize int olarak 0 ya da 1 dönüyor. Sorgumuz başarılı bir şekilde çalıştı ise 1 aksi taktirde 0 dönüyor.
        Bunun sebebi: biz tablo üzerinde manipulasyon işlemi yaptık ve method bize başarılı ya da başarısız olarak dönüyor.
        Yapabileceğimiz başka bir işlem olmadığından burada ResultSet ya da bir döngü vs kullanmıyoruz.


        execute();       :


         */
        ResultSet veri = st.executeQuery("select * from ogrenciler");

        //5.Adım Dataları yazdır
        while (veri.next()){
            System.out.println(
             veri.getInt(1)
            +veri.getString(2)
            +veri.getString(3)
            +veri.getString(4));
        }

        //6.Adım bağlantıları kapatma
        con.close();
        st.close();
        veri.close();
    }
}

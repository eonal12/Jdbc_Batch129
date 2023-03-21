package JdbcPractice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query3 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.Adım Driver tanımla

        Class.forName("org.postgresql.Driver");

        //2.Adım Database'e Bağlanıyoruz

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/dvdrental",
                "postgres",
                "Prarhsjn469822");

        //3.Adım Statement objesi olusturuyoruz

        Statement st = con.createStatement();

        // Mentor isminde bir tablo olusturalım ve ogrenciler, mentorler, calısma_saatleri isminde 3 sütun ekleyelim

        st.execute("create table mentor (ogrenciler varchar(30),mentorler varchar(30),calısma_saatleri int)");
        System.out.println("Tablo olusturuldu");

        con.close();
        st.close();











    }
}

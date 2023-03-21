import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query05 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Prarhsjn469822");

        Statement st = con.createStatement();

        //Soru: Öğrenciler tablosuna yeni bir kayıt ekleyin (300,'Sena Can', 12, K)

        //String sql01 ="insert into ogrenciler values(300,'Sena Can', 12, 'K')";
        //st.executeUpdate(sql01);

        //SORU: Öğrenciler tablosuna birden fazla veri ekleyin
        // (400, ‘Sena Can’, 12, ‘K’), (401, ‘Sena Can’, 12, ‘K’), (402, ‘Sena Can’, 12, ‘K’)

        String [] veri = {"insert into ogrenciler values (603, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (604, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (605, 'Sena Can', 12, 'K')"};
        int count =0;
        for (String each : veri) {
            count +=st.executeUpdate(each);
        }
        System.out.println(count + " satir database'e eklendi");


        //2.yol

        String [] veri1 = {"insert into ogrenciler values (600, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (601, 'Sena Can', 12, 'K')",
                "insert into ogrenciler values (602, 'Sena Can', 12, 'K')"};

        for(String each: veri){
            st.addBatch(each);          //yukarıdaki dataların Hepsini birleştirir
        }
        st.executeBatch();              //Dataları tek seferde gönderir.

        st.close();
        con.close();

    }
}

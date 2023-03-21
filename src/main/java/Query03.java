import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Query03 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        //1.Adım Driver tanımla

        Class.forName("org.postgresql.Driver");

        //2.Adım Database'e Bağlanıyoruz

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Prarhsjn469822");

        //3.Adım Statement objesi olusturuyoruz

        Statement st = con.createStatement();

        //"workers" adında bir table oluşturup "worker_id, worker_name, worker_salary" sütunlarını ekleyin.

        //String sql01 = "Create Table workers (worker_id int, worker_name varchar(20),worker_salary int)";
        //st.execute(sql01);

        //Tabloya workers_address sütunu ekleyelim

//        String sql02 = "Alter table workers add workers_address varchar(50)";
//        st.execute(sql02);

        //Workers tablosunu silelim
        String sql03 = "Drop Table workers";
        st.execute(sql03);

        //execute()  -> create, drop, alter table (DDL) icin kullanılır.

        con.close();
        st.close();





    }
}

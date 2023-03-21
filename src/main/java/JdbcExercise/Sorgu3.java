package JdbcExercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Sorgu3 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JdbcExercise",
                "postgres",
                "Prarhsjn469822");
        Statement st = con.createStatement();

        //workers adında bir tablo olusturalım ve worker_id, worker_name, worker_salary sütunları ekleyelim

        String sql1 = "Create Table workers " +
                "(worker_id int," +
                "worker_name varchar(20)," +
                "worker_salary int)";

        //st.execute(sql1);

        //şimdi de bu tabloya workers_address sütunu ekleyelim

        //st.execute("alter table workers add column workers_address varchar(50)");

        //simdi de bu tabloyu silelim
        st.execute("drop table workers");

        con.close();
        st.close();

    }
}

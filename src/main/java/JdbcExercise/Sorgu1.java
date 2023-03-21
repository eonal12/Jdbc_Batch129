package JdbcExercise;

import java.sql.*;

public class Sorgu1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/JdbcExercise",
                "postgres",
                "Prarhsjn469822");
        Statement st = con.createStatement();
        ResultSet veri = st.executeQuery("select * from ev");

        while (veri.next()){
            System.out.printf(
                    veri.getInt(1)+
                    veri.getString(2)+
                    veri.getString(3)+
                    veri.getInt(4)+
                    veri.getString(5));
        }

        con.close();
        veri.close();
        st.close();






    }
}

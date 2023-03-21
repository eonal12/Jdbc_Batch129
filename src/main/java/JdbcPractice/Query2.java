package JdbcPractice;

import java.sql.*;

public class Query2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/dvdrental","postgres","Prarhsjn469822");
        Statement st = con.createStatement();
        ResultSet veri = st.executeQuery("select title,rental_duration from film where rental_duration=6");

        while (veri.next()){
            System.out.println(
                    veri.getString("title")
            );
        }

        con.close();
        st.close();



    }
}

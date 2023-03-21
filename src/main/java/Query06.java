import java.sql.*;

public class Query06 {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Prarhsjn469822");

        //Statement st = con.createStatement();
        //st.executeUpdate("insert into ogrenciler values (850, 'Ali Can', 11, 'E')");

        //Aynı SQL sorgusunu kullanacaksak statement değil preparedStatement kullanırız.
        //Statement kullandığımızda her seferinde kodu database'e iletir.
        //preparedStatement kullanınca yazdığımız kodu saklar biriktirir ve
        //ps.executeUpdate(); dediğimizde kullandığımız örneği saklar sadece dataları iletir.

        PreparedStatement ps = con.prepareStatement("insert into ogrenciler values (?, ?, ?, ?)");
        ps.setInt(1, 951);
        ps.setString(2, "Ali Can");
        ps.setInt(3, 11);
        ps.setString(4, "E");

        ps.executeUpdate();

        ps.close();





    }
}

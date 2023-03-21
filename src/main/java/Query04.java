import java.sql.*;

public class Query04 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/jdbc",
                "postgres",
                "Prarhsjn469822");

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("select * from ogrenciler");

        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("1. sütunun ismi : " + rsmd.getColumnName(1));
        System.out.println("2. sütunun ismi : " + rsmd.getColumnName(2));
        System.out.println("3. sütunun ismi : " + rsmd.getColumnName(3));
        System.out.println("4. sütunun ismi : " + rsmd.getColumnName(4));

        System.out.println("Tablo ismi : " + rsmd.getTableName(3));//Burada istedigimiz sütun nosunu yazabiliriz farketmiyor

        System.out.println(rsmd.getColumnTypeName(1));

        con.close();
        st.close();
        rs.close();


    }
}

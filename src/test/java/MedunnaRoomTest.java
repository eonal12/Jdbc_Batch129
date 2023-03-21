import org.junit.Assert;
import org.junit.Test;
import utilities.JdbcUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MedunnaRoomTest {

    @Test
    public void roomTest() throws SQLException {
        //"John_doe" isimli kullanıcı tarafından oda olusturulmus mu test edelim.

        JdbcUtils.connectToDataBase("medunna.com",
                "medunna_db",
                "medunna_user",
                "medunna_pass_987");


        Statement statement = JdbcUtils.createStatement();
        String sql01 = "select created_by from room";

        ResultSet resultSet = statement.executeQuery(sql01);

        List<String> created_byList = new ArrayList<>();

        while (resultSet.next()){//Bu kodla for each gibi bütün dataları tek tek gezip List'in icine atıyoruz
            created_byList.add(resultSet.getString(1));
        }
        System.out.println("Oda olusturanlar :" + created_byList);

        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",created_byList.contains("john_doe"));

        JdbcUtils.closeConnectionAndStatement();
    }

    @Test
    public void doktorTest(){
        //Rosetta Luettgen
    }
}

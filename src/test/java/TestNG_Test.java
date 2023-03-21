import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DatabaseUtility;

public class TestNG_Test {

    @Test
    public void test01(){
        DatabaseUtility.createConnection();
        //Dersa Soylu database'ye kayıtlı mı test edelim TestNG ile
        String sql = "select * from ogrenciler";
        Assert.assertTrue(DatabaseUtility.getColumnData(sql,"ogrenci_ismi").contains("Derya Soylu"),
                "DATABASE'DE KAYIT BULUNAMADI");
        DatabaseUtility.closeConnection();
    }

    @Test
    public void test02(){
        //111 numaralı kayıt olup olmadığını test edelim.
        DatabaseUtility.createConnection();
        Assert.assertTrue(DatabaseUtility.getColumnData("select * from ogrenciler",
                "okul_no").contains(111),"DATABASE'DE KAYIT BULUNAMADI");
        DatabaseUtility.closeConnection();

    }
}

import org.junit.Assert;
import org.junit.Test;
import static utilities.DatabaseUtility.*;

public class JUnit_Test {

    @Test
    public void test01(){
        //Nil Naz ve Ali Can isimli öğrencilerin Database'de kayıtlı olup olmadığını test edelim.
        createConnection();
        String sql = "select * from ogrenciler";//Sorgumuzu yazdık    //getColumnData methoduna sorgumuzu ve istediğimiz sütun ismini verince
        System.out.println(getColumnData(sql, "ogrenci_ismi"));//database'e gidip o sorguyu yapıp istediğimiz sütundaki verileri getiriyor.
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                                    getColumnData(sql, "ogrenci_ismi").contains("Nil Naz"));
        //Assert testerlıkta kullanacağımız en önemli doğrulama yöntemidir. Burada assertTrue methodu'nun birçok overload edilmiş hali olabilir.
        //Bizim kullandığımız 2 parametreli message ve column parametresi alıyor. message kısmı: test başarısız olduğu durumda consola
        //yazdıracağı mesaj oluyor.

        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData(sql, "ogrenci_ismi").contains("Ali Can"));

        closeConnection();

    }

    @Test
    public void test02(){
        //120 numaralı kayıt var mı? test edelim
        createConnection();
        Assert.assertTrue("DATABASE'DE KAYIT BULUNAMADI",
                getColumnData("select * from ogrenciler","okul_no").contains(120));
        closeConnection();
    }

}

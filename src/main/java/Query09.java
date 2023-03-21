import utilities.DatabaseUtilty;

import static utilities.DatabaseUtilty.*;

public class Query09 {

    public static void main(String[] args) {

        createConnection();

        String sql01="select * from ogrenciler";
        System.out.println(getColumnNames(sql01));
        System.out.println("okul no:"+getColumnData(sql01, "okul_no"));
        System.out.println("ogrenci ismi:"+getColumnData(sql01, "ogrenci_ismi"));
        System.out.println("sinif:"+getColumnData(sql01, "sinif"));
        System.out.println("cinsiyet : " + getColumnData(sql01,"cinsiyet"));

        closeConnection();

    }
}

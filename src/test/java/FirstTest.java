import org.junit.Assert;
import org.junit.Test;

public class FirstTest {

    @Test
    public void firstTest1(){
        Assert.assertTrue(6<8);
    }

    @Test
    public void firstTest2(){
        Assert.assertTrue("Test Fail",3<4);
        //Buradaki mesajı test başarısız olduğu durumda alırız.
    }

    @Test
    public void firstTest3(){
        Assert.assertEquals("Sayılar eşit değil","3","6");
    }

}

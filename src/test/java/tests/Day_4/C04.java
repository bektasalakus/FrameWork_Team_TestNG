package tests.Day_4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.pages.QdPage;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;
import tests.utilities.ReusableMethods;

public class C04 {


    /*
        Verilen 5 farkli username ve password'u kullanarak
        qualitydemy uygulamasina girilemedigini test edin
     */

    @DataProvider
    public static Object[][] kullanicilar() {

        String[][] kullaniciList={{"Zafer","12345"},
                {"Mehmet","34567"},
                {"Sevilay","67890"},
                {"Enver","56789"},
                {"Ahmet Emre","54321"}};
        return kullaniciList;
    }


    @Test(dataProvider = "kullanicilar")
    public void negatifLogin1(String username, String password){
        QdPage qdPage= new QdPage();
        ReusableMethods.sleep(2);
        qdPage= new QdPage();
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        qdPage.ilkLoginLinki.click();
        qdPage.emailKutusu.sendKeys(username);
        qdPage.passwordKutusu.sendKeys(password);
        ReusableMethods.sleep(2);
        qdPage.loginButonu.click();

        Assert.assertTrue(qdPage.emailKutusu.isEnabled());
        Driver.closeDriver();

    }
}
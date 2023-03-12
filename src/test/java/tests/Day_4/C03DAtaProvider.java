package tests.Day_4;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;
import tests.utilities.ReusableMethods;


public class C03DAtaProvider {


    /*
        Verilen 4 farkli websitesine gidin
        o sayfaya gidildigini test edin
        sayfayi kapatin

        amazonUrl
        wiseUrl
        qdUrl
        youtubeUrl
     */

    @DataProvider
    public static Object[][] urlListesi() {

        String[][] siteListesi={{"amazonUrl"},{"wiseUrl"},{"qdUrl"},{"youtubeUrl"}};

        return siteListesi;
    }


    @Test(dataProvider = "urlListesi")
    public void urlTest(String gidilecekSite){

        Driver.getDriver().get(ConfigReader.getProperty(gidilecekSite));
        ReusableMethods.sleep(2);
        String actualurl= Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actualurl,ConfigReader.getProperty(gidilecekSite)+"/");

        Driver.closeDriver();
    }
}
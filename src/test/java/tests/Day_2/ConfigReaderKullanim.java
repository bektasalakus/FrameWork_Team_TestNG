package tests.Day_2;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pages.AmazonPage;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;

public class ConfigReaderKullanim {

    @Test
    public void test01(){

        
        // amazon anasayfaya gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        // Test datasi olarak verilen kelime icin arama yapalim
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);

        // arama sonuclarinin arattigimiz test datasini icerdigini test edelim

        String expectedIcerik = ConfigReader.getProperty("amazonAranacakKelime");
        String actualAramaSonucYazisi= amazonPage.aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik));

        Driver.closeDriver();
        //hocam firefox dami calistirmak istiyorsunuz
        // hayır hocam chromde çalıştırdım her zaman firefox yüklü değil

    }
}

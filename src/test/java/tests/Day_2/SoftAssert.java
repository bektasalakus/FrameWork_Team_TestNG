package tests.Day_2;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import tests.pages.AmazonPage;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;

public class SoftAssert {

    @Test(groups = "smoke")
    public void amazonTesti(){
        /*
            Genel olarak
            test edin denirse hard assert
            dogrulayin(verify) denirse soft assert kasdedilir
         */

        // amazon anasayfaya gidip, dogru sayfaya gittigimizi DOGRULAYIN (verify)
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        String expectedIcerik= "amazon";
        String actualUrl= Driver.getDriver().getCurrentUrl();

        org.testng.asserts.SoftAssert softAssert= new org.testng.asserts.SoftAssert();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik),"url amazon icermiyor");

        // Nutella icin arama yapip, sonuclarin Nutella icerdigini dogrulayin
        AmazonPage amazonPage= new AmazonPage();
        amazonPage.aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        expectedIcerik ="Nutella";
        String actualAramaSonucYazisi= amazonPage.aramaSonucElementi.getText();
        softAssert.assertTrue(actualAramaSonucYazisi.contains(expectedIcerik),"arama sonucu Nutella icermiyor");


        // ilk urune tiklayip, urun isminde Nutella gectigini dogrulayin
        amazonPage.ilkUrun.click();
        expectedIcerik ="Nutella";
        String actualIlkUrunIsim= amazonPage.ilkUrunIsimElementi.getText();

        softAssert.assertTrue(actualIlkUrunIsim.contains(expectedIcerik),"ilk urun ismi Nutella icermiyor");

        softAssert.assertAll();
        Driver.closeDriver();
    }
}

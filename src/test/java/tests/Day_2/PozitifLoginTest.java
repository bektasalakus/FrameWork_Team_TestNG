package tests.Day_2;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pages.QdPage;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;

public class PozitifLoginTest {

    @Test(groups = "smoke")
    public void pozitifLoginTesti(){
        // qd anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        // login linkine tiklayin
        QdPage qdPage= new QdPage();
        qdPage.ilkLoginLinki.click();

        // gecerli kullanici adi ve password ile giris yapin
        qdPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qdPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));
        qdPage.loginButonu.click();

        // basarili bir sekilde giris yapildigini test edin
        Assert.assertTrue(qdPage.basariliGirisElementi.isDisplayed());

        Driver.closeDriver();
    }
}

package tests.Day_1;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.pages.FacebookPage;
import tests.utilities.Driver;
import tests.utilities.ReusableMethods;

public class FacebookLogin {


    @Test(groups = "smoke")
    public void facebookTesti(){
        FacebookPage facebookPage= new FacebookPage();
        //1 - https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");

        // cookies kabul edin
        facebookPage.cookiesKabulButonu.click();
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker = new Faker();

        facebookPage.emailKutusu.sendKeys(("abc"+faker.internet().emailAddress()));
        facebookPage.passwordKutusu.sendKeys(faker.internet().password());
        ReusableMethods.sleep(2);
        facebookPage.loginButonu.click();

        //4- Basarili giris yapilamadigini test edin

        Assert.assertTrue(facebookPage.girisYapilamadiYaziElementi.isDisplayed());

        ReusableMethods.sleep(3);

        Driver.closeDriver();
    }
}

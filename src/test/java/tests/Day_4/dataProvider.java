package tests.Day_4;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.pages.QdPage;
import tests.utilities.ConfigReader;
import tests.utilities.Driver;


public class dataProvider {
    QdPage qualityPage = new QdPage();


    @DataProvider
    public static Object[][] gonderilecekMail() {
        Object[][] gonderilecekMailvePassword = {
                {"nevzat", "1234"},
                {"nevzat@hotmail.com", "123456"},
                {"ahmet@hotmail.com", "nevzat151515151515"},
                {"celik@hotmail.com", "nevzat151515151515"},
                {"anevzatcelik@gmail.com", "Nevzat152032"}};

        return gonderilecekMailvePassword;
    }

    @Test(dataProvider = "gonderilecekMail")
    public void qualityTest(String mail, String password) {
        Driver.getDriver().get(ConfigReader.getProperty("url"));


    }
}
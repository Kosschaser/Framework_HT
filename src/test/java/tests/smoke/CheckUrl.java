package tests.smoke;

import org.testng.annotations.Test;
import tests.BaseTest;
import org.testng.Assert;

public class CheckUrl extends BaseTest {

    @Test
    public void CheckUrlOnBasePage() {
        Assert.assertTrue(driver.getCurrentUrl().contains("cloud"));
    }
}

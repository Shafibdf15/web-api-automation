package web.CaseDefinitions;

import web.Utility.driverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends driverUtility {
    @Before
    public void beforeTest() {
        getDriver();

    }

    @After
    public void afterTest() {
        driver.close();
    }
}

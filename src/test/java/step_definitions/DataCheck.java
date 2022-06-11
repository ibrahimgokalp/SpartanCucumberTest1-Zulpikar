package step_definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.*;
import utilities.*;

public class DataCheck extends MainPage {

    @Given("I goto webpage")
    public void i_goto_webpage() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("I provide spartan {int}")
    public void i_provide_spartan(Integer int1) {
        getByIndex(int1);        ;
    }

    @Then("{string} and {string} should match")
    public void and_should_match(String string, String string2) {
        Assert.assertEquals(string, name.getText());
        Assert.assertEquals(string2, gender.getText());
    }

}

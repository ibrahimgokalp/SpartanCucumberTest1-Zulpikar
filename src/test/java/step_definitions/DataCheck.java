package step_definitions;

import io.cucumber.java.bs.*;
import io.cucumber.java.en.*;
import io.restassured.*;
import io.restassured.http.*;
import io.restassured.response.*;
import org.junit.*;
import pages.*;
import utilities.*;

import java.util.*;

public class DataCheck extends MainPage {

    String env = null;
    Response response = null;
    Map<String, Object> dbMap = null;

    int count = 0;

    @Given("I goto {string}")
    public void i_goto_webpage(String string) {
        env = string;

    }

    @When("I provide spartan {int}")
    public void i_provide_spartan(Integer int1) {

        switch (env){
            case "webpage":
                getByIndex(int1);
                break;

            case "api":
                response = RestAssured.given().accept(ContentType.JSON)
                        .and().pathParam("id", int1)
                        .when().get(ConfigurationReader.get("api_url") + "/api/spartans/{id}");
                break;

            case "db":
                DBUtils.createConnection();
                String query = "SELECT SPARTAN_ID,NAME,GENDER,PHONE\n" +
                        "FROM SPARTANS\n" +
                        "WHERE SPARTAN_ID = " + int1 + "";

                dbMap = DBUtils.getRowMap(query);
                break;
        }



    }

    @Then("{string} and {string} should match")
    public void and_should_match(String string, String string2) {

        switch (env){

            case "webpage":
                Assert.assertEquals(string, name.getText());
                Assert.assertEquals(string2, gender.getText());
                break;

            case "api":
                Assert.assertEquals(string, response.path("name"));
                Assert.assertEquals(string2, response.path("gender"));
                break;

            case "db":
                Assert.assertEquals(string, dbMap.get("NAME"));
                Assert.assertEquals(string2, dbMap.get("GENDER"));
                break;
        }

    }

    @When("I search by {string}")
    public void i_search_by(String string) {

        switch (env){
            case "webpage":
                Driver.get().get(ConfigurationReader.get("url"));
                inputBar.sendKeys(string);
                searchButton.click();
                break;

            case "api":
                response = RestAssured.given().accept(ContentType.JSON)
                        .and().queryParams("nameContains",string)
                        .when().get(ConfigurationReader.get("api_url") + "/api/spartans/search");
                break;

            case "db":
                DBUtils.createConnection();
                String query = "SELECT SPARTAN_ID,NAME,GENDER,PHONE\n" +
                        "FROM SPARTANS\n" +
                        "WHERE NAME = \'" + string + "\'" ;
                count = DBUtils.getQueryResultList(query).size();
                break;



        }
    }




    @Then("the result should equal to {string}")
    public void theResultShouldEqualToCount(String string) {
        switch (env){
            case "webpage":
                Assert.assertEquals(string,totalCount.getText().substring(2));
                break;

            case "api":
                Assert.assertEquals(Integer.valueOf(string),response.path("totalElement"));
                break;

            case "db":
                Assert.assertEquals(string,String.valueOf(count));
                break;
        }
    }
}

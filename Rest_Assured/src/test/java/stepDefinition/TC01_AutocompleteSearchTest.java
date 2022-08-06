package stepDefinition;

import java.net.URI;
import org.testng.Assert;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class TC01_AutocompleteSearchTest {

    private Scenario scenario;
    private Response response;
	private final String BASE_URL = "https://demo.nopcommerce.com/catalog/";
	 
	 @Before
	 public void before(Scenario scenarioVal) {
		 this.scenario = scenarioVal;
	 }
	 
	 @Given("Get call to {string}")
	 public void get_call_to(String url) throws Exception {

		 RestAssured.baseURI = BASE_URL;
		 RequestSpecification req = RestAssured.given();
		 response = req.when().get(new URI(url));
	 }
	 
	 @Then("Validate response status code is {string}")
	 public void validate_response_status_code_is(String statusCode) {
		 int responseCode = response.then().extract().statusCode();
		 Assert.assertEquals(statusCode, responseCode+"");
	 }
	 @Then("Validate response body is contain {string}")
	 public void validate_response_body_is_contain(String responsebody) {
	        response.then().statusCode(200);
	        response = response.then().extract().response();
	        scenario.log("Response Received == " + response.asPrettyString());
	        System.out.println(response.asPrettyString());
	        System.out.println("**********************************************************");
   
	        Assert.assertTrue(response.asPrettyString().contains("Asus N551JK-XO076H Laptop"));
	 }
	
}

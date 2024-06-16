package stepdefinitions;

import hooks.HooksAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ApiUtils;
import utilities.ConfigReader;
import utilities.ReusableMethods;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;


    public class ApiStepDefinitions {
        private Response response;
        public static String fullPath;
        @Given("User sets the base API URL to {string}")

        public void userSetsTheBaseAPIURLTo(String url) {
         RestAssured.baseURI=url;

        }
        @Given("API user sets {string} path parameters")
        public void apiUserSetsPathParameters(String rawPaths) {
            if (HooksAPI.spec == null) {
                throw new IllegalStateException("spec is null. HooksAPI.setUpApi() method did not run correctly.");
            }

            String[] paths = rawPaths.split("/");
            StringBuilder tempPath = new StringBuilder();

            for (int i = 0; i < paths.length; i++) {
                String key = "pp" + i; // pp0, pp1, pp2, pp3
                String value = paths[i].trim();
                HooksAPI.spec.pathParam(key, value);
                tempPath.append("/").append(value);
            }
            fullPath = tempPath.toString();
            System.out.println("fullPath = " + fullPath);

        }

        @When("User sends a login request with {string} and {string}")
        public void userSendsALoginRequestWithAnd(String identifier, String password) {

            Map<String, String> loginData = new HashMap<>();
            loginData.put(identifier, ConfigReader.getProperty("invalidUsername"));
            loginData.put(password, ConfigReader.getProperty("invalidPassword"));

            response = ApiUtils.sendPostRequest("/api/login", loginData);
            ApiUtils.logResponseDetails(response);
        }

        @Then("User should receive a login failure response")
        public void userShouldReceiveALoginFailureResponse() {
            assertThat(response.jsonPath().getString("error"), containsString(ConfigReader.getProperty("unsuccessfulMessage")));


        }@And("User updates {string} and {string} information")
        public void userUpdatesAndInformation(String name, String job) {
            Map<String, String> updateData = new HashMap<>();

            updateData.put(name, ConfigReader.getProperty("validName"));
            updateData.put(job, ConfigReader.getProperty("validJob"));

            response = ApiUtils.sendPutRequest("/api/users/2", updateData);
            ApiUtils.logResponseDetails(response);
        }
        @And("Verifies that the job title is {string}")
        public void verifiesThatTheJobTitleIs(String jobName) {
                String actualJob = response.jsonPath().getString("job");
                assertThat(actualJob, equalTo("Tester"));
               ApiUtils.logResponseDetails(response);
            }


    }



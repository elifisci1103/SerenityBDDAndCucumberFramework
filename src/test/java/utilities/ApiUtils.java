package utilities;

import hooks.HooksAPI;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import static net.serenitybdd.rest.RestRequests.given;
import static org.hamcrest.Matchers.equalTo;


public class ApiUtils {


    public static Response sendGetRequest(String url, int expectedStatusCode, String expectedContentType,String expectedHeader, String expectedHeaderValue, String jsonPath, Object expectedBodyValue) {
        Response response=given()
                .when()
                .get(url)
                .then()
                .assertThat()
                .statusCode(expectedStatusCode)
                .contentType(expectedContentType)
                .header(expectedHeader,expectedHeaderValue)
                .body(jsonPath,equalTo(expectedBodyValue))
                .extract().response();

        System.out.println("Response Body: " + response.getBody().asString());
        return response;
    }

    @Step
    public static void logResponseDetails(Response response) {
        Serenity.recordReportData()
                .withTitle("API Response")
                .andContents(response.asString());}

    public static Response sendPostRequest(String endpoint, java.util.Map<String, String> requestBody) {
            RequestSpecification request = SerenityRest.given().header("Content-Type", "application/json").body(requestBody);
            return request.post(endpoint);}

    public static Response sendPutRequest(String endpoint, java.util.Map<String, String> requestBody) {
        RequestSpecification request = SerenityRest.given().header("Content-Type", "application/json").body(requestBody);
        return request.put(endpoint);}


    public static Response sendDeleteRequest(String endpoint) {
        return SerenityRest.given()
                .when()
                .delete(endpoint);}

}

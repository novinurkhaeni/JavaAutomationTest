package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SetUp {
    public String token;
    public String accountId;
    public String endPoint = "https://api-main.kipaskipas.com/api/v1";

    public static void main(String[] args) {
        SetUp setUp = new SetUp();
        setUp.publicHome();
        setUp.login();
        setUp.feedByProfile();
//        setUp.deleteFeed();
    }

    public void publicHome() {
        //RestAssured.baseURI Perintah untuk get request ke endpoint tertentu
        RestAssured.baseURI = "https://api-main.kipaskipas.com/api/v1";
        //Response memberikan parameter get
        Response response = get("/public/feeds/channels?code=tiktok&page=0&size=10&isTrending=true");

        //tampilkan response
        System.out.println("Status Code : " + response.getStatusCode());
        System.out.println("Respose Body : " + response.getBody().asString());

        //validasi status code
        response.then().statusCode(200);
    }

    public void login() {
        RestAssured.baseURI = endPoint;
        // membuat variabel request body
        String requestBody = "{\n" +
                "  \"username\": \"novinnn\",\n" +
                "  \"password\": \"Mabes132\"\n" +
                "}";
        //System.out.println(requestBody);

        //menghandle response
        Response response = given().contentType(ContentType.JSON).body(requestBody)
                .when().post("/auth/login") //endpoint post
                .then().statusCode(200)//validasi status code
                .extract().response(); //

        //syntask untuk menampilkan response body dengan beautify
        String responseBody = response.getBody().asString();
        JSONObject jsonResponse = new JSONObject(new JSONTokener(responseBody));
        String prettyResponse = jsonResponse.toString(4); // Indentasi 4 spasi untuk formatting JSON

        token = jsonResponse.getString("token"); //MENYIMPAN TOKEN KE DALAM VARIABLE INSTANCE
        accountId = jsonResponse.getString("accountId");
        //System.out.println("Token: " + token);
        System.out.println("Respose Body Login :\n" + prettyResponse);
    }

    public void feedByProfile(){

        RestAssured.baseURI = endPoint;
        Response response = given().header("Authorization","Bearer" + token)
                .when().get("/profile/post/" + accountId + "?size=10&sort=createAt&direction=DESC&page=0")
                .then().statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        JSONObject jsonResponse = new JSONObject(new JSONTokener(responseBody));
        String prettyResponse = jsonResponse.toString(4); // Indentasi 4 spasi untuk formatting JSON

        System.out.println("Status Code : " + response.getStatusCode());
//        System.out.println("Respose Body : " + response.getBody().asString());

        response.then().statusCode(200);
        System.out.println("Respose Body Feed Profile:\n" + prettyResponse);
    }

    public void deleteFeed(){
        RestAssured.baseURI = endPoint;

        Response response = given().header("Authorization","Bearer" + token)
                .when().delete("/feeds/4028807a912baaba01913139e6f94519")
                .then().statusCode(200)
                .extract().response();

        String responseBody = response.getBody().asString();
        JSONObject jsonResponse = new JSONObject(new JSONTokener(responseBody));
        String prettyResponse = jsonResponse.toString(4); // Indentasi 4 spasi untuk formatting JSON

        System.out.println("Status Code : " + response.getStatusCode());
//        System.out.println("Respose Body : " + response.getBody().asString());

        response.then().statusCode(200);
        System.out.println("Respose Body Delete Feed :\n" + prettyResponse);
    }
}

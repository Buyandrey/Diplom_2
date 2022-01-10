import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class CreateUserEndpoint {
    private final String BASE_URL="https://stellarburgers.nomoreparties.site";
    private final String CREATE="/api/auth/register";
    private String email,password,name,bodyResponse;
    private int statusCode;

    public int getStatusCode(){
        return statusCode;
    }
    public String getBodyResponse(){
        return bodyResponse;
    }
    public CreateUserEndpoint(String email, String password, String name){
        this.email=email;
        this.password=password;
        this.name=name;
    }
    private JSONObject jsonBody= new JSONObject();

    public void createUser(){
        jsonBody.put("email",email)
                .put("password",password)
                .put("name", name);
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(jsonBody.toString())
                .when()
                .post(BASE_URL+CREATE);
        statusCode=response.getStatusCode();
        bodyResponse=response.getBody().asString();
        //System.err.println(statusCode+" "+ bodyResponse);
    }
}

package api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specifications {

    public static RequestSpecification requestSpec(String url){
      return new RequestSpecBuilder()
              .setBaseUri(url)
              .setContentType(ContentType.JSON)
              .build();
    }
    public static ResponseSpecification responseSpecOk202(){
        return new ResponseSpecBuilder()
                .expectStatusCode(202)
                .build();
    }
    public static ResponseSpecification responseSpecOk200(){
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
    public static void InstallSpecification(RequestSpecification  request,ResponseSpecification response){
        RestAssured.requestSpecification=request;
        RestAssured.responseSpecification=response;
    }
}

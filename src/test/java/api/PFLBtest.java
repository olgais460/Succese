package api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


public class PFLBtest {
    private static final String URL = "http://77.50.236.203:4879";

    @Test
    public void getUser() {
        Specifications.InstallSpecification(Specifications.requestSpec(URL), Specifications.responseSpecOk200());
        Integer Id=2;
      UserInfo userInfo = given()
                .when()
                .get("user/2")
                .then().log().all()
                .extract().body().jsonPath().getJsonObject("$");

       Assertions.assertNotNull((userInfo),"Пришел пустой ответ");
      Assertions.assertEquals(Id,(userInfo.getId()), "Проверка на ID не прошла");
    }
    }

// В 20-й строчке выпадает CastExeption. Не знаю, как исправить

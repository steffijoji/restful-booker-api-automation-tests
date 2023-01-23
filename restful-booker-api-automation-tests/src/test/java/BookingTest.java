import Entities.Booking;
import Entities.BookingDates;
import Entities.User;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static io.restassured.config.LogConfig.logConfig;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookingTest {
    private static User user;
    private static Booking booking;
    private static BookingDates bookingdates;
    private static RequestSpecification request;
    private static Faker faker;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
        faker = new Faker();
        user = new User(
                faker.name().username(),
                faker.internet().password(),
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().fullAddress(),
                faker.internet().safeEmailAddress(),
                faker.phoneNumber());

        bookingdates = new BookingDates(
                faker.date().birthday(),
                faker.date().birthday());

        booking = new Booking(
                user.getFirstName(),
                user.getLastName(),
                faker.number().randomNumber(),
                faker.random().nextBoolean(),
                bookingdates,
                faker.food().toString());
    }

    @BeforeEach
    public void setRequest() {
        request = given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .contentType(ContentType.JSON)
                .auth().basic("admin", "password123");
    }

    @Test
    @Order(1)
    public void createToken_ValidData_ReturnOK() {
        Response response = request
                .when()
                .post("/auth")
                .then()
                .assertThat().statusCode(200).and()
                .time(lessThan(2000L))
                .extract().response();

        Assertions.assertNotNull(response);
    }

    @Test
    @Order(2)
    public void getBookingIds_ReturnOK() {
        Response response = request
                .when()
                .get("/booking")
                .then()
                .assertThat().statusCode(200).and()
                .time(lessThan(2000L))
                .extract().response();

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.getBody().asPrettyString().contains("bookingid"));
    }

    @Test
    @Order(3)
    public void getBookingById_ReturnOK() {
        Response response = request
                .when()
                .get("/booking/4")
                .then()
                .assertThat().statusCode(200).and()
                .time(lessThan(2000L))
                .extract().response();

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.getBody().asPrettyString().contains("bookingdates"));
    }

    @Test
    @Order(4)
    public void createBooking_ReturnOK() {
        given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .contentType(ContentType.JSON)
                .when()
                .body(booking)
                .post("/booking")
                .then()
                .assertThat().statusCode(200).and()
                .time(lessThan(2000L));
    }

    @Test
    @Order(5)
    public void updateBooking_WithoutAuthorization_Return403() {
        given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .contentType(ContentType.JSON)
                .when()
                .body(booking)
                .put("/booking/1")
                .then()
                .assertThat().statusCode(403).and()
                .time(lessThan(2000L));
    }


    @Test
    @Order(6)
    public void updateBooking_ValidData_ReturnOK() {
        given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .body(booking)
                .put("/booking/1")
                .then()
                .assertThat().statusCode(200).and()
                .time(lessThan(2000L));
    }

    @Test
    @Order(7)
    public void deleteBooking_ReturnOK() {
        given().config(RestAssured.config().logConfig(logConfig().enableLoggingOfRequestAndResponseIfValidationFails()))
                .contentType(ContentType.JSON)
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                .delete("/booking/1")
                .then()
                .assertThat().statusCode(201).and()
                .statusLine(containsString("Created"))
                .time(lessThan(2000L));
    }
}

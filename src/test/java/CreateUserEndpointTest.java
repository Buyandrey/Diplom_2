import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CreateUserEndpointTest {
    CreateUserEndpoint createUserEndpoint;
    ResponseCodesAndBodys expected = new ResponseCodesAndBodys();
    @Before
    public void before() {
        createUserEndpoint= new CreateUserEndpoint(
                RandomStringUtils.randomAlphabetic(5) + "@gmail.com",
                "1234",
                RandomStringUtils.randomAlphabetic(4));
    }
    @Test
    public void createUserTest(){

    }
    @Test
    public void createTheSameUserTwiceTest(){
        createUserEndpoint.createUser();
        createUserEndpoint.createUser();
        assertEquals("Код Дважды создать пользователя нельзя должен",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело Дважды создать пользователя нельзя",
                expected.RESPONSE_BODY_403_ALREADY_EXIST,
                createUserEndpoint.getBodyResponse());
    }
    @Test
    public  void creteUserWithoutEmail() {

        createUserEndpoint.setEmail(null);
        createUserEndpoint.createUser();
        assertEquals("Код Создание без почты",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело создание без почты",
                expected.RESPONSE_BODY_403_REQUIRED_FIELD,
                createUserEndpoint.getBodyResponse());
    }
    @Test
    public  void creteUserWithoutPassword() {

        createUserEndpoint.setPassword(null);
        createUserEndpoint.createUser();
        assertEquals("Код Создание без пароля",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело создание без пароля",
                expected.RESPONSE_BODY_403_REQUIRED_FIELD,
                createUserEndpoint.getBodyResponse());
    }
    @Test
    public  void creteUserWithoutName() {

        createUserEndpoint.setName(null);
        createUserEndpoint.createUser();
        assertEquals("Код Создание без имени",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело создание без имени",
                expected.RESPONSE_BODY_403_REQUIRED_FIELD,
                createUserEndpoint.getBodyResponse());
    }
    @Test
    public  void creteUserEmpty() {
        createUserEndpoint.setPassword(null);
        createUserEndpoint.setEmail(null);
        createUserEndpoint.setName(null);
        createUserEndpoint.createUser();
        assertEquals("Код Создание без полей",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело создание без полей",
                expected.RESPONSE_BODY_403_REQUIRED_FIELD,
                createUserEndpoint.getBodyResponse());
    }
    @Test
    public  void creteUserOnlyWithEmail() {
        createUserEndpoint.setPassword(null);
        createUserEndpoint.setName(null);
        createUserEndpoint.createUser();
        assertEquals("Код Создание только с почтой",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело создание только с почтой",
                expected.RESPONSE_BODY_403_REQUIRED_FIELD,
                createUserEndpoint.getBodyResponse());
    }
    @Test
    public  void creteUserOnlyWithPassword() {
        createUserEndpoint.setEmail(null);
        createUserEndpoint.setName(null);
        createUserEndpoint.createUser();
        assertEquals("Код Создание только с паролем",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело создание только с паролем",
                expected.RESPONSE_BODY_403_REQUIRED_FIELD,
                createUserEndpoint.getBodyResponse());
    }
    @Test
    public  void creteUserOnlyWithName() {
        createUserEndpoint.setEmail(null);
        createUserEndpoint.setPassword(null);
        createUserEndpoint.createUser();
        assertEquals("Код Создание только с именем",
                expected.CODE_403_FORBIDDEN,
                createUserEndpoint.getStatusCode());
        assertEquals("Тело создание только с именем",
                expected.RESPONSE_BODY_403_REQUIRED_FIELD,
                createUserEndpoint.getBodyResponse());
    }
}

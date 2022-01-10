import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class CreateUserEndpointTest {
    CreateUserEndpoint createUserEndpoint;
    @Before
    public void before() {
        createUserEndpoint= new CreateUserEndpoint(
                RandomStringUtils.randomAlphabetic(5) + "@gmail.com",
                "1234",
                RandomStringUtils.randomAlphabetic(4));
    }
    @Test
    public void canCreateUserTest(){

    }
    @Test
    public void cantCreateTheSameUserTwiceTest(){
        createUserEndpoint.createUser();
        createUserEndpoint.createUser();

        assertEquals(403,createUserEndpoint.getStatusCode());
        //assertEquals(403,createUserEndpoint.getStatusCode());
    }
}

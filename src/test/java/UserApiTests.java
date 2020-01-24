import org.junit.Test;
import static Constants.Constants.USERNAMEVALID;
import static Constants.Constants.USERNAMEINVALID;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserApiTests {

    @Test
    public void UsersAPI_Returns200() {
        UsersApi userApiStatus = new UsersApi();
        userApiStatus.userApiStatus200();
    }

    @Test
    public void searchValidUserID() {
        UsersApi searchUsers = new UsersApi();
        Integer userId = searchUsers.searchUserByValidName(USERNAMEVALID);
        assertEquals(3, userId);
    }

    @Test
    public void searchInvalidUserID() {
        UsersApi searchUsers = new UsersApi();
        assertEquals(0, searchUsers.searchUserByInvalidName(USERNAMEINVALID));
    }
}
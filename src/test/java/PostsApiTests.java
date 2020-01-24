import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static Constants.Constants.*;


public class PostsApiTests {

    @Test
    public void PostsAPI_Returns200(){
        PostsApi postApiStatus = new PostsApi();
        postApiStatus.postApiStatus200();
    }

    @Test
    public void verifyPostsReturnedByValidUserId() {
        PostsApi postsUserId = new PostsApi();
        Integer userIDs = postsUserId.searchPostsByValidUserID(USERIDVALID);
        assertEquals(3, userIDs);
    }

    @Test
    public void verifyPostsReturnedByInvalidUserId() {
        PostsApi postUserId = new PostsApi();
        assertEquals(0, postUserId.searchPostsByInvalidUserID(USERIDINVALID));
    }
}

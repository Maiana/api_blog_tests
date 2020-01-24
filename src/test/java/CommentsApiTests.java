import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static Constants.Constants.*;


public class CommentsApiTests {

    @Test
    public void CommentsAPI_Returns200(){
        CommentsApi commentApiStatus = new CommentsApi();
        commentApiStatus.commentApiStatus200();
    }

    @Test
    public void verifyCommentsReturnedByPostId() {
        CommentsApi commentByPostId = new CommentsApi();
        Integer postID = commentByPostId.searchCommentsByPostId(POSTIDVALID);
        assertEquals(POSTIDVALID, postID);
    }

    @Test
    public void verifyEmailFormatFromComments() {
        CommentsApi verifyEmail = new CommentsApi();
        verifyEmail.verifyEmailFromComments(POSTIDVALID);
    }
}

package pe.hoonihoon.bootstrap.constants;

import java.util.ArrayList;

import pe.hoonihoon.bootstrap.view.vo.Comment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 152317 on 2017-04-07.
 */

public interface SampleApiService {

    // 1.0 동기
/*    @GET("comment")
    ArrayList<Comment> loadComment(@Query("postId")int postId);*/

    //1.0 비동기
    @GET("comments")
    void loadComment(@Query("postId")int postId, Callback<ArrayList<Comment>> cb);

    //2.0
    @GET("comments")
    Call<ArrayList<Comment>> loadComment(@Query("postId")int postId);
}

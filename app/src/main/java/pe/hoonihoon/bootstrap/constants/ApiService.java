package pe.hoonihoon.bootstrap.constants;

import java.util.ArrayList;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import pe.hoonihoon.bootstrap.view.vo.Comment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by 152317 on 2017-04-03.
 */

public interface ApiService {
    public static final String RETROFIT_TEST_API_URL = "http://jsonplaceholder.typicode.com/";

    //동기
    @GET("comments")
    Call<ArrayList<Comment>> getComment(@Query("postId") int postId, Callback<ArrayList<Comment>> callback);
    //비동기
    @GET("comments")
    void getComment(@Query("postId")int postId, Call<ArrayList<Comment>> cb);
    //RxAndroid
    @GET("comments")
    Observable<ArrayList<Comment>> loadComment(@Query("postId")int postId);

    /**
     *   Retrofit1 에서 동기와 비동기의 call 이 두개의 메서드를 정의 해야 하는 단점.
     *   Retrofit2 에서 해결.
     *
     */
}

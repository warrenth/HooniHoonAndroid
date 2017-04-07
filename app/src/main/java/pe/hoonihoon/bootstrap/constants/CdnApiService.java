package pe.hoonihoon.bootstrap.constants;

import io.reactivex.Observable;
import pe.hoonihoon.bootstrap.view.vo.ServiceResult;
import retrofit2.http.GET;

/**
 * Created by 152317 on 2017-04-03.
 */

public interface CdnApiService {

    @GET("**")
    Observable<ServiceResult> getSubjectList();

/*
    //비동기 Rx2.0
    @GET("comments")
    Call<ArrayList<Comment>> loadComment(@Query("postId")int postId);

    //RxAndroid
    @GET("comments")
    Observable<ArrayList<Comment>> loadCommentObserver(@Query("postId")int postId);*/
}

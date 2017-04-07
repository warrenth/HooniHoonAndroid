package pe.hoonihoon.bootstrap.constants;

import java.util.ArrayList;

import io.reactivex.Observable;
import pe.hoonihoon.bootstrap.view.vo.Comment;
import pe.hoonihoon.bootstrap.view.vo.ServiceResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 152317 on 2017-04-03.
 */

public interface CdnApiService {

    @GET("/ui/app/test/subject01.json")
    Observable<ServiceResult> getSubjectList();


}

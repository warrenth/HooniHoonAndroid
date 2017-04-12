package pe.hoonihoon.bootstrap.constants;

import io.reactivex.Observable;
import pe.hoonihoon.bootstrap.view.vo.CdnModel;
import retrofit2.http.GET;

/**
 * Created by 152317 on 2017-04-03.
 */

public interface CdnApiService {

    @GET("/ui/app/test/subject01.json")
    Observable<CdnModel> getSubjectList();


}

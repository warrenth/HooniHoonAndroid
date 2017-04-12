package pe.hoonihoon.bootstrap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pe.hoonihoon.bootstrap.R;
import pe.hoonihoon.bootstrap.network.RetrofitManager;
import pe.hoonihoon.bootstrap.network.api.ServiceController;
import pe.hoonihoon.bootstrap.view.vo.CdnModel;
import pe.hoonihoon.bootstrap.view.vo.ServiceResult;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Retrofit 1.0  동기
         */
        //Response<ArrayList<Comment>> comment = ServiceController.getSampleApiService().loadComment(1).execute();
        //public static final String CDN_URL = "http://static.ssgcdn.com/";

        /**
         * Retrofit 1.0  비동기
         */
        /*ServiceController.getSampleApiService().loadComment(1, new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });*/


        /**
         * Retrofit 2.0 비동기
         * OkHttp 상위 구현체로써 Request, Response 를 구현. 쉽게 header statusCode, body 에 접근 가능.
         */
       /* Call<ArrayList<Comment>> comment =  ServiceController.getSampleApiService().loadComment(1);
        comment.enqueue(new Callback<ArrayList<Comment>>() {
                            @Override
                            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                                if(response.isSuccessful()) {
                                    Log.d("kth", "call : " + call.request().url());
                                    Log.d("kth", "response : " + response.body());
                                    Log.d("kth", "code : " + response.code());
                                }
                            }

                            @Override
                            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                                Log.d("kth","response : " + t);
                            }
                        });*/

        /**
        * Restrofit 2.0 + RxJava
        */
        RetrofitManager.getInstance().changeApiBaseUrl("http://static.ssgcdn.com/");

        ServiceController
                .getCdnApiService()
                .getSubjectList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CdnModel>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CdnModel result) {
//                        CdnModel a = result;

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

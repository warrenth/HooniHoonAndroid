package pe.hoonihoon.bootstrap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import pe.hoonihoon.bootstrap.R;
import pe.hoonihoon.bootstrap.network.api.ServiceController;
import pe.hoonihoon.bootstrap.view.vo.Comment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Retrofit 1.0  동기
         */
        //Response<ArrayList<Comment>> comment = ServiceController.getSampleApiService().loadComment(1).execute();

        /**
         * Retrofit 1.0  비동기
         */
        ServiceController.getSampleApiService().loadComment(1, new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {

            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });


        /**
         * Retrofit 2.0 비동기
         */
        Call<ArrayList<Comment>> comment =  ServiceController.getSampleApiService().loadComment(1);
        comment.enqueue(new Callback<ArrayList<Comment>>() {
                            @Override
                            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                                Log.d("kth","response : " + response.body());
                            }

                            @Override
                            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                                Log.d("kth","response : " + t);
                            }
                        });

        /**
        * Restrofit 2.0 + RxJava
        */
        /*ServiceController
                .getCdnApiService()
                .getSubjectList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ServiceResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ServiceResult serviceResult) {
                        Log.d("kth",""+serviceResult.getResult().toString());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }
}

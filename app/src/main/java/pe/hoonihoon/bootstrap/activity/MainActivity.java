package pe.hoonihoon.bootstrap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pe.hoonihoon.bootstrap.R;
import pe.hoonihoon.bootstrap.constants.ApiService;
import pe.hoonihoon.bootstrap.view.vo.Comment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.RETROFIT_TEST_API_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);
        // 1.동기
        Call<ArrayList<Comment>> comment = apiService.getComment(1);
        comment.enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                Log.d("kth","all :" + response.toString());
                Log.d("kth","body :" + response.body().toString());
                Log.d("kth","message :" + response.message().toString());
                Log.d("kth","code :" + response.code());
                Log.d("kth","isSuccessful :" + response.isSuccessful());
                Log.d("kth","raw :" + response.raw().toString());
                Log.d("kth","errorBody :" + response.errorBody());
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                Log.d("kth","onFailure : " + t.toString());
            }
        });
        //비동기
        apiService.getComment(1, new Callback<ArrayList<Comment>>() {
            @Override public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {

            }

            @Override public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });

        /*Observable<ArrayList<Comment>> commentObservable = apiService.getCommentObservable(1).sub;*/
        apiService.loadComment(1)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<Comment>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<Comment> comments) {
                        Log.d("kth","onNext :" + comments.size());
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

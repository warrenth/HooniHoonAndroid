package pe.hoonihoon.bootstrap.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pe.hoonihoon.bootstrap.R;
import pe.hoonihoon.bootstrap.network.api.ApiServiceController;
import pe.hoonihoon.bootstrap.view.vo.ServiceResult;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Retrofit 1.0
         */

        /**
         * Retrofit 2.0
         */

        /**
         * Restrofit 2.0 + RxJava
         */
        ApiServiceController
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
                });
    }
}

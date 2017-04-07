package pe.hoonihoon.bootstrap.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import pe.hoonihoon.bootstrap.constants.BaseUrl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 152317 on 2017-04-06.
 */

public class RetrofitManager {
    private static RetrofitManager sInstance = new RetrofitManager();

    private OkHttpClient mClint;
    private Retrofit mRetrofit;

    public RetrofitManager() {
        mClint = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl.SAMPLE_URL)
                .client(mClint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static RetrofitManager getInstance() {
        return sInstance;
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }

    public void changeApiBaseUrl(String url) {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(mClint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}

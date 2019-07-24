package com.namget.data.remote;

import com.namget.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRemote {
    private ApiService apiService;
    private static final int CONNECT_TIMEOUT = 15;
    private static final int WRITE_TIMEOUT = 15;
    private static final int READ_TIMEOUT = 15;

    private static class LazyHolder {
        private static final NetworkRemote INSTANCE = new NetworkRemote();
    }

    //기본 생성자 제거
    private NetworkRemote() {
        throw new AssertionError("NetworkRemote default constructor don't allow here");
    }

    public static NetworkRemote getInstance() {
        return LazyHolder.INSTANCE;
    }


    public ApiService getApiService() {
        if (apiService == null) {
            Retrofit retrofit;
            final String baseURL = "https://dapi.kakao.com";
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addInterceptor(chain -> {
                        Request request;
                        Request.Builder builder = chain.request().newBuilder();
                        builder.addHeader("Authorization", "KakaoAK 5e56490bfbd7252e3b5d764d63528974");
                        builder.addHeader("Accept", "application/json; charset=utf-8");
                        request = builder.build();
                        return chain.proceed(request);
                    })
                    .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                    .build();
            // 서버와 HTTP 통신시 주고 받는 값을 확인하기 위해 HttpLogginInterceptor 추가
            if (BuildConfig.DEBUG) {
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            } else {
                interceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
            }
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .build();
            apiService = retrofit.create(ApiService.class);
        }
        return apiService;
    }

}

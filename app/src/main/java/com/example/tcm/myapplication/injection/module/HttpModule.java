package com.example.tcm.myapplication.injection.module;

import com.example.tcm.myapplication.BuildConfig;
import com.example.tcm.myapplication.base.Constants;
import com.example.tcm.myapplication.model.Apis;
import com.example.tcm.myapplication.model.CacheInterceptor;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author liuwen
 * @Module.Name
 * @Create.Date 2019/3/11 14:02
 * @Update.By liuwen
 * @Update.Content
 * @Update.Date 2019/3/11 14:02
 * @see
 */
@Module
public class HttpModule {

    @Provides
    Retrofit.Builder provideRetrofitBuilder() {
        return new Retrofit.Builder();
    }

    @Provides
    Retrofit provideRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return createRetrofit(builder, client, url);
    }

    @Provides
    Apis provideService(Retrofit retrofit){
        return retrofit.create(Apis.class);
    }

    @Provides
    OkHttpClient provideClient(OkHttpClient.Builder builder) {
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }
        File cacheFile = new File(Constants.PATH_CACHE);
        Cache cache = new Cache(cacheFile, 1024 * 1024 * 50);
        //设置缓存
        CacheInterceptor cacheInterceptor = new CacheInterceptor();
        builder.addNetworkInterceptor(cacheInterceptor);
        builder.addInterceptor(cacheInterceptor);
        builder.cache(cache);
        //设置超时
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(20, TimeUnit.SECONDS);
        builder.writeTimeout(20, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        return builder.build();
    }

    private Retrofit createRetrofit(Retrofit.Builder builder, OkHttpClient client, String url) {
        return builder
                .baseUrl(url)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

}

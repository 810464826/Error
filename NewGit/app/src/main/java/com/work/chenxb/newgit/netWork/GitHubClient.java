package com.work.chenxb.newgit.netWork;

import com.work.chenxb.newgit.login.model.AccessTokenResult;
import com.work.chenxb.newgit.login.model.User;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

/**
 * 用Retrofit的话，能基本表现出很多的HTTP基本知识
 * 作者：ChenXb on 2016/7/28.23:28
 * 邮箱：810464826@qq.com
 */
public class GitHubClient implements GitHubApi{
//    private GitHubApi gitHubApi;
//    //单例模式
//    private static GitHubClient gitHubClient;
//    public static GitHubClient getInstance(){
//        if (gitHubClient==null){
//            gitHubClient=new GitHubClient();
//        }
//        return gitHubClient;
//    }
//    private GitHubClient() {
//
//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                //添加拦截器
//                .addInterceptor(new TokenInterceptor())
//                .build();
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .client(okHttpClient)
//                // Gson转换器   不要忘记
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        // 构建API
//        gitHubApi = retrofit.create(GitHubApi.class);
//    }
//
//    public GitHubApi getGitHubApi() {
//        return gitHubApi;
//    }
//
//    //这个返回值写掉了
//    @Override
//    public Call<AccessTokenResult> getOAuthToken(@Field("client_id") String client, @Field("client_secret") String clientSecret, @Field("code") String code) {
//        return gitHubApi.getOAuthToken(client,clientSecret,code);
//    }
//
//    @Override
//    public Call<User> getUserInfo() {
//        return gitHubApi.getUserInfo();
//    }
    private GitHubApi gitHubApi;

    private static GitHubClient gitHubClient;

    public static GitHubClient getInstance() {
        if (gitHubClient == null) {
            gitHubClient = new GitHubClient();
        }
        return gitHubClient;
    }

    private GitHubClient() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                // 添加token拦截器
                .addInterceptor(new TokenInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(okHttpClient)
                // Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // 构建API
        gitHubApi = retrofit.create(GitHubApi.class);
    }

    @Override public Call<AccessTokenResult> getOAuthToken(@Field("client_id") String client, @Field("client_secret") String clientSecret, @Field("code") String code) {
        return gitHubApi.getOAuthToken(client,clientSecret,code);
    }

    @Override public Call<User> getUserInfo() {
        return gitHubApi.getUserInfo();
    }
}

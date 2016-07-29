package com.work.chenxb.newgit.netWork;


import com.work.chenxb.newgit.login.model.AccessTokenResult;
import com.work.chenxb.newgit.login.model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;


/**
 * Retrofit能将标准的reset接口，用Java接口来描述(通过注解),
 * 通过Retrofit的create方法，去创建Call模型
 * // 获取square公司retrofit仓库的所有参与者信息
 // 请求方式:Get
 // 请求路径:repos/square/retrofit/contributors
 // 请求参数：无
 // 请求头：无(其实OKHTTP内部会帮我们做一些基本数据补全)
 // 最终首次构建完成了一个Call模型
    GitHub开发者 申请一个app
        Client ID
            b8f7f720c220a4eeeca6
        Client Secret
            f96b591eb472333ecbca2216dce753dfcffcffd6
 * 作者：ChenXb on 2016/7/28.23:27
 * 邮箱：810464826@qq.com
 */
public interface GitHubApi {
//    //GitHub开发者，申请时填写的（重定向返回时的一个标记）
//    String CALL_BACK="http://www.chenxb8089@163.com";
//    String CLIENT_ID="b8f7f720c220a4eeeca6";
//    String CLIENT_SECRET="f96b591eb472333ecbca2216dce753dfcffcffd6";
//
//    /**
//     * user : 读写用户信息；
//     public_repo : 该用户公有库的访问权限，关注(starring)其他公有库的权限;
//     repo : 该用户公有和私有库的访问权限。
//     */
//    //授权时申请的课访问域
//    // 授权时申请的可访问域
//    String AUTH_SCOPE = "user,public_repo,repo";
//    // 授权登陆页面(用WebView来加载)
//    String AUTH_URL = "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID + "&scope=" + AUTH_SCOPE;
//
//
//    /**
//     * 获取访问令牌api
//     *  client_id	string	必要。 这是当你在GitHub上注册App时获得的Client Id。
//        client_secret	string	必要。 这是当你在GitHub上注册App时获得的Client secret。
//        code	string	必要。前一步获取到的临时授权码。
//     */
//    @Headers("Accept: application/json")
//    @FormUrlEncoded
//    @POST("https://github.com/login/oauth/access_token")
//    Call<AccessTokenResult> getOAuthToken(
//            @Field("client_id") String client,
//            @Field("client_secret") String clientSecret,
//            @Field("code") String code
//    );
//
//    @GET("user")
//    Call<User> getUserInfo();
// GitHub开发者，申请时填写的(重定向返回时的一个标记)
String CALL_BACK = "http://www.baidu.com";

    // GitHub开发者，申请就行
    String CLIENT_ID = "ecaade03865497b704fc";
    String CLIENT_SECRET = "76b5b8e88866df4db10e003b58b77791858d46d0";

    // 授权时申请的可访问域
    String AUTH_SCOPE = "user,public_repo,repo";
    // 授权登陆页面(用WebView来加载)
    String AUTH_URL = "https://github.com/login/oauth/authorize?client_id=" + CLIENT_ID + "&scope=" + AUTH_SCOPE;

    /**
     * 获取访问令牌API
     */
    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("https://github.com/login/oauth/access_token")
    Call<AccessTokenResult> getOAuthToken(
            @Field("client_id") String client,
            @Field("client_secret") String clientSecret,
            @Field("code") String code);

    @GET("user")
    Call<User> getUserInfo();

}

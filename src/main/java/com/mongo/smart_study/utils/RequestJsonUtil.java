package com.mongo.smart_study.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
@Component
public class RequestJsonUtil {


    private static String wxAppID;


    private static String wxAPPSecret;


    @Value("${wxApplicationID}")
    public void setWxAppID(String wxAppID) {
        RequestJsonUtil.wxAppID = wxAppID;
    }

    @Value("${wxAppSecret}")
    public void setWxAPPSecret(String wxAPPSecret) {
        RequestJsonUtil.wxAPPSecret = wxAPPSecret;
    }

    public static Map<String, String> getRequestJson(HttpServletRequest httpServletRequest) throws IOException {
        String body = StreamUtils.copyToString(httpServletRequest.getInputStream(), StandardCharsets.UTF_8);
        String username = null, password = null, wxUserCode = null,roles=null,nickName=null;
        if (StringUtils.hasText(body)) {
            JSONObject jsonObj = JSON.parseObject(body);
            wxUserCode = jsonObj.getString("code");
            username = jsonObj.getString("username");
            roles=jsonObj.getString("roles");
            nickName=jsonObj.getString("nickName");
            if (wxUserCode != null) {
                JSONObject codeJson = RequestJsonUtil.requestForWX(wxAppID,wxAPPSecret,wxUserCode);
                username=codeJson.getString("openid");
                password=codeJson.getString("openid");
            }
            else
            {
                //方便测试,同时兼容账户密码登录和微信登录
                password = jsonObj.getString("password");
            }
        }

        if (username == null)
            username = "";
        if (password == null)
            password = "";
        if (roles==null)
            roles="";
        username = username.trim();
        HashMap<String, String> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        map.put("roles",roles);
        map.put("nickName",nickName);
        return map;
    }

    public static JSONObject requestForWX(String wxAppID, String wxAPPSecret, String code) throws IOException {
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + wxAppID + "&secret=" + wxAPPSecret + "&js_code=" + code + "&grant_type=authorization_code";
        URL requestUrl = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) requestUrl.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        String resp = StreamUtils.copyToString(connection.getInputStream(), StandardCharsets.UTF_8);
        return JSON.parseObject(resp);
    }
}

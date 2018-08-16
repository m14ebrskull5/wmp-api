package com.wmp.api.common.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
/**
 * 
 * @ClassName: HttpRequestUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenaonan
 * @date 2017年6月6日 上午9:04:52
 *
 */
public class HttpRequestUtil {
	/**
     * 接口调用 GET
     */
    public static String httpURLConectionGET(String urlGetStr,Map<String,String> paramGetMap) {
        try {
        	String param = "";
        	for (String key : paramGetMap.keySet()) {
        		param += "&" + key + "=" + URLEncoder.encode(paramGetMap.get(key),"utf-8");
        	}
        	String url = urlGetStr + param.substring(1); 
            URL urlGet = new URL(url);    // 把字符串转换为URL请求地址
            HttpURLConnection connection = (HttpURLConnection) urlGet.openConnection();// 打开连接
            // http正文内，因此需要设为true
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("GET");
            // Post 请求不能使用缓存
            connection.setUseCaches(false);
            // URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
            connection.setInstanceFollowRedirects(true);
            // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
            // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
            // 进行编码
            connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
            connection.connect();// 连接会话
            // 获取输入流
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {// 循环读取流
                sb.append(line);
            }
            br.close();// 关闭流
            connection.disconnect();// 断开连接
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("失败!");
        }
        return null;
    }
    
    /**
     * 接口调用 POST
     */
    public static String httpURLConectionPOST(String urlPostStr,Map<String,String> paramPostMap) throws IOException {
    	StringBuffer sb = new StringBuffer();
    	String param = "";
    	for (String key : paramPostMap.keySet()) {
    		param += "&" + key + "=" + URLEncoder.encode(paramPostMap.get(key),"utf-8");
    	}
    	String url = urlPostStr + param.substring(1); 
        URL postUrl = new URL(url);
        // 打开连接
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        // 设置是否向connection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        // URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
        connection.setInstanceFollowRedirects(true);
        // 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
        // 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
        // 进行编码
        connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
        // 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
        // 要注意的是connection.getOutputStream会隐含的进行connect。
        connection.connect();
        DataOutputStream out = new DataOutputStream(connection.getOutputStream());
        out.flush();
        out.close(); // flush and close
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        connection.disconnect();
        return sb.toString();
    }
    
    /**
     * 接口调用 POST
     */
    public static String httpURLConectionJsonPOST(String urlPostStr,Map<String,String> paramPostMap) throws IOException {
    	StringBuffer sb = new StringBuffer();
    	String param = "";
    	for (String key : paramPostMap.keySet()) {
    		param += "&" + key + "=" + URLEncoder.encode(paramPostMap.get(key),"utf-8");
    	}
    	String url = urlPostStr + param.substring(1); 
    	URL postUrl = new URL(url);
    	// 打开连接
    	HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
    	// 设置是否向connection输出，因为这个是post请求，参数要放在
    	// http正文内，因此需要设为true
    	connection.setDoOutput(true);
    	connection.setDoInput(true);
    	connection.setRequestMethod("POST");
    	// Post 请求不能使用缓存
    	connection.setUseCaches(false);
    	// URLConnection.setInstanceFollowRedirects是成员函数，仅作用于当前函数
    	connection.setInstanceFollowRedirects(true);
    	// 配置本次连接的Content-type，配置为application/x-www-form-urlencoded的
    	// 意思是正文是urlencoded编码过的form参数，下面我们可以看到我们对正文内容使用URLEncoder.encode
    	// 进行编码
    	connection.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
    	// 连接，从postUrl.openConnection()至此的配置必须要在connect之前完成，
    	// 要注意的是connection.getOutputStream会隐含的进行connect。
    	connection.connect();
    	DataOutputStream out = new DataOutputStream(connection.getOutputStream());
    	out.flush();
    	out.close(); // flush and close
    	BufferedReader reader = new BufferedReader(new InputStreamReader(
    			connection.getInputStream()));
    	String line;
    	while ((line = reader.readLine()) != null) {
    		sb.append(line);
    	}
    	reader.close();
    	connection.disconnect();
    	return sb.toString();
    }
}

package com.wmp.api.common.base.controller;


import com.wmp.api.common.base.entity.QueryBase;
import com.wmp.api.common.base.service.GenericService;
import com.wmp.api.common.util.json.JsonHelper;

import org.apache.log4j.Logger;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: GenericController
 * @Description: TODO(Controller通用模板)
 * @author chenaonan
 * @date 2018年8月8日 上午10:38:00
 * @param <T>
 * @param <Q>
 */
public abstract class GenericController<T, Q extends QueryBase> {

	protected static Logger logger = Logger.getLogger(GenericController.class);

	// 抽象方法
	protected abstract GenericService<T, Q> getService();

	//Controller基路径
	protected String basePath;
	
    public final static String ERROR = "error";
    
	public final static String SUCCESS = "ok";

    private static final String PARAM_NAME = "params";

    /**
     * @Title: returnData
     * @Description: TODO(返回数据returnData)
     * @param @param response
     * @param @param data    设定文件
     * @return void    返回类型
     * @throws
     */
    protected final void returnData(HttpServletResponse response, Object data) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().write(data.toString());
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Title: returnJson
     * @Description: TODO(返回数据returnJSON)
     * @param @param response
     * @param @param data    设定文件
     * @return void    返回类型
     * @throws
     */
    protected final void returnJson(HttpServletResponse response, Object data) {
        String s = "";
        if (data instanceof Collection) {
            s = JSONArray.fromObject(data).toString();
        } else {
            s = JSONObject.fromObject(data).toString();
        }
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.getWriter().write(s);
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Title: params
     * @Description: TODO(params)
     * @param @param request
     * @param @return    设定文件
     * @return Map<String,String>    返回类型
     * @throws
     */
    protected final Map<String, String> params(HttpServletRequest request) {
        String json = request.getParameter(PARAM_NAME);
        logger.info("data => " + json);
        return JsonHelper.toMap(json);
    }
    
    /**
     * @Title: paramsJSON
     * @Description: TODO(paramsJSON)
     * @param @param request
     * @param @return    设定文件
     * @return Map<String,Object>    返回类型
     * @throws
     */
    protected final Map<String, Object> paramsJSON(HttpServletRequest request) {
    	String json = request.getParameter(PARAM_NAME);
    	logger.info("data => " + json);
    	return JsonHelper.toMapObject(json);
    }

	/**
	 * @Title: getPageBaseRoot
	 * @Description: TODO(抽象方法，获取页面基路径)
	 * @param @return
	 * @param @throws Exception    设定文件
	 * @return String    返回类型
	 * @throws
	 */
	protected String getPageBaseRoot() throws Exception {
		if (basePath == null) {
			basePath = this.getClass().getName();
			Pattern p = Pattern.compile(".[a-z|A-z]+.controller.[a-z|A-z]+Controller");
			Matcher m = p.matcher(basePath);
			if (m.find()) {
				basePath = m.group();
				basePath = basePath.substring(1, basePath.length() - 10);
				basePath = basePath.replace(".", "/");
				basePath = basePath.replace("/controller/", "/");
				basePath = basePath.substring(0, basePath.lastIndexOf("/") + 1)
						+ toFirstCharLowerCase(basePath.substring(basePath.lastIndexOf("/") + 1));
			} else {
				throw new Exception("获取页面基路径失败");
			}
		}
		return basePath;
	}


	/**
	 * @Title: toFirstCharLowerCase
	 * @Description: TODO(将首字母变小写)
	 * @param  str
	 * @param  设定文件
	 * @return String    返回类型
	 * @throws
	 */
	private static String toFirstCharLowerCase(String str) {
		char[] columnCharArr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < columnCharArr.length; i++) {
			char cur = columnCharArr[i];
			if (i == 0) {
				sb.append(Character.toLowerCase(cur));
			} else {
				sb.append(cur);
			}
		}
		return sb.toString();
	}

}

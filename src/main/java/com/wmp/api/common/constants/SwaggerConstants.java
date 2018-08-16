package com.wmp.api.common.constants;

/**
 * @ClassName: SwaggerConstants
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author chenaonan
 * @date 2018年8月8日 上午11:47:38
 */
public class SwaggerConstants {
	
    public static final String SWAGGER_URL = "http://localhost:8080/v2/api-docs";
    // 生成swagger2 api 文档的根目录
    public static final String DOC_ROOT_PATH = "target/file-temp";
    public static final String API_DOC_JSON = "api_doc_json.json";
    public static final String API_DOC_HTML = "api_doc_html.html";
    public static final String API_DOC_HTML_PATH = DOC_ROOT_PATH  + "/docs/html/generated/";
    public static final String API_DOC_HTML_FILE = DOC_ROOT_PATH + "/docs/html/generated/" + API_DOC_HTML;
    
}

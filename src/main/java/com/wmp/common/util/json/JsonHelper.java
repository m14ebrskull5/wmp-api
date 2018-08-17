package com.wmp.common.util.json;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.*;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ClassName: JsonHelper
 * @Description: TODO(json工具类)
 * @author chenaonan
 * @date 2018年8月8日 上午11:14:53
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class JsonHelper {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
   /**
    * @Title: json2Map
    * @Description: TODO(将JSON转换成Map,其中valueClz为Map中value的Class,keyArray为Map的key)
    * @param @param keyArray
    * @param @param json
    * @param @param valueClz
    * @param @return    设定文件
    * @return Map    返回类型
    * @throws
    */
	public static Map json2Map(Object[] keyArray, String json, Class valueClz) {
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map classMap = new HashMap();
        for (int i = 0; i < keyArray.length; i++) {
            classMap.put(keyArray[i], valueClz);
        }
        return (Map) JSONObject.toBean(jsonObject, Map.class, classMap);
    }
	
	/**
	 * @Title: toMap
	 * @Description: TODO(String 转换为Map)
	 * @param @param json
	 * @param @return    设定文件
	 * @return Map<String,String>    返回类型
	 * @throws
	 */
	public static Map<String, String> toMap(String json) {
        Map<String, String> data = Maps.newHashMap();
        JSONObject obj = JSONObject.fromObject(json);
        obj.keys().forEachRemaining((k) -> data.put(k.toString(), obj.getString(k.toString())));
        return data;
    }

	/**
	 * @Title: toMapObject
	 * @Description: TODO(String 转 MapObject)
	 * @param @param json
	 * @param @return    设定文件
	 * @return Map<String,Object>    返回类型
	 * @throws
	 */
    public static Map<String,Object> toMapObject(String json){
        Map<String, Object> data = Maps.newHashMap();
        JSONObject obj = JSONObject.fromObject(json);
        obj.keys().forEachRemaining((k) -> data.put(k.toString(), obj.get(k.toString())));
        return data;
    }
    
    /**
     * @Title: toJson
     * @Description: TODO(对象转换为JSON)
     * @param @param data
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String toJson(Object data) {
        String s = "";
        if (data instanceof Collection) {
            s = JSONArray.fromObject(data).toString();
        } else {
            s = JSONObject.fromObject(data).toString();
        }
        return s;
    }

    /**
     * @Title: toJsonObject
     * @Description: TODO(对象转换为JsonObject)
     * @param @param data
     * @param @return    设定文件
     * @return JSONObject    返回类型
     * @throws
     */
    public static JSONObject toJsonObject(Object data) {
        return JSONObject.fromObject(data);
    }

    /**
     * @Title: toMap
     * @Description: TODO(Json对象转换为Map)
     * @param @param json
     * @param @return    设定文件
     * @return Map<String,String>    返回类型
     * @throws
     */
    public static Map<String, String> toMap(JSONObject json) {
        Iterator keys = json.keys();
        Map<String, String> map = Maps.newHashMap();
        while (keys.hasNext()) {
            String key = keys.next().toString();
            map.put(key, json.getString(key));
        }
        return map;
    }

    /**
     * @Title: toList
     * @Description: TODO(String 转List)
     * @param @param data
     * @param @return    设定文件
     * @return List<Map<String,String>>    返回类型
     * @throws
     */
    public static List<Map<String, String>> toList(String data) {
        JSONArray jsonArray = JSONArray.fromObject(data);
        List<Map<String, String>> list = Lists.newArrayList();
        for (int j = 0; j < jsonArray.size(); j++) {
            list.add(toMap(jsonArray.getJSONObject(j)));
        }
        return list;
    }

    /**
     * @Title: toArray
     * @Description: TODO(String toArray)
     * @param @param data
     * @param @return    设定文件
     * @return List<String>    返回类型
     * @throws
     */
    public static List<String> toArray(String data) {
        JSONArray jsonArray = JSONArray.fromObject(data);
        List<String> list = Lists.newArrayList();
        for (int j = 0; j < jsonArray.size(); j++) {
            list.add(jsonArray.getString(j));
        }
        return list;
    }
    
    /**
     * @Title: toList
     * @Description: TODO(将对象转换为传入类型的List)
     * @param @param object
     * @param @param objectClass
     * @param @return    设定文件
     * @return Collection<T>    返回类型
     * @throws
     */
    public static <T> Collection<T> toList(Object object, Class<T> objectClass) {
        JSONArray jsonArray = JSONArray.fromObject(object);
        return JSONArray.toCollection(jsonArray, objectClass);
    }

    /**
     * @Title: object2json
     * @Description: TODO(实现将一个object对象转换为json的string字符串)
     * @param @param obj
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String object2json(Object obj) {
        StringBuilder json = new StringBuilder();
        if (obj == null) {
            json.append("\"\"");
        } else if (obj instanceof String || obj instanceof BigDecimal
                || obj instanceof BigInteger) {
            json.append("\"").append(string2json(obj.toString())).append("\"");
        } else if (obj instanceof Boolean) {
            json.append(Boolean.valueOf(obj.toString()));
        } else if (obj instanceof Integer || obj instanceof Float
                || obj instanceof Short || obj instanceof Double
                || obj instanceof Long || obj instanceof Byte) {
            json.append(obj.toString());
        } else if (obj instanceof Date || obj instanceof java.sql.Date) {
            json.append("\"").append(sdf.format(obj)).append("\"");
        } else if (obj instanceof Object[]) {
            json.append(array2json((Object[]) obj));
        } else if (obj instanceof List) {
            json.append(list2json((List<?>) obj));
        } else if (obj instanceof Map) {
            json.append(map2json((Map<?, ?>) obj));
        } else if (obj instanceof Set) {
            json.append(set2json((Set<?>) obj));
        } else {
            json.append(bean2json(obj));
        }
        return json.toString();
    }

    /**
     * @Title: list2json
     * @Description: TODO(list to json)
     * @param @param list
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String list2json(List<?> list) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * @Title: array2json
     * @Description: TODO(array to json)
     * @param @param array
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String array2json(Object[] array) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (array != null && array.length > 0) {
            for (Object obj : array) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * @Title: map2json
     * @Description: TODO(map to json)
     * @param @param map
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String map2json(Map<?, ?> map) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        if (map != null && map.size() > 0) {
            for (Object key : map.keySet()) {
                json.append(object2json(key));
                json.append(":");
                json.append(object2json(map.get(key)));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }

    /**
     * @Title: set2json
     * @Description: TODO(set to json)
     * @param @param set
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String set2json(Set<?> set) {
        StringBuilder json = new StringBuilder();
        json.append("[");
        if (set != null && set.size() > 0) {
            for (Object obj : set) {
                json.append(object2json(obj));
                json.append(",");
            }
            json.setCharAt(json.length() - 1, ']');
        } else {
            json.append("]");
        }
        return json.toString();
    }

    /**
     * @Title: string2json
     * @Description: TODO(string to json)
     * @param @param s
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String string2json(String s) {
        if (s == null)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                case '\b':
                    sb.append("\\b");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '/':
                    sb.append("\\/");
                    break;
                default:
                    if (ch >= '\u0000' && ch <= '\u001F') {
                        String ss = Integer.toHexString(ch);
                        sb.append("\\u");
                        for (int k = 0; k < 4 - ss.length(); k++) {
                            sb.append('0');
                        }
                        sb.append(ss.toUpperCase());
                    } else {
                        sb.append(ch);
                    }
            }
        }
        return sb.toString();
    }

    /**
     * @Title: bean2json
     * @Description: TODO(bean to json)
     * @param @param bean
     * @param @return    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String bean2json(Object bean) {
        StringBuilder json = new StringBuilder();
        json.append("{");
        PropertyDescriptor[] props = null;
        try {
            props = Introspector.getBeanInfo(bean.getClass(), Object.class)
                    .getPropertyDescriptors();
        } catch (IntrospectionException e) {
        }
        if (props != null) {
            for (int i = 0; i < props.length; i++) {
                try {
                    String name = object2json(props[i].getName());
                    String value = object2json(props[i].getReadMethod().invoke(
                            bean));
                    json.append(name);
                    json.append(":");
                    json.append(value);
                    json.append(",");
                } catch (Throwable e) {
                }
            }
            json.setCharAt(json.length() - 1, '}');
        } else {
            json.append("}");
        }
        return json.toString();
    }


}

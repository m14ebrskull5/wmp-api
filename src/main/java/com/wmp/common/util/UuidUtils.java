package com.wmp.common.util;

import java.util.UUID;
/**
 * @ClassName: UuidUtils
 * @Description: TODO(UUID 工具类)
 * @author chenaonan
 * @date 2018年8月8日 上午11:50:08
 */
public class UuidUtils {

    
    /**  
     * 生成32位编码  
     * @return string  
     */    
    public static String getUUID(){    
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");    
        return uuid;    
    }
    
}

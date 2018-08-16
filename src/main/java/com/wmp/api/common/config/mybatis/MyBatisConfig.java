package com.wmp.api.common.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName: MyBatisConfig
 * @Description: TODO(开启mybatis的支持)
 * @author chenaonan
 * @date 2018年8月8日 上午11:52:33
 */
@Configuration
@MapperScan({"com.wmp.api.*.*.dao", "com.wmp.api.*.dao"})
public class MyBatisConfig {

}

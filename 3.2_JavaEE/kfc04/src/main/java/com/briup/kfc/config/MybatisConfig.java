package com.briup.kfc.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.briup.kfc.mapper")
public class MybatisConfig {

}

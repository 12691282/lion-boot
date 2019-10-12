package com.alpha.core.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.alpha.module.*.mapper")
public class MybatisConfiguration {


}

package com.cloudwalk.config;


import com.alibaba.druid.pool.xa.DruidXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * 数据库连接工厂对象
 *
 * @author yanggang
 * @version 1.0
 * @date 2019-11-11
 * @since jdk 1.8
 */
@Configuration
@MapperScan(basePackages = "com.cloudwalk.mapper", sqlSessionTemplateRef = "oneDataApiSqlSessionTemplate")
public class OneDataApi {

    @Bean(name = "oneDataApiDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource oneDataApiDataSource() throws SQLException {
        DruidXADataSource dataSource = new DruidXADataSource();
        return dataSource;
    }

    @Bean(name = "oneDataApiSqlSessionFactory")
    public SqlSessionFactory oneDataApiSqlSessionFactory(@Qualifier("oneDataApiDataSource")
                                                                 DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            bean.setMapperLocations(resolver.getResources("classpath:com/cloudwalk/mapper/*.xml"));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return bean.getObject();
    }

    @Bean(name = "oneDataApiSqlSessionTemplate")
    public SqlSessionTemplate oneDataApiSqlSessionTemplate(@Qualifier(
            "oneDataApiSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}


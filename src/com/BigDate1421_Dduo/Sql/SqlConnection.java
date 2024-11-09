package com.BigDate1421_Dduo.Sql;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class SqlConnection {
    public static Connection getConnection() throws Exception {

        //加载配置文件
        Properties prop=new Properties();
        prop.load(new FileInputStream("src/druid.properties"));

        //获取连接池对象
        DataSource dataSource=DruidDataSourceFactory.createDataSource(prop);

        //获取数据库连接 Connection
        Connection connection=dataSource.getConnection();

        return connection;

    }
}
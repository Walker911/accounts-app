# SpringBoot+JPA+React学习demo
## 技术
- spring boot
- jpa
- React
- druid
## 数据库密码加密
使用druid数据库连接池提过的密码加密方法，对数据库的密码进行加密，参考[druid](https://github.com/alibaba/druid/wiki/%E5%A6%82%E4%BD%95%E5%9C%A8Spring-Boot%E4%B8%AD%E9%85%8D%E7%BD%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E5%AF%86%E7%A0%81%E5%8A%A0%E5%AF%86%EF%BC%9F)和[spring boot](https://github.com/alibaba/druid/wiki/%E5%A6%82%E4%BD%95%E5%9C%A8Spring-Boot%E4%B8%AD%E9%85%8D%E7%BD%AE%E6%95%B0%E6%8D%AE%E5%BA%93%E5%AF%86%E7%A0%81%E5%8A%A0%E5%AF%86%EF%BC%9F)。

### 加密密码

执行下面的命令对密码进行加密：

```shell
java -cp druid-1.0.16.jar com.alibaba.druid.filter.config.ConfigTools you_password
# example: datasource password: 123456
java -cp druid-1.0.16.jar com.alibaba.druid.filter.config.ConfigTools 123456
```

输出：

```shell
privateKey:MIIBVgIBADANBgkqhkiG9w0BAQEFAASCAUAwggE8AgEAAkEAtiJZ47iLMIuoEpab0cStHyxEvRyDl+bpSF4Ht8bLdJZhKtXVBPryAXeZTlGpK2hvEvw22VfWG9rBe1GCTsUMqwIDAQABAkEAstUlx8fiu0bVP3MsChsAFXSlBb6ioxrygcD5+QOzr4Nu91Ost280SUy+Cc+rxyiRupNQFZTd7uikEmfEWlv74QIhAP0smJnHnaE8qtW+5po2ZT/d5JKgWHmG67oowXB1sPPbAiEAuCrFEQaFGH9h3ZBwE6LhAdmjjk58CioCrneElNI9C3ECIQC1C/ksr1UIAqxgIh4iVZfeLj3QpR3f+h4EiDScyWz7VQIhALJd8gkASI2mabF+P541BTmWgRrFlsr9TyWMaeL9D9RxAiAtKFNhYeR3aavlH+w3l3UaE1fdnzVniU2VT1BQsMSq2w==
publicKey:MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBALYiWeO4izCLqBKWm9HErR8sRL0cg5fm6UheB7fGy3SWYSrV1QT68gF3mU5RqStobxL8NtlX1hvawXtRgk7FDKsCAwEAAQ==
password:PwN36efao+XGM3nruTigtQ3M88sUOa5WjURALTjPBIFXvdfhJ1XSgN620Rb+FzpD8awmx1y0kmU5S52GWymd4w==
```

Spring Boot中配置如下：

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/test
spring.datasource.username=root
# 加密后的密码（原密码 123456）
spring.datasource.password=PwN36efao+XGM3nruTigtQ3M88sUOa5WjURALTjPBIFXvdfhJ1XSgN620Rb+FzpD8awmx1y0kmU5S52GWymd4w==
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
# public key
publickey=MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBAIiwHpFrDijV+GzwRTzWJk8D3j3jFfhsMFJ/7k1NTvBuLgL+TdIHgaMNOIEjHpXzuvX38J3FtOK8hLrySncVGOMCAwEAAQ==
# 配置 connection-properties，启用加密，配置公钥。
spring.datasource.druid.connection-roperties=config.decrypt=true;config.decrypt.key=${publickey}
# 启动ConfigFilter
spring.datasource.druid.filter.config.enabled=true
```

## 启动
启动`AccountsApplication.java`，然后访问`http://localhost:8080`
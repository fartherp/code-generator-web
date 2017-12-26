# 自动生成代码页面

## 集成generator-code-integration
```
可以自定义生成符合自己风格代码结构，配合使用下面地址
https://github.com/fartherp/generator-code-integration.git

pom.xml中引入自定义的包，即可生成自定义代码
<dependency>
    <groupId>com.github.fartherp</groupId>
    <artifactId>generatorcode-framework</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

## 测试SQL脚本
```
changelog里面的code_test.sql
```

## 页面配置
```
类路径: com.github.fartherp
项目名: code
项  目: framework 
用户名: root
密  码: root
U R L: jdbc:mysql://localhost:3306/code_test
```

## pom.xml集成tomcat插件,直接使用插件启动
## 访问主页 http://localhost:8081/code
# 代理商平台

----

## 自动生成基础代码工具
```
生成符合项目目录的文件，包括pojo，xml, dao，manager
简化dao，manager中增删改查功能，
使项目结构清晰，业务逻辑与公用逻辑分开处理，避免重复的工作量和底层出错问题
```

### 地址
```
http://192.168.9.31:15001/code/
```

### 页面配置
```
类路径: com.juzix.dams
项目名: broker
项  目: plt
用户名: exchange
密  码: exchange
U R L: jdbc:mysql://192.168.9.86:3306/broker
```

### idea插件
1. 插件搜索: Generator Code Plugin 
2. 使用 File->Settings->Tools->Generator Code Plugin
3. 填写“页面配置”信息，点击查询表名，选择需要生成的表名
4. 右键点击项目的根目录，左键点击Generator Code
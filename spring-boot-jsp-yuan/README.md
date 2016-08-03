<h1>spring boot 自身集成 了spring 和spring-mvc</h1>
<h2>spring 官方并不推荐使用jsp 视图 推荐使用模板</h2>
<h3>要使用jsp :</h3>

<i>1.</i>在resources 中创建 META-INF/resources/WEB-INF/<br>

<i>2.</i>在  main下创建传统的jsp 目录  main/webapp/WEB-INF/<br>

并且在application.properties 中进行spring-mvc 视图的配置,在pom中添加 tomcat-embed-jasper 用于解析jsp<br>

spring-mvc 会先去 2 目录下找jsp 然后在去 1 的目录下找jsp<br>

resources 目录下的templates 下放置模板 spring-boot 会自动去这儿加载模板 (同时要在pom 中添加对模板进行解析的jar)<br>

<em>如果用jsp 作为视图则只能将项目打包成war包</em>



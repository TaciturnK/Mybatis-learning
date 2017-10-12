# Mybatis-learning
Mybatis学习系列代码

# 摘要
软件项目最重要的是和数据库打交道，刚开始接触软件开发的时候，觉得最难的就是与数据库连接，操作数据库这块了；后来慢慢学习，学会了使用JDBC连接数据库，对数据库进行操作；但是JDBC每次操作数据库都要写相同代码的比较麻烦，于是就慢慢学习封装JDBC,也使用过dbUtils开源框架，Spring的JdbcTesplate等，但是这些换是需要将Sql写死在代码里面，后期优化Sql时比较麻烦，于是后来接触到了Hibernate，这种完全不用编写任何Sql语句，可以使用面相对象的过程去编写Sql，但是它有一个不好的地方就是不利于Sql优化，复杂的Sql语句就无能为力了，这样就出现了MyBatis。本文就记录了学习Maybatis的一系列过程。

# Mybatis介绍

[官网介绍](http://www.mybatis.org/mybatis-3/zh/index.html)：
MyBatis 是一款优秀的持久层框架，它支持定制化 SQL、存储过程以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取结果集。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 POJOs(Plain Old Java Objects,普通的 Java对象)映射成数据库中的记录。

JDBC->dbutils(自动封装)->MyBatis->Hibernate

# 入门

## 安装

要使用 MyBatis， 只需将 [mybatis-x.x.x.jar](http://mvnrepository.com/artifact/org.mybatis/mybatis) 文件置于 classpath 中即可。
如果使用 Maven 来构建项目，则需将下面的 dependency 代码置于 pom.xml 文件中：

```
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.4</version>
</dependency>

```

# MyBatis的第一个程序
## 添加jar包

【mybatis】	mybatis-3.1.1.jar

【MYSQL驱动包】mysql-connector-java-5.1.7-bin.jar

## 建库+表(测试数据库)

```sql
create database mybatis;
use mybatis;
CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
INSERT INTO users(NAME, age) VALUES('Tom', 12);
INSERT INTO users(NAME, age) VALUES('Jack', 11);

```

## 添加Mybatis的配置文件conf.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
	<environments default="development">
		<environment id="development">
			<transactionManager type="JDBC" />
			<dataSource type="POOLED">
				<property name="driver" value="com.mysql.jdbc.Driver" />
				<property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
				<property name="username" value="root" />
				<property name="password" value="root" />
			</dataSource>
		</environment>
	</environments>
</configuration>

```
## 定义表所对应的实体类

```
public class User {
	private int id;
	private String name;
	private int age;
    //get,set方法
}

```

## 定义操作users表的sql映射文件userMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd"> 
<mapper namespace="com.atguigu.mybatis_test.test1.userMapper"> 
	<select id="getUser" parameterType="int" 
		resultType="com.atguigu.mybatis_test.test1.User">
		select * from users where id=#{id}
	</select>
</mapper>

```

## 在conf.xml文件中注册userMapper.xml文件

```xml
<mappers>
	<mapper resource="com/atguigu/mybatis_test/test1/userMapper.xml"/>
</mappers>

```

## 编写测试代码：执行定义的select语句

```java
public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml"; 
		//加载mybatis的配置文件（它也加载关联的映射文件）
		Reader reader = Resources.getResourceAsReader(resource); 
		//构建sqlSession的工厂
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建能执行映射文件中sql的sqlSession
		SqlSession session = sessionFactory.openSession();
		//映射sql的标识字符串
		String statement = "com.atguigu.mybatis.bean.userMapper"+".selectUser";
		//执行查询返回一个唯一user对象的sql
		User user = session.selectOne(statement, 1);
		System.out.println(user);
	}
}

```

## 项目结构


[项目代码下载](https://github.com/TaciturnK/Mybatis-learning)

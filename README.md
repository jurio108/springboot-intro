# spring boot on visual studio code #

==================================================================================
# vscode settings

# java, maven
  java, maven은 따로 다운로드 받아서 환경변수 설정 후 사용

# dependency
  Spring Boot DevTools
  Lombok
  Spring Web
  Spring Data JPA
  MySQL Driver
  Spring Security

# settings.json
  "java.jdt.ls.java.home": "C:\\Program Files\\BellSoft\\LibericaJDK-17",
  "maven.executable.path": "C:\\apache-maven-3.9.3\\bin\\mvn.cmd",
  "java.configuration.maven.userSettings": "C:\\apache-maven-3.9.3\\maven\\settings.xml",
  "vscode-spring-boot.rewrite.reconcile-prompt": false,
  "terminal.integrated.defaultProfile.windows": "Command Prompt",

# application.properties
  properties 파일로 하든 yml 파일로 변경하든 알아서 세팅

# readme.md
  처음에 없으므로 생성

# git
  .git이 없으므로 git init 부터 시작


==================================================================================
# DB 세팅 application.properties 기준

# MySQL 설정
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# DB Source URL 설정
spring.datasource.url=jdbc:mysql://localhost:3306/blog?useSSL=false&useUnicode=true&serverTimezone=Asia/Seoul

# DB 사용자 이름 설정
spring.datasource.username=root

# DB 사용자이름에 대한 암호 설정
spring.datasource.password=tiger

# true 설정 시, JPA 쿼리문 확인 가능
spring.jpa.show-sql=true

# DDL(create, alter, drop) 정의 시, DB의 고유 기능을 사용할 수 있음.
spring.jpa.hibernate.ddl-auto=update 

# JPA의 구현체인 Hibernate가 동작하면서, 발생한 SQL의 가독성을 높여줌.
spring.jpa.properties.hibernate.format_sql=true


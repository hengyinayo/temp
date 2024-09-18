# open jdk 21 버전의 환경을 구성
FROM eclipse-temurin:21-jdk-alpine

# build 시점에 JAR_FILE이라는 변수 명에 build/libs/*.jar 선언
# build/libs - gradle로 빌드했을 때 jar 파일이 생성되는 경로
ARG JAR_FILE=build/libs/*.jar

# JAR_FILE을 app.jar로 복사
COPY ${JAR_FILE} app.jar

# 8080 포트 노출
EXPOSE 8080

# 운영 및 개발에서 사용되는 환경 설정을 분리 (prod 환경 사용)
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app.jar"]
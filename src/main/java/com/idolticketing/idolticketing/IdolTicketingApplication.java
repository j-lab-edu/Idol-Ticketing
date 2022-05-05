package com.idolticketing.idolticketing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
@SpringBootApplication: 스프링 부트의 가장 기본적인 설정을 선언해 줍니다.
자동 구성, 구성 요소 스캔을 사용

@EnableAutoConfiguration:
위 어노테이션이 각 패키지들을 순회해서 META-INF속에 spring.facotries라는 파일 속에
org.springframework.boot.autoconfigure.EnableAutoConfiguration 키 값에 있는 설정을 실행 시켜줍니다.

META-INF 폴더는 manifest 파일을 담는 폴더로 활용되며 manifest 파일이란 일종의 jar 파일의 사용매뉴얼이나 스펙을 가지고 있는 사용설명서와 비슷한 개념이라고 한다.
예를들면, 실행되는 main 함수가 어떤 class에 위치하고 있는지, 프로그램의 보안정책이 어떻게 되는지, sealing 정보 등을 담고 있다고 한다.


: Spring Boot의 자동 구성 메커니즘을 활성화합니다.
@ComponentScan: @Component애플리케이션이 있는 패키지에서 스캔을 활성화 합니다

 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class IdolTicketingApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdolTicketingApplication.class, args);
	}

}

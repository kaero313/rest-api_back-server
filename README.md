<h1>rest api와 back/front end 서버 분리</h1>

<h3>1. rest api란?</h3>

![image](https://github.com/user-attachments/assets/483a32a5-8e92-4de5-80ed-2ed8f7b829fc)
> REST(Representational State Transfer) 아키텍쳐 스타일의 설계 원칙을 기반으로 만든 API(Application Programming Interface)

<br/>

<h3>2. rest api의 특징</h4>

- http 요청을 통하여 리소스 내에서 crud를 수행하는 방법
- client가 요청하면 server가 응답하는 역할이 명확하게 분리된 구조
- 자원은 uri를 통하여 명시한다
- method를 통하여 crud를 정의함
  - get    > select
  - post   > insert
  - put    > update
  - delete > delete
- json, xml, text등 다양한 데이터의 형태 지정 가능

<br/>

<h3>3. rest api 설계 및 문서화</h3>

![image](https://github.com/user-attachments/assets/5e0e057d-3de1-4231-a80d-27df4397dee4)
> 상태 코드 정의

<br/>

![image](https://github.com/user-attachments/assets/488ea750-c365-442c-b8e1-f4c26704d283)
> 회원 조회(로그인) /api/member GET

<br/>

![image](https://github.com/user-attachments/assets/f725b7bf-a996-47bb-a9bc-e639753dd58f)
> 회원 가입 /api/member POST

<br/>

![image](https://github.com/user-attachments/assets/16bdf6a6-6808-4a2f-b97e-0512f370e9f2)
> 회원 수정 /api/member PUT

<br/>

![image](https://github.com/user-attachments/assets/a487d223-d3e5-44c0-b75c-9ced615e1cb5)
> 회원 탈퇴 /api/member DELETE

<br/>

<h3>4. rest api 테스트 수행</h3>

<h4>1. Postman을 사용하여 테스트 진행</h4>
- 간단한 회원 조회/가입/수정/탈퇴 절차

<br/>

<h4>1. 회원 조회</h4>

![image](https://github.com/user-attachments/assets/44eee087-6d30-429c-a13e-cbd7ba7539f9)
> [request] 회원 아이디/패스워드　　　[response] 조회 결과 불일치/일치

<br/>

<h4>2. 회원 가입</h4>

![image](https://github.com/user-attachments/assets/90fd3ee8-3b44-4410-8971-bff673571eb1)
> [request] 회원 아이디/패스워드/이름　[response] 가입 결과 불가/완료

<br/>

<h4>3. 회원 수정</h4>

![image](https://github.com/user-attachments/assets/7e75e6c1-9018-41e0-9dec-6b7d25ebfe5d)
> [request] 회원 아이디/패스워드/이름　[response] 수정 결과 불가/완료

<br/>

<h4>4. 회원 탈퇴</h4>

![image](https://github.com/user-attachments/assets/a84bbbdc-a397-4b77-a6e3-2a305a5d1d20)
> [request] 회원 아이디/패스워드　　　[response] 탈퇴 결과 불가/완료

<br/>

<h3>5. back/front end 서버 분리</h3>

![image](https://github.com/user-attachments/assets/0300bfa6-1621-45ce-86dd-25573797eaa5)
> front(client) / back(server) 분리 아키텍쳐

<br/>

<h3>6. 서버 분리의 특징</h3>

-  백엔드는 데이터 처리 및 비즈니스 로직을 처리하며, 프론트엔드는 사용자와 관련된 처리를 담당하도록 역할을 명확히 나눔
-  한 서버에 가해지는 부하량이 적어지니 자원최적화가 용이함
-  back/front가 1:1이 아닌 n:1구조가 가능해짐(순수한 rest api서버로써 존재하면 다른 플랫폼의 front서버가 사용하도록 확장할 수 있음)
-  각자의 영역에서 필요한 부분만을 담당하므로, 보안 취약점을 줄일 수 있음
 
> 개발 과정의 유연성, 확장성, 유지보수성을 개선할 수 있으며 개발 후에는 보안성 등을 향상하는데 도움이 됨

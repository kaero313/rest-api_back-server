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



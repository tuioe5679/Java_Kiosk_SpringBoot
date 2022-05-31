# Java_Kiosk_SpringBoot
자바 기말고사 대체 프로젝트 키오스 자바 기반 서버입니다 

### 데이터베이스 이름: Kiosk

- Table **members**
  - id : 아이디
  - pwd : 비밀번호
  - name : 회원 이름
  - totalmoney : 현재 금액
- Table **product**
  - id : 인덱스 
  - name : 상품 이름
  - price : 상품 가격 
  - image : 이미지 파일 (jpg,png)
- Table **orders**
  - ordernum : 주문번호
  - name : 주문상품 이름
  - price : 주문상품가격 
  - count : 주문상품 개수 

### 기능 (API)
- members (get,put,delete)
- product (get,put,delete)
- orders  (get,put,delete) 

### API 호출 
웹 브라우저 주소창에 `http://localhost:8080/product/all` 입력 <br>
http://localhost:8080/ : 로컬호스트 서버 주소 (자신의 ip에서만 접속 가능) <br>
- 로컬 호스트는 Spring 서버를 실행해야 사용 가능 <br>

/product/all: API 이름 (이름에 따라서 API를 실행) 

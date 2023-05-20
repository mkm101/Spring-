# 인프런 스프링 핵심원리 - 기본편 #1 (05.17 Update)
# 1. <회원 도메인 설계>

## 비즈니스 요구사항과 설계
회원
 - 회원을 가입하고 조회할 수 있다.
 - 회원은 일반과 VIP 두가지 등급이 있다.
 - 회원 데이터는 자체 DB를 구축할 수 있고, 외부 시스템과 연동할 수 있다.(미확정)


주문과 할인정책
 - 회원은 상품을 주문할 수 있다.
 - 할인정책은 모든 VIP는 1000원을 할인 해주는 고정 금액 할인을 적용해달라. (나중에 변경될 수 있다.)
 - 할인 정책은 변경 가능성이 높다. 오픈 직전까지 고민을 미루고싶다는 생각 --

__요구사항에 따르면, 회원 데이터 및 할인 정책 같은 부분은 지금 당장 결정하기 어려운 부분이다. 더군다나, 이런 정책이 결정될 때까지 개발을 기다릴 수 없기때문에, 객체 지향 설계 원칙에 따라 구현해야한다.

![image](https://github.com/mkm101/core/assets/116955730/a900e5fc-e1b8-4ef7-a5c3-659632e4c63b)


인터페이스를 만들고, 구현체를 언제든지 갈아끼울 수 있도록 설계해야한다.__

# 2. <주문과 할인 도메인 설계>
![image](https://github.com/mkm101/Spring-/assets/116955730/2d1cb4a6-4350-4513-a524-af6ae8946ec7)
![image](https://github.com/mkm101/Spring-/assets/116955730/dfb69542-6687-40c2-9669-2fba99e21de3)
![image](https://github.com/mkm101/Spring-/assets/116955730/257cb83d-70cf-4c0a-8950-4ace08d80e8b)


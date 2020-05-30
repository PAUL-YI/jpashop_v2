# jpashpop_v2

강좌 내용

엔티티는 가급적 setter 를 사용하지 말아라
-> 유지보수가 너무 어려워진다.

모든연관관계는 지연로딩으로 설정해라!
-> 수많은 장애를 극복할 수 있다!!!
즉시(EAGER)은 예측이 어렵고, 어떤 sql이 실행될 지 추적이 어렵다.
특히, jpql 사용시, n+1 문제가 발생할 확률이 크다.

실무에서 모든 관계는 LAZY 로 설정해야 한다.

@ManyToOne(fetch = FetchType.LAZY)<- 이거 꼭 해야 한다. 안하면 난리난다 진짜.
oneToOne 도 마찬가지
static import 단축키 (option+enter)

대안] 연관된 엔티티를 함께 db 에서 조회해야 하면, fetch join 또는 엔티티 그래프를 사용한다.

컬렉은 필드에서 초기화 하자. 
하이버네이트 문서에서 베스트 프랙티스는 필드에서 초기화 하는 것이다. 
null 문제에서 안전하다. 

하이버네이트는 엔티티를 영속화 할 때, 컬랙션을 감싸서 하이버네이트가 제공하는 내장 컬렉션으로 변경한 다. 만약 getOrders() 처럼 임의의 메서드에서 컬력션을 잘못 생성하면 하이버네이트 내부 메커니즘에 문 제가 발생할 수 있다. 따라서 필드레벨에서 생성하는 것이 가장 안전하고, 코드도 간결하다.


Member member = new Member();<br>
System.out.println(member.getOrders().getClass());<br>
em.persist(team);<br>
System.out.println(member.getOrders().getClass());<br>

//출력 결과

class java.util.ArrayList<br>
class org.hibernate.collection.internal.PersistentBag

칼럼명은 spring physical naming strategy 를 따른다. 

cascade(<- 학습 필요)

원래
persist(orderItemA)<br>
persist(orderItemB)<br>
persist(orderItemC)<br>
persist(order)<br>

cacade = cacadeType.ALL<br>
persist(order)<br>

연관관계 메소드


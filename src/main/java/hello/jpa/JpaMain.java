package hello.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        //JPA의 모든 변경은 반드시! 트랜잭션 안에서 실행.
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            // insert 즉 영속성 컨텍스트에 1차캐시에 등록
            //영속성 컨텍스트의 지연 sql 저장소에 쿼리를 만들어 저장해놓는다.
            Member member = new Member();
            member.setId(32);
            member.setName("member32");

            em.persist(member);


            //변동감지
            Member findMember = em.find(Member.class,200L);
            findMember.setName("HODFJDO");



            // flush와 commit 같이한다.
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close(); // 꼭 EntitiyManger 닫아줘야 한다.
        }
        emf.close();


    }
}

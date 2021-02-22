package hello.jpa;

import JoinStrategy.Book;
import JoinStrategy.Item;
import JoinStrategy.Movie;

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
            //movie 객체를 주입.
            Movie movie = new Movie();
            movie.setActor("바람");
            movie.setDirector("대머리남자");
            movie.setName("헤븐즈필");
            movie.setPrice(10000);

            em.persist(movie);


            Book book = new Book();
            book.setAuthor("택민");
            book.setIsbn("IF42-3242-3F23");
            book.setPrice(12000);
            book.setName("배고픈태크");
            em.persist(book);
            Item findBook = em.find(Book.class, 2L);
            System.out.printf("ItemName: %s\n", findBook.getName());


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close(); // 꼭 EntitiyManger 닫아줘야 한다.
        }
        emf.close();


    }
}

package hello.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
// jpa가 보고 관리할 수 있도록 어노테이션 달아줘야 한다.
@Entity
public class Member {

    //pk는 알려줘야 한다!
    @Id
    private Long id;

    private String name;

    public Member() {

    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

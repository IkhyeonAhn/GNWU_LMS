package hello.hellospring.repository;

import hello.hellospring.domain.member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemorymemberRepositoryTests {
    MemorymemberRepository repository = new MemorymemberRepository();

    @Test
    public void save(){
        member member = new member();
        member.setName("spring");

        repository.save(member);

        member result = repository.findByid(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void FindByName(){
        member member1 = new member();
        member1.setName("ex1");
        repository.save(member1);

        member member2 = new member();
        member2.setName("ex2");
        repository.save(member2);

        member result = repository.findByname(member1.getName()).get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        member member1 = new member();
        member1.setName("ex1");
        repository.save(member1);

        member member2 = new member();
        member2.setName("ex2");
        repository.save(member2);
    }
}

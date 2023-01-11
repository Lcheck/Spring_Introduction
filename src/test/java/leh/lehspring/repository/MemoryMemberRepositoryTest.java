package leh.lehspring.repository;

import leh.lehspring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {


    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){

    repository.clearStore();

    }
    @Test
    public void save(){

        Member member = new Member(); //멤버 인스턴스 생성
        member.setName("spring"); //멤버 이름 설정

        repository.save(member); // repository의 save메서드에 member담아 실행

        Member result = repository.findById(member.getId()).get();
        //findById를 통해 id로 멤버를 검색한다. 해당 메서드의 반환값은 Optional객체이므로 get메서드를 사용하여
        //멤버 객체를 반환한다.

        Assertions.assertEquals(member,result);
    }

    @Test
        public void findByName(){

            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);
            //멤버 1 등록

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);
            //멤버 2 등록

            Member result = repository.findByName("spring2").get();
            //findByName사용하여 이름 검색
            Assertions.assertEquals(member2,result);
            //위 검색이 유효한지 확인
        }

        @Test
    public void findAll(){

            Member member1 = new Member();
            member1.setName("spring1");
            repository.save(member1);
            //멤버 1 등록

            Member member2 = new Member();
            member2.setName("spring2");
            repository.save(member2);
            //멤버 2 등록

            List<Member> result=repository.findAll();
            //모든 멤버 반환

            Assertions.assertEquals(result.size(),2);
            //멤버 반환수 검증

        }
}

package leh.lehspring.repository;

import leh.lehspring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    //멤버를 등록하는 메서드
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    //id, name으로 회원을 조회하는 메서드
    //Optional은 null값을 처리해주는 객체인데 추후 공부해보자

    List<Member> findAll();
    //저장된 모든 회원리스트 반환
}

package leh.lehspring.repository;

import leh.lehspring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    //아이디, 멤버 쌍을 저장할 Map 객체
    private static long sequence =0L; //멤버 아이디 부여용
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(),member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
        //store.get(id)의 결과가 null일 것을 대비해 Optional객체로 감싸줌
                ;
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //Rambda를 사용한 코드이다. 모든 멤버를 반한 한뒤에 filter메소드를 통해 멤버를 순회하며
        //해당 멤버의 이름이 인자의 이름과 같은지 비교 후 일치하는 멤버를 반환한다. 반환은 null일 수 있기에
        //Optional 객체로 반환된다.
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //store의 값 목록을 ArrayList에 담아 반환한다.

    }
}

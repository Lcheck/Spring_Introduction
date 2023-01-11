package leh.lehspring.service;

import leh.lehspring.domain.Member;
import leh.lehspring.repository.MemberRepository;
import leh.lehspring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //인터페이스와 구현체


    //회원가입
    public Long join(Member member) {

        //멤버 중복 확인 메서드
        validateDuplicateMember(member);

        memberRepository.save(member); //멤버 등록

        return member.getId(); //등록한 멤버 아이디 반환

    }

    private void validateDuplicateMember(Member member){

        Optional<Member> result = memberRepository.findByName(member.getName())
                //기존 레포지토리에서 멤버아이디로 멤버가 이미 존재하는지 검색
                .ifPresent(m->{ throw new IllegalStateException("이미 존재하는 회원입니다.")});
        //만일 존재하여 result에 멤버객체가 있으면 예외를 발생시킴


    }

    //전체 회원 조회

    public List<Member> findMembers(){

        return memberRepository.findAll();
    }

    //회원 id로 검색
    public Optional<Member> findOne(Long memberId){

        return memberRepository.findById(memberId);
    }


}

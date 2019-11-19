package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;


    @Test
    public void 회원가입() throws Exception {
        Member member = new Member();

        long savedId = memberService.join(member);
        System.out.println(savedId);

        assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test()
    public void 중복_회원_예외() throws Exception {
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        //member2.setName("kim1");

        memberService.join(member1);
        //memberService.join(member2);

        fail("예외가 발생해야 한다.");
    }
}
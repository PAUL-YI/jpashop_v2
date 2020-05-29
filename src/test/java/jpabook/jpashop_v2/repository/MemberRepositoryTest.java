package jpabook.jpashop_v2.repository;

import jpabook.jpashop_v2.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import javax.transaction.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MemberRepositoryTest
{


    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional // 테스트케이스에 있으면 바로 롤백 시켜버림
    @Rollback(false)// 근데 가끔 데이터를 넣어서 눈으로 직접 확인하고 싶을땐, 이 옵션을 사용하면 된다.
    public void dummy()
    {
        //given
        Member member = new Member();
        member.setUserName("memberB");

        //when
        Long savedId = memberRepository.save(member);
        Member findMember = memberRepository.findMember(savedId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUserName()).isEqualTo(member.getUserName());

        System.out.println("findMember == member : " + (findMember==member));
    }
}
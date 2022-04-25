package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.Optional;

@Repository
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //로그 찍어보는 용도
//    @Override
//    default Member save(Member member){
//        System.out.println("[DEBUG] SpringDataJpaMemberRepository");
//        return new Member();
//    }

    @Override
    Optional<Member> findByName(String name);
}

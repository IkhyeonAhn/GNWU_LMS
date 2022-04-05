package hello.hellospring.repository;

import hello.hellospring.domain.member;

import java.util.List;
import java.util.Optional;

public interface memberRepositroy {
    member save(member member);
    Optional<member> findByid(Long id);
    Optional<member> findByname(String name);
    List<member> findAll();
}

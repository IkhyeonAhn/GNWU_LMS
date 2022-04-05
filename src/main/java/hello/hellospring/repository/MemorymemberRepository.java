package hello.hellospring.repository;

import hello.hellospring.domain.member;

import java.util.*;

public class MemorymemberRepository implements memberRepositroy{

    private static Map<Long, member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public member save(member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);

        return member;
    }

    @Override
    public Optional<member> findByid(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<member> findByname(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<member> findAll() {
        return new ArrayList<>(store.values());
    }
}

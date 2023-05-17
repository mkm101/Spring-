package Hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements  MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); // 저장할 자료구조

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
               return store.get(memberId);
    }
}
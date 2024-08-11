package api.service;

import api.dto.member;
import org.springframework.stereotype.Component;

@Component
public interface apiService {

    member selectMember(member member);

    boolean selectMemberIdCheck(String id);

    boolean insertMember(member member);

    boolean updateMember(member member);

    boolean deleteMember(member member);

}

package api.dao;

import api.dto.member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface apiMapper {

    member selectMember(member member);

    int selectMemberIdCheck(String id);

    int insertMember(member member);

    int updateMember(member member);

    int deleteMember(member member);

}

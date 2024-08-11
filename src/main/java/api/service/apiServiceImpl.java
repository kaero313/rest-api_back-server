package api.service;

import api.dao.apiMapper;
import api.dto.member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class apiServiceImpl implements apiService{

    @Autowired
    private apiMapper apiMapper;

    @Override
    public member selectMember(member member) {

        member selectMember = apiMapper.selectMember(member);

        return selectMember;

    }

    @Override
    public boolean selectMemberIdCheck(String id) {

        return apiMapper.selectMemberIdCheck(id) > 0;
    }

    @Override
    public boolean insertMember(member member) {

        return apiMapper.insertMember(member) > 0;
    }

    @Override
    public boolean updateMember(member member) {

        return apiMapper.updateMember(member) > 0;
    }

    @Override
    public boolean deleteMember(member member) {

        return apiMapper.deleteMember(member) > 0;
    }
}

package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.ScMemberRepository;
import ua.edu.ukma.e_oss.model.SCMember;

@Service
public class ScMemberService {

    @Autowired
    private ScMemberRepository memberRepository;

    SCMember save (SCMember scMember){
        SCMember savedMember = memberRepository.save(scMember);
        return savedMember;
    }
}

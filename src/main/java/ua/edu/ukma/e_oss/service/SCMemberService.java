package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.SCMemberRepository;
import ua.edu.ukma.e_oss.model.SCMember;

import java.util.Optional;

@Service
public class SCMemberService {

    @Autowired
    private SCMemberRepository memberRepository;

    SCMember save(SCMember member){
        return memberRepository.save(member);
    }


    Iterable<SCMember> saveAll(Iterable<SCMember> members){
        return memberRepository.saveAll(members);
    }

    Optional<SCMember> findById(Integer id){
        return memberRepository.findById(id);
    }

    boolean existsById(Integer id){
        return memberRepository.existsById(id);
    }

    Iterable<SCMember> findAll(){
        return memberRepository.findAll();
    }

    Iterable<SCMember> findAllById(Iterable<Integer> members){
        return memberRepository.findAllById(members);
    }

    long count(){
        return memberRepository.count();
    }

    void deleteById(Integer id){
        memberRepository.deleteById(id);
    }

    void delete(SCMember scMember){
        memberRepository.delete(scMember);
    }

    void deleteAll(Iterable<? extends SCMember> members){
        memberRepository.deleteAll(members);
    }

    void deleteAll(){
        memberRepository.deleteAll();
    }
}

package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.SCMemberRepository;
import ua.edu.ukma.e_oss.model.SCMember;
import ua.edu.ukma.e_oss.model.User;

import java.util.Optional;

@Service
public class SCMemberService {

    @Autowired
    private SCMemberRepository memberRepository;

    public SCMember save(SCMember member){
        return memberRepository.save(member);
    }

    public Iterable<SCMember> saveAll(Iterable<SCMember> members){
        return memberRepository.saveAll(members);
    }

    public Optional<SCMember> findById(Integer id){
        return memberRepository.findById(id);
    }

    public boolean existsById(Integer id){
        return memberRepository.existsById(id);
    }

    public Iterable<SCMember> findAll(){
        return memberRepository.findAll();
    }

    public Iterable<SCMember> findAllById(Iterable<Integer> members){
        return memberRepository.findAllById(members);
    }

    public long count(){
        return memberRepository.count();
    }

    public void deleteById(Integer id){
        memberRepository.deleteById(id);
    }

    public void delete(SCMember scSCMember){
        memberRepository.delete(scSCMember);
    }

    public void deleteAll(Iterable<? extends SCMember> members){
        memberRepository.deleteAll(members);
    }

    public void deleteAll(){
        memberRepository.deleteAll();
    }

    public Optional<SCMember> findByUser(User user){
        return memberRepository.findByUser(user);
    }
}

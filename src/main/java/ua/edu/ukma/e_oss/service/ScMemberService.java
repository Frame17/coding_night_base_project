package ua.edu.ukma.e_oss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ukma.e_oss.dao.ScMemberRepository;
import ua.edu.ukma.e_oss.model.SCMember;

import java.util.List;
import java.util.Optional;

@Service
public class ScMemberService {

    @Autowired
    private ScMemberRepository memberRepository;

    SCMember save (SCMember scMember){
        SCMember savedMember = memberRepository.save(scMember);
        return savedMember;
    }

    Iterable<SCMember> saveAll(Iterable<SCMember> members){
        Iterable savedIterable = memberRepository.saveAll(members);
        return savedIterable;
    }

    Optional<SCMember> findByYd(Integer id){
        Optional<SCMember> foundMember = memberRepository.findById(id);
        //TODO validation
        return foundMember;
    }

    boolean existsById(Integer id){
        boolean exists=memberRepository.existsById(id);
        return exists;
    }

    Iterable<SCMember> findAll(){
        Iterable<SCMember> all = memberRepository.findAll();
        return all;
    }

    Iterable<SCMember> findAllById(Iterable<Integer> members){
        Iterable<SCMember> allById = memberRepository.findAllById(members);
        return allById;
    }

    long count(){
        long count = memberRepository.count();
        return count;
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

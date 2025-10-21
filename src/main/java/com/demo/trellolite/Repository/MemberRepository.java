package com.demo.trellolite.Repository;

import com.demo.trellolite.Entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface MemberRepository extends CrudRepository<Member, Long> {
    UserDetails findByEmail(String email);
}

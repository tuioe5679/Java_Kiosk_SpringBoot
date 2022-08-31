package com.tuioe.kiosk.repository;

import com.tuioe.kiosk.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Integer> {
}

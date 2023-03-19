package com.fir.system.Repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fir.system.Entity.User;

public interface UserRepository extends JpaRepository<User,String> {

}

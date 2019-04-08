package com.challenge.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.challenge.todo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    
    Role findByRoleName(String roleName);

}

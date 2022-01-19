package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByIdRoleAndLibelle(Long idRole, String libelle);
}
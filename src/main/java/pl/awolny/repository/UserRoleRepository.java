package pl.awolny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(String role);
}
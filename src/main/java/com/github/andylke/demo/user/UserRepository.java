package com.github.andylke.demo.user;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query(
      "SELECT a FROM User a WHERE a.title=?1 AND a.firstName=?2 AND a.lastName=?3 AND a.gender=?4")
  Optional<User> findBy(String title, String firstName, String lastname, String gender);

  @Query(
      "SELECT a.title as title, a.firstName as firstName, a.lastName as lastName FROM User a WHERE a.id=?1")
  Optional<FullName> findFullNameById(Long id);
}

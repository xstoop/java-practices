package com.example.demo.repository;

import com.example.demo.model.AyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface AyUserRepository extends JpaRepository<AyUser, String> {
    List<AyUser> findByName(String name);
    List<AyUser> findByNameLike(String name);
    List<AyUser> findByIdIn(Collection<Integer> id);

    AyUser findById(Integer id);
    void deleteById(Integer id);
}

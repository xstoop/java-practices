package com.example.demo.service;

import com.example.demo.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface AyUserService {
    AyUser findById(Integer id);

    List<AyUser> findByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<Integer> ids);

    List<AyUser> findAll();

    AyUser save(AyUser ayUser);

    void deleteById(Integer id);

    Page<AyUser> findAll(Pageable pageable);
}

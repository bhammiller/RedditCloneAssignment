package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Posts, Long> {
    List<Posts> findByUser(String ln);
}

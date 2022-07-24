package com.example.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dev.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}

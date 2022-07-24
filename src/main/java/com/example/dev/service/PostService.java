package com.example.dev.service;

import com.example.dev.model.Post;

public interface PostService {
	Iterable<Post> getAll();
    void saveData(Post post);
    Post getById(Long id);
    void deleteById(Long id);
}

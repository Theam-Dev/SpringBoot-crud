package com.example.dev.serviceImp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dev.model.Post;
import com.example.dev.repository.PostRepository;
import com.example.dev.service.PostService;

@Service
public class PostServiceImp implements PostService{
	
	@Autowired
	private PostRepository repo;

	@Override
	public Iterable<Post> getAll() {
		return repo.findAll();
	}

	@Override
	public void saveData(Post post) {
		this.repo.save(post);
	}

	@Override
	public Post getById(Long id) {
		 Optional<Post> optional = repo.findById(id);
	        Post post = null;
	        if (optional.isPresent()) {
	            post = optional.get();
	        } else {
	            throw new RuntimeException(" found for id :: " + id);
	        }
	        return post;
	}

	@Override
	public void deleteById(Long id) {
		this.repo.deleteById(id);
		
	}

}

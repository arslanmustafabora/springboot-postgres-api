package com.example.backendapi.controller;

import com.example.backendapi.exception.ResourceNotFoundException;
import com.example.backendapi.model.Post;
import com.example.backendapi.repository.PostRepository;
import com.example.backendapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("posts")
    public List<Post> getAllPosts() {
        return this.postRepository.findAll();
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable(value = "id") Long postId) throws ResourceNotFoundException {
        /**
         *  TODO
         */
        return null;
    }

    @PostMapping("posts")
    public Post createPost(@RequestBody Post post) {
        /**
         * TODO
         */
        return null;
    }

    @PutMapping("posts/{id}")
    public <postDetails> ResponseEntity<Post> updatePost(@PathVariable(value = "id") Long postId, @Validated @RequestBody Post postDetails) throws ResourceNotFoundException {
        /**
         * TODO
         */
        return null;
    }

    @DeleteMapping("posts/{id}")
    public Map<String, Boolean> deletePost(@PathVariable(value = "id") Long postId) throws ResourceNotFoundException {
        /**
         * TODO
         */
        return null;
    }
}

package com.proyectoDBAPP.proyectoDBAPP.Controllers;
import com.proyectoDBAPP.proyectoDBAPP.Models.Post;
import com.proyectoDBAPP.proyectoDBAPP.Models.User;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.PostRepository;
import com.proyectoDBAPP.proyectoDBAPP.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postRepository.save(post);
    }

    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post postDetails) {
        Post post = postRepository.findById(id).orElse(null);
        if (post != null) {
            post.setContent(postDetails.getContent());
            return postRepository.save(post);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
    }
}

package blog.project.controller;

import blog.project.entity.Post;
import blog.project.payload.PostDto;
import blog.project.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Oybek Karimjanov
 * Date : 4.13.2022
 * Project Name : springboot-blog-project
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPost(@RequestBody PostDto postDto){
        return new ResponseEntity<>(postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<PostDto>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOnePost(@PathVariable long id){
        return ResponseEntity.ok(postService.getOnePost(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editPost(@PathVariable long id, @RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.updatePost(id, postDto));
    }


}

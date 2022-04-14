package blog.project.controller;

import blog.project.payload.PostDto;
import blog.project.payload.PostResponse;
import blog.project.service.PostService;
import blog.project.utils.AppConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<PostResponse> getAllPosts(
           @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
           @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
           @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
           @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return new ResponseEntity<>(postService.getAllPosts(pageNo,  pageSize, sortBy, sortDir), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getOnePost(@PathVariable long id){
        return ResponseEntity.ok(postService.getOnePost(id));
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> editPost(@PathVariable long id, @RequestBody PostDto postDto){
        return ResponseEntity.ok(postService.updatePost(id, postDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable long id){
        postService.deletePost(id);
        return ResponseEntity.ok("Post is successfully deleted!");
    }




}

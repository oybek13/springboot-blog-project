package blog.project.service;

import blog.project.entity.Post;
import blog.project.payload.PostDto;
import blog.project.payload.PostResponse;

import java.util.List;

/**
 * Created by Oybek Karimjanov
 * Date : 4.13.2022
 * Project Name : springboot-blog-project
 */
public interface PostService {

    PostDto createPost(PostDto postDto);

    PostResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);

    PostDto getOnePost(long id);

    PostDto updatePost(long id, PostDto postDto);

    void deletePost(long id);
}

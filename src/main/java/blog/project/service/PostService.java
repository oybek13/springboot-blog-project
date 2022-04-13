package blog.project.service;

import blog.project.entity.Post;
import blog.project.payload.PostDto;

import java.util.List;

/**
 * Created by Oybek Karimjanov
 * Date : 4.13.2022
 * Project Name : springboot-blog-project
 */
public interface PostService {

    PostDto createPost(PostDto postDto);

    List<PostDto> getAllPosts(int pageNo, int pageSize);

    PostDto getOnePost(long id);

    PostDto updatePost(long id, PostDto postDto);

    void deletePost(long id);
}

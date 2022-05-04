package blog.project.service;

import blog.project.payload.CommentDto;

import java.util.List;

/**
 * Created by Oybek Karimjanov
 * Date : 5.4.2022
 * Project Name : springboot-blog-project
 */
public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto);

    List<CommentDto> getCommentsByPostId(long postId);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto editComment(Long postId, Long commentId, CommentDto commentDto);

    void deleteComment(Long postId, Long commentId);
}

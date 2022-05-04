package blog.project.service.impl;

import blog.project.entity.Comment;
import blog.project.entity.Post;
import blog.project.exception.BlogApiException;
import blog.project.exception.ResourceNotFoundException;
import blog.project.payload.CommentDto;
import blog.project.repository.CommentRepository;
import blog.project.repository.PostRepository;
import blog.project.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Oybek Karimjanov
 * Date : 5.4.2022
 * Project Name : springboot-blog-project
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Comment comment = mapToEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "id", postId));
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        return mapToDTO(savedComment);
    }

    @Override
    public List<CommentDto> getCommentsByPostId(long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments
                .stream()
                .map(comment -> mapToDTO(comment))
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto getCommentById(Long postId, Long commentId) {
        Comment postComment = getPostComment(postId, commentId);
        return mapToDTO(postComment);
    }

    @Override
    public CommentDto editComment(Long postId, Long commentId, CommentDto commentDto) {
        Comment comment = getPostComment(postId, commentId);
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        Comment saved = commentRepository.save(comment);
        return mapToDTO(saved);
    }

    @Override
    public void deleteComment(Long postId, Long commentId) {
        Comment comment = getPostComment(postId, commentId);
        commentRepository.delete(comment);
    }

    private CommentDto mapToDTO(Comment comment){
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setName(comment.getName());
        commentDto.setEmail(comment.getEmail());
        commentDto.setBody(comment.getBody());
        return commentDto;
    }

    private Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setId(commentDto.getId());
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;
    }
    public Comment getPostComment(Long postId, Long commentId){
        Post post =
                postRepository.findById(postId).orElseThrow(()->
                        new ResourceNotFoundException("Post", "id", postId));

        Comment comment =
                commentRepository.findById(commentId).orElseThrow(()->
                        new ResourceNotFoundException("Comment", "id", commentId));

        if (!comment.getPost().getId().equals(post.getId())){
            throw new  BlogApiException(HttpStatus.BAD_REQUEST, "Comment does not belong to post");
        }

        return comment;
    }

}

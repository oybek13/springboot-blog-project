package blog.project.repository;

import blog.project.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Oybek Karimjanov
 * Date : 5.4.2022
 * Project Name : springboot-blog-project
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostId(long postId);
}

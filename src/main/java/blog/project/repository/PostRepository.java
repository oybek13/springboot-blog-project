package blog.project.repository;

import blog.project.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Oybek Karimjanov
 * Date : 4.13.2022
 * Project Name : springboot-blog-project
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}

package blog.project.repository;

import blog.project.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Oybek Karimjanov
 * Date : 5.6.2022
 * Project Name : springboot-blog-project
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}

package blog.project.payload;

import lombok.*;

/**
 * Created by Oybek Karimjanov
 * Date : 5.4.2022
 * Project Name : springboot-blog-project
 */
@Data
public class CommentDto {
    private long id;
    private String name;
    private String email;
    private String body;
}

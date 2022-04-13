package blog.project.payload;

import lombok.Data;

/**
 * Created by Oybek Karimjanov
 * Date : 4.13.2022
 * Project Name : springboot-blog-project
 */
@Data
public class PostDto {
    private long id;
    private String title;
    private String description;
    private String content;
}

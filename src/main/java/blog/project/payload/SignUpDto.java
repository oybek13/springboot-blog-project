package blog.project.payload;

import lombok.Data;

/**
 * Created by Oybek Karimjanov
 * Date : 5.7.2022
 * Project Name : springboot-blog-project
 */
@Data
public class SignUpDto {
    private String name;
    private String username;
    private String email;
    private String password;
}

package blog.project.payload;

import lombok.Data;

/**
 * Created by Oybek Karimjanov
 * Date : 5.7.2022
 * Project Name : springboot-blog-project
 */
@Data
public class LoginDto {
    private String usernameOrEmail;
    private String password;
}

package app.jjickda.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Alias("SignUpDto")
public class SignUpDto {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Length(min = 64, max = 65, message = "패스워드가 SHA-256 형태가 아닙니다.")
    private String password;

    @NotBlank
    @Length(min = 2, max = 20)
    private String name;
}
